package moe.xyspg.ratemyprofessor.controller;

import moe.xyspg.ratemyprofessor.model.Rating;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
@RequestMapping("/ratings")
public class RatingController {

  @PostMapping(value = "/update", produces = "application/json")
  public void createRating(@RequestBody Rating rating) throws SQLException{
    Rating.createRating(rating);
  }
}
