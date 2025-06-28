package controller;

import model.Attendance;
import service.AttendanceService;

import java.sql.SQLException;
import java.util.List;

public class AppController {
    private final AttendanceService attendanceService = new AttendanceService();
    private int currentUserId = -1;

    // Login with employee ID
    public boolean login(int employeeId) {
        this.currentUserId = employeeId;
        System.out.println("Employee " + employeeId + " logged in.");
        return true;
    }

    // Logout
    public void logout() {
        System.out.println("Employee " + currentUserId + " logged out.");
        currentUserId = -1;
    }

    // Mark Check-in
    public void markCheckIn() {
        try {
            if (attendanceService.checkIn(currentUserId)) {
                System.out.println("Checked in successfully.");
            } else {
                System.out.println("Check-in failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mark Check-out
    public void markCheckOut() {
        try {
            if (attendanceService.checkOut(currentUserId)) {
                System.out.println("Checked out successfully.");
            } else {
                System.out.println("Check-out failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Attendance History
    public void viewHistory() {
        try {
            List<Attendance> history = attendanceService.getHistory(currentUserId);
            if (history.isEmpty()) {
                System.out.println("No attendance history found.");
            } else {
                System.out.println("Attendance History:");
                for (Attendance a : history) {
                    System.out.printf("Date: %s | Check-in: %s | Check-out: %s%n",
                            a.getDate(), a.getCheckIn(), a.getCheckOut());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void viewHistoryForMonth(int year, int month) {
        try {
            List<Attendance> history = attendanceService.getHistoryForMonth(currentUserId, year, month);
            if (history.isEmpty()) {
                System.out.println("No attendance found for " + month + "/" + year + ".");
            } else {
                System.out.println("Attendance History for " + month + "/" + year + ":");
                for (Attendance a : history) {
                    System.out.printf("Date: %s | Check-in: %s | Check-out: %s%n",
                            a.getDate(), a.getCheckIn(), a.getCheckOut());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}