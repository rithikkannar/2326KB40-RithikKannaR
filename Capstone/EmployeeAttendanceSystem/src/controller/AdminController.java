package controller;

import service.ReportService;

import dao.EmployeeDAO;
import dao.AttendanceDAO;

import model.Employee;
import model.Attendance;

import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public class AdminController {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private AttendanceDAO attendanceDAO = new AttendanceDAO();
    private ReportService reportService = new ReportService();

    public boolean login(String u, String p) {
        return "admin".equals(u) && "admin".equals(p);
    }

    public boolean addEmployee(int id, String name) {
        try {
            Employee e = new Employee(id, name);
            if (!employeeDAO.add(e)) {
                System.out.println("EMPLOYEE ALREADY EXISTS");
                return false;
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeEmployee(int id) throws SQLException {
        return employeeDAO.remove(id);
    }

    public boolean updateEmployeeName(int id, String newName) {
        try {
            return employeeDAO.updateEmployeeName(id, newName);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getEmployeeNameById(int id) {
        try {
            return employeeDAO.getEmployeeNameById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void viewAllEmployees() throws SQLException {
        List<Employee> list = employeeDAO.findAll();
        System.out.println("---- Employee List ----\n");
        for (Employee e : list) {
            System.out.printf("ID: %d, Name: %s%n", e.getId(), e.getName());
        }
        System.out.println("\n---- End Of List ----");
    }

    public void viewAllAttendance() throws SQLException {
        List<Attendance> list = attendanceDAO.findAll();
        System.out.println("---- All Attendance Records ----");
        for (Attendance a : list) {
            System.out.printf("EmpID: %d, Date: %s, CheckIn: %s, CheckOut: %s%n",
                    a.getEmployeeId(), a.getDate(), a.getCheckIn(), a.getCheckOut());
        }
        System.out.println("---- End of All Attendance Records ----");
    }

    public void viewAttendance(int employeeId) throws SQLException {
        List<Attendance> list = attendanceDAO.findByEmployeeId(employeeId);
        if (list.isEmpty()) {
            System.out.println("No records found for Employee ID: " + employeeId);
        } else {
            System.out.println("\n---- Attendance for Employee ID: " + employeeId + " ----\n");
            for (Attendance a : list) {
                System.out.printf("Date: %s, CheckIn: %s, CheckOut: %s%n",
                        a.getDate(), a.getCheckIn(), a.getCheckOut());
            }
            System.out.println("\n---- End of Employee Attendance ----");
        }
    }
    public void viewAllAttendanceForMonth(int year, int month) throws SQLException {
        List<Attendance> list = attendanceDAO.findAllByMonth(year, month);
        if (list.isEmpty()) {
            System.out.println("No attendance records found for " + month + "/" + year);
        } else {
            System.out.println("\n---- All Attendance for " + month + "/" + year + " ----");
            for (Attendance a : list) {
                System.out.printf("Employee ID: %d | Date: %s | CheckIn: %s | CheckOut: %s%n",
                        a.getEmployeeId(), a.getDate(), a.getCheckIn(), a.getCheckOut());
            }
            System.out.println("---- End of All Attendance for " + month + "/" + year + " ----");
        }
    }

    public boolean exportAll(String filename) throws IOException, SQLException {
        List<Attendance> list = attendanceDAO.findAll();
        reportService.exportCSV(list, filename);
        System.out.println("Exported to " + filename);
        return true;
    }

    public void logout() {
        System.out.println("Admin logged out.");
    }
}
