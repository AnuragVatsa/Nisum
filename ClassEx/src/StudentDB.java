import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDB {
    private Connection conn;

    public StudentDB(Connection conn) {
        this.conn = conn;
    }

    public boolean insertStudent(Student student) {
        String query = "INSERT INTO students (id, name, email, date_of_birth, major, admission_date, gpa) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.setDate(4, student.getDateOfBirth());
            pstmt.setString(5, student.getMajor());
            pstmt.setDate(6, student.getAdmissionDate());
            pstmt.setDouble(7, student.getGpa());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error to insert student: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, email = ?, date_of_birth = ?, major = ?, admission_date = ?, gpa = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setDate(3, student.getDateOfBirth());
            pstmt.setString(4, student.getMajor());
            pstmt.setDate(5, student.getAdmissionDate());
            pstmt.setDouble(6, student.getGpa());
            pstmt.setInt(7, student.getId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int studentId) {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }
}