package com.employee.presentation;
import com.employee.util.DBUtil;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class EmployeeManagementApp {
    private EmployeeService employeeService;
    private Scanner scanner;

    public EmployeeManagementApp() {
        employeeService = new EmployeeService();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws SQLException {
        EmployeeManagementApp app = new EmployeeManagementApp();
        app.run();
    }
    public void run() throws SQLException {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addEmployee() throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);

        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully!");

    }

    private void deleteEmployee() {

    }

    private void updateEmployee() {

    }

    private void viewAllEmployees() {

    }




}
