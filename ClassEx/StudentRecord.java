import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRecord {
    private Connection conn;

    public StudentRecord(Connection conn) {
        this.conn = conn;
    }

    public StudentRecord getStudentById(int studentId) {
        Student student = null;
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDateOfBirth(rs.getDate("date_of_birth"));
                student.setMajor(rs.getString("major"));
                student.setAdmissionDate(rs.getDate("admission_date"));
                student.setGpa(rs.getDouble("gpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
        return student;
    }
}
class Student {
    private int id;
    private String name, email, major;
    private java.sql.Date dateOfBirth, admissionDate;
    private double gpa;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public java.sql.Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(java.sql.Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public java.sql.Date getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(java.sql.Date admissionDate) { this.admissionDate = admissionDate; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}