package src.dao;

import src.model.Salary;
import src.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO {

    public static boolean insertSalary(Salary salary) {
        String sql = "INSERT INTO salary (employee_id, monthly_salary, bonus) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salary.getEmployeeId());
            stmt.setDouble(2, salary.getMonthlySalary());
            stmt.setDouble(3, salary.getBonus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Salary> getAllSalaries() {
        List<Salary> list = new ArrayList<>();
        String sql = "SELECT * FROM salary";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Salary s = new Salary(
                    rs.getInt("id"),
                    rs.getInt("employee_id"),
                    rs.getDouble("monthly_salary"),
                    rs.getDouble("bonus")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
