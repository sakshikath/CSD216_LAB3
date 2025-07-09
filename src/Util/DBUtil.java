package src.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/hr_management";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println(" Database connected successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println(" Database connection failed!");
            e.printStackTrace();
        }
    }
}
