package src.dao;

import src.model.Admin;
import src.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public static boolean insertAdmin(Admin admin) {
        String sql = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, admin.getName());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, admin.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Admin> getAllAdmins() {
        List<Admin> list = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Admin a = new Admin(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update and Delete methods can also be added similarly
    
}
