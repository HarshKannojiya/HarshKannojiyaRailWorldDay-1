package com.employee.dao;
import com.employee.model.Employee;
import com.employee.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDepartment());
            stmt.setDouble(3, employee.getSalary());
            stmt.executeUpdate();
        }
    }
}
