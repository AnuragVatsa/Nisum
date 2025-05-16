import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourse {
    private Connection conn;
    public StudentCourse(Connection conn) {
        this.conn = conn;
    }
    public List<CourseEnrollment> getStudentCourses(int studentId) {
        List<CourseEnrollment> courses = new ArrayList<>();
        String query = "SELECT c.course_name, c.instructor, e.grade " +
                "FROM students s " +
                "JOIN enrollments e ON s.id = e.student_id " +
                "JOIN courses c ON e.course_id = c.id " +
                "WHERE s.id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CourseEnrollment enrollment = new CourseEnrollment();
                enrollment.setCourseName(rs.getString("course_name"));
                enrollment.setInstructor(rs.getString("instructor"));
                enrollment.setGrade(rs.getString("grade"));
                courses.add(enrollment);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving courses: " + e.getMessage());
        }
        return courses;
    }
}
class CourseEnrollment {
    private String courseName, instructor, grade;
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}