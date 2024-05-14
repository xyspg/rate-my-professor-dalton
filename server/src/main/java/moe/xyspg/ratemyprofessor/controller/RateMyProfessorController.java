package moe.xyspg.ratemyprofessor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class RateMyProfessorController {
  @GetMapping("/")
  public String index() {
    final String template = "API is running at %s";

    // Get current time
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTime = now.format(formatter);

    return String.format(template, formattedTime);
  }


}
