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
    String query = "SELECT * FROM professors";
    try {
      return DatabaseUtil.fetchProfessors(query);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  @GetMapping("/getById")
  public Professor getProfessorById(@RequestParam long id) {
    String query = "SELECT * FROM professors WHERE id = " + id;
    try {
      return DatabaseUtil.getProfessor(query);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

}
