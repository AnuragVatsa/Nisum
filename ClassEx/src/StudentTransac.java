import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentTransac {
    private Connection conn;

    public StudentTransac(Connection conn) {
        this.conn = conn;
    }
    public boolean transferCredits(int fromStudentId, int toStudentId, double credits) {
        String deductQuery = "UPDATE students SET gpa = gpa - ? WHERE id = ? AND gpa >= ?";
        String addQuery = "UPDATE students SET gpa = gpa + ? WHERE id = ?";

        boolean success = false;
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement deductStmt = conn.prepareStatement(deductQuery)) {
                deductStmt.setDouble(1, credits);
                deductStmt.setInt(2, fromStudentId);
                deductStmt.setDouble(3, credits);
                int rowsDeducted = deductStmt.executeUpdate();
                if (rowsDeducted == 0) {
                    throw new SQLException("Error");
                }
            }
            try (PreparedStatement addStmt = conn.prepareStatement(addQuery)) {
                addStmt.setDouble(1, credits);
                addStmt.setInt(2, toStudentId);
                int rowsAdded = addStmt.executeUpdate();
                if (rowsAdded == 0) {
                    throw new SQLException("Target student not found");
                }
            }
            conn.commit();
            success = true;
        } catch (SQLException e) {
            System.err.println("Transaction failed: " + e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println("Rollback failed: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Error restoring auto-commit: " + e.getMessage());
            }
        }
        return success;
    }
}