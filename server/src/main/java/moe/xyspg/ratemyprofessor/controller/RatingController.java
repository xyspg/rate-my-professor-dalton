package moe.xyspg.ratemyprofessor.controller;

import moe.xyspg.ratemyprofessor.model.Rating;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/ratings")
public class RatingController {

  @PutMapping(value = "/update", produces = "application/json")
  public boolean updateRating(@RequestBody Rating rating) {
    try {
      return Rating.updateRating(rating);
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
