
import java.sql.*;

public class JDBCInsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Charani@1";

        String insertQuery =
                "INSERT INTO users (id, username, email) VALUES (?, ?, ?)";

        try (
                Connection con =
                        DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt =
                        con.prepareStatement(insertQuery)
        ) {

            // Insert first record
            pstmt.setInt(1, 4);
            pstmt.setString(2, "John Doe");
            pstmt.setString(3, "john@example.com");
            pstmt.executeUpdate();

            // Insert second record
            pstmt.setInt(1, 5);
            pstmt.setString(2, "Jane Doe");
            pstmt.setString(3, "jane@example.com");
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
