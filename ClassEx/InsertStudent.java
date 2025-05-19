import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nisumdb";
        String user = "root";
        String password = "Anurag@24";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {
                String sql = "INSERT INTO students (id, name, age) VALUES (1, 'John Doe', 20)";
                int rowsAffected = stmt.executeUpdate(sql);
                System.out.println(rowsAffected + " row(s) inserted.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
    }
}