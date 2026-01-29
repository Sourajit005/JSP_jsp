package service;

import entity.Employee;
import java.sql.*;

public class EmployeeService {
    private Connection con;
    static String url = "jdbc:postgresql://localhost:5432/company";
    static String user = "postgres";
    static String password = "sourajit";

    public EmployeeService() {
        try {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int save(Employee employee) {
        String sql = "INSERT INTO employee (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getName());
            pst.setInt(3, employee.getAge());
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Returning a boolean is safer than returning a ResultSet to the Servlet
    public boolean isUserValid(String name) {
        String sql = "SELECT * from employee WHERE name=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next(); // Returns true if user exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int update(Employee employee) {
        int res = 0;
        // SQL query to update name and age where the ID matches
        String sql = "UPDATE employee SET name = ?, age = ? WHERE id = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, employee.getName());
            pst.setInt(2, employee.getAge());
            pst.setInt(3, employee.getId());

            res = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}