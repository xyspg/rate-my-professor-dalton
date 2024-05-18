package moe.xyspg.ratemyprofessor.service;

import moe.xyspg.ratemyprofessor.model.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

  private static final String URL = "jdbc:mysql://localhost:3306/ratemyprofessor";
  private static final String USER = "root";

  private static final String PASSWORD = "";

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException("MySQL JDBC Driver not found", e);
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static List<Professor> fetchProfessors(String query) throws SQLException {
    List<Professor> results = new ArrayList<>();
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String department = rs.getString("department");
        double rating = rs.getDouble("rating");
        results.add(new Professor(id, name, department, rating));
      }
    }

    return results;
  }

  public static int updateData(String query) throws SQLException {
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

      return stmt.executeUpdate();
    }
  }


}
