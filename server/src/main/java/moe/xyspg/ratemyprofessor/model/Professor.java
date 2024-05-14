package moe.xyspg.ratemyprofessor.model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
  private Long id;
  private String name;
  private String department;
  private List<Double> ratings;

  public Professor(Long id, String name, String department, List<Double> ratings) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.ratings = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public List<Double> getRatings() {
    return ratings;
  }

  public void addRating(Double rating) {
    this.ratings.add(rating);
  }

  public double getAverageRating() {
    return ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
  }
}
