import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class accounts {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/accounts";
        String user = "root";
        String password = "Anurag@24";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        System.out.println("database before transaaction");
        System.out.println("-------");
        ResultSet rs=statement.executeQuery("Select * from accounts");
        while(rs.next())
        {
            System.out.println(rs.getInt()+" "+rs.getString("Name")+" "+rs.getInt("balance""));

        }
        connection.setAuotCommit(false);
        try{
            statement.executeUpdate("Update accunts set  balance =balance -100 where name='anurag");
            System.out.println("Opps something went wrong");
            if (true) throw  new RuntimeException("Simulated error");
            statement.executUpdate()
        }
    }
}
