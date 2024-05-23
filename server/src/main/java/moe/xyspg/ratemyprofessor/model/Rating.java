package moe.xyspg.ratemyprofessor.model;

import moe.xyspg.ratemyprofessor.service.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

  public static boolean updateRating(Rating rating) throws SQLException {
    String query = "UPDATE ratings SET rating = ?, remark = ? WHERE id = ?";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
      stmt.setDouble(1, rating.getRating());
      stmt.setString(2, rating.getRemark());
      stmt.setLong(3, rating.getId());
      int affectedRows = stmt.executeUpdate();
      return affectedRows > 0;
    }
  }

}
