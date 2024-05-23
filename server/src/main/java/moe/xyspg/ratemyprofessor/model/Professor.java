package moe.xyspg.ratemyprofessor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import moe.xyspg.ratemyprofessor.service.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Professor {

  private Long id;
  private String name;
  private String department;
  private double rating;
  private List<Rating> ratings;

  public Professor(long id, String name, String department) {
    this.id = id;
    this.name = name;
    this.department = department;
  }

  /**
   * Fetch all professors
   * @return
   * @throws SQLException
   */
  public static List<Professor> fetchProfessors() throws SQLException {
    String query = "SELECT * FROM professors";
    List<Professor> results = new ArrayList<>();
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String department = rs.getString("department");
        results.add(new Professor(id, name, department));
      }
    }

    return results;
  }

  /**
   * Get ratings, remarks of a professor
   * @return
   * @throws SQLException
   */
  public static Professor getProfessorDetailedInformation(long id) throws SQLException {
    String query = "SELECT p.id, p.name, p.department, r.id AS rating_id, r.rating AS rating_value, r.remark FROM professors p LEFT JOIN ratings r ON p.id = r.professor_id WHERE p.id = ?";
    Professor professor = null;
    List<Rating> ratings = new ArrayList<>();
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ) {
      stmt.setLong(1, id);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        // first initialize professor
        if (professor == null) {
          long profId = rs.getLong("id");
          String name = rs.getString("name");
          String department = rs.getString("department");
          professor = new Professor(profId, name, department);
          System.out.println(professor);
        }
        long ratingId = rs.getInt("rating_id");
        double ratingValue = rs.getDouble("rating_value");
        String remark = rs.getString("remark");
        System.out.println(new Rating(ratingId, id, ratingValue, remark));
        ratings.add(new Rating(ratingId, id, ratingValue, remark));
      }
      if (professor != null) {
        professor.setRatings(ratings);
      }
    }
    return professor;
  }

  /**
   * Produces average rating
   * @param ratings
   */
  private void setRatings(List<Rating> ratings) {
    int count = 0;
    double sum = 0;
    for (Rating rating : ratings) {
      sum += rating.getRating();
      count++;
    }
    this.rating = sum / count;
    this.ratings = ratings;
  }


  @Override
  public String toString() {
    return "Professor{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", rating=" + rating +
            '}';
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  public double getRating() {
    return rating;
  }

  public List<Rating> getRatings() {
    return ratings;
  }
}
