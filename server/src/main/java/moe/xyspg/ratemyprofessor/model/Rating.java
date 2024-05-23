package moe.xyspg.ratemyprofessor.model;

public class Rating {
  private Long id;
  private Long professorId;
  private double rating;
  private String remark;

  public Rating(Long id, Long professorId, double rating, String remark) {
    this.id = id;
    this.professorId = professorId;
    this.rating = rating;
    this.remark = remark;
  }
}
