package moe.xyspg.ratemyprofessor.model;

import moe.xyspg.ratemyprofessor.service.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Professor {

  private Long id;
  private String name;
  private String department;
  private List<Rating> ratings;

  public Professor(long id, String name, String department) {
    this.id = id;
    this.name = name;
    this.department = department;
  }

  /**
   * Fetch all professors
   * @param query
   * @return
   * @throws SQLException
   */
  public static List<Professor> fetchProfessors(String query) throws SQLException {
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
   * @param query
   * @return
   * @throws SQLException
   */
  public static Professor getProfessorDetailedInformation(String query) throws SQLException {
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

      if (rs.next()) {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String department = rs.getString("department");
        return new Professor(id, name, department);
      }
    }

    return null;
  }


}
