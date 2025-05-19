import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallStoredProcedure {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/university_db";
        String user = "root";
        String password = "password";
        int studentId = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 CallableStatement cstmt = conn.prepareCall("{call getStudentById(?)}")) {
                cstmt.setInt(1, studentId);
                ResultSet rs = cstmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                } else {
                    System.out.println("Student not found.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error calling stored procedure: " + e.getMessage());
        }
    }
}