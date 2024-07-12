package tw.com.esumTest.seat_management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBExample {
	public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/seat_management?useSSL=false";
        String username = "root";
        String password = "12345678";

        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connection successful!");

            connection.close(); // 關閉連接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
