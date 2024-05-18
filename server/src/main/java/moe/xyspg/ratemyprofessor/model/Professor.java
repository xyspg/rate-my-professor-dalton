package moe.xyspg.ratemyprofessor.model;

public class Professor {

  private Long id;
  private String name;
  private String department;
  private Double rating;

  public Professor(long id, String name, String department, double rating) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.rating = rating;
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

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }
}
