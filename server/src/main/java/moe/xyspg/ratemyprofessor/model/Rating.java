package moe.xyspg.ratemyprofessor.model;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

  public double getRating() {
    return rating;
  }

  @Override
  public String toString() {
    return "Rating{" +
        "id=" + id +
        ", professorId=" + professorId +
        ", rating=" + rating +
        ", remark='" + remark + '\'' +
        '}';
  }

  public Long getId() {
    return id;
  }

  public Long getProfessorId() {
    return professorId;
  }

  public String getRemark() {
    return remark;
  }
}
