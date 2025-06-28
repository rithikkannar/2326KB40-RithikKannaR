package service;

import model.Attendance;
import dao.AttendanceDAO;

import java.sql.SQLException;
import java.util.List;

public class AttendanceService {
    private final AttendanceDAO attendanceDAO = new AttendanceDAO();

    /**
     * Marks the check-in for a given employee.
     */
    public boolean checkIn(int employeeId) throws SQLException {
        return attendanceDAO.markCheckIn(employeeId);
    }

    /**
     * Marks the check-out for a given employee.
     */
    public boolean checkOut(int employeeId) throws SQLException {
        return attendanceDAO.markCheckOut(employeeId);
    }

    /**
     * Returns the attendance history for a given employee.
     */
    public List<Attendance> getHistory(int employeeId) throws SQLException {
        return attendanceDAO.findByEmployeeId(employeeId);
    }
    public List<Attendance> getHistoryForMonth(int employeeId, int year, int month) throws SQLException {
        return attendanceDAO.findByEmployeeIdAndMonth(employeeId, year, month);
    }

}
