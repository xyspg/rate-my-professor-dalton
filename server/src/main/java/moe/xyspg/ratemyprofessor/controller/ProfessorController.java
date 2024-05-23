package moe.xyspg.ratemyprofessor.controller;


import moe.xyspg.ratemyprofessor.model.Professor;
import moe.xyspg.ratemyprofessor.service.DatabaseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {


  @GetMapping
  public List<Professor> getAllProfessors() {
    try {
      return Professor.fetchProfessors();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @GetMapping(value = "/getById", produces = "application/json")
  public Professor getProfessorById(@RequestParam long id) {
    try {
      return Professor.getProfessorDetailedInformation(id);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

}
