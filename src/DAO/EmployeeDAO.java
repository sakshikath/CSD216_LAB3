package src.dao;

import src.model.Employee;
import src.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static boolean insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee_detail (name, email, department, role, hire_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setString(3, emp.getDepartment());
            stmt.setString(4, emp.getRole());
            stmt.setDate(5, Date.valueOf(emp.getHireDate()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee_detail";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee e = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("role"),
                    rs.getDate("hire_date").toLocalDate()
                );
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
