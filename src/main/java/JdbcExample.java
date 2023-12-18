import javax.management.Query;
import java.sql.*;
import java.util.Queue;

public class JdbcExample {
    //java ; JDBC -> database
    // Java Database Connectivity is an API
    // 1 - The driver
    // SQL mysql, postgres
    // link to database
    // username, password
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/demo_db";
        String username = "root";
        String password = "1234";
        Statement statement = null;
        ResultSet resultSet = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connecting to database successfully");
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM students");
            statement = conn.createStatement();

                                  statement.execute("INSERT INTO students VALUES(NULL, 'JACK', 44)");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + " Name: " + name + " Age " + age);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Execute the sql statements

    }
}
