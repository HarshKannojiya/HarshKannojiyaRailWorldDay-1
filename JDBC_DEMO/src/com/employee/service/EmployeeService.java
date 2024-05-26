package com.employee.service;
import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

import java.sql.SQLException;
import java.util.List;
public class EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }
    public void addEmployee(Employee employee) throws SQLException {
        employeeDAO.addEmployee(employee);
    }
    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDAO.getAllEmployees();
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeDAO.updateEmployee(employee);
    }

}
