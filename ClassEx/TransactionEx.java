import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionEx {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nisumdb";
        String user = "root";
        String password = "Anurag@24";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                conn.setAutoCommit(false); // Start transaction

                try (PreparedStatement studentStmt = conn.prepareStatement(
                        "INSERT INTO students (id, name, age) VALUES (?, ?, ?)");
                     PreparedStatement enrollmentStmt = conn.prepareStatement(
                             "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)")) {
                    // Insert student
                    studentStmt.setInt(1, 3);
                    studentStmt.setString(2, "Alice Brown");
                    studentStmt.setInt(3, 19);
                    studentStmt.executeUpdate();

                    // Insert enrollment
                    enrollmentStmt.setInt(1, 3);
                    enrollmentStmt.setInt(2, 101);
                    enrollmentStmt.executeUpdate();

                    conn.commit(); // Commit transaction
                    System.out.println("Transaction successful!");
                } catch (SQLException e) {
                    System.out.println("Transaction failed: " + e.getMessage());
                    conn.rollback(); // Rollback on error
                } finally {
                    conn.setAutoCommit(true); // Restore auto-commit
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}