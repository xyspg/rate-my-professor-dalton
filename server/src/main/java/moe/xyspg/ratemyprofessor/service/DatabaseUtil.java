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



  public static int updateData(String query) throws SQLException {
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

      return stmt.executeUpdate();
    }
  }


}
