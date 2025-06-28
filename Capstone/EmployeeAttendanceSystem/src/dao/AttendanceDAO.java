
package dao;

import model.Attendance;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.sql.Date; // Only using java.sql.Date, avoids ambiguity
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public boolean markCheckIn(int empId) throws SQLException {
        String sql = "INSERT INTO attendance (employee_id, check_in, date) VALUES (?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            ps.setDate(3, Date.valueOf(LocalDate.now())); // java.sql.Date
            return ps.executeUpdate() == 1;
        }
    }

    public boolean markCheckOut(int empId) throws SQLException {
        String sql = "UPDATE attendance SET check_out = ? WHERE employee_id = ? AND date = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, empId);
            ps.setDate(3, Date.valueOf(LocalDate.now())); // java.sql.Date
            return ps.executeUpdate() == 1;
        }
    }

    public List<Attendance> findByEmployeeId(int empId) throws SQLException {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Attendance a = new Attendance();
                    a.setId(rs.getInt("id"));
                    a.setEmployeeId(rs.getInt("employee_id"));
                    a.setCheckIn(rs.getTimestamp("check_in"));
                    a.setCheckOut(rs.getTimestamp("check_out"));
                    a.setDate(rs.getDate("date").toLocalDate());
                    list.add(a);
                }
            }
        }
        return list;
    }
    
    public List<Attendance> findAll() throws SQLException {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance";
        try (Connection c = DBUtil.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setId(rs.getInt("id"));
                a.setEmployeeId(rs.getInt("employee_id"));
                a.setCheckIn(rs.getTimestamp("check_in"));
                a.setCheckOut(rs.getTimestamp("check_out"));
                a.setDate(rs.getDate("date").toLocalDate());
                list.add(a);
            }
        }
        return list;
    }
    public List<Attendance> findByEmployeeIdAndMonth(int employeeId, int year, int month) throws SQLException {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ? AND YEAR(date) = ? AND MONTH(date) = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Attendance a = new Attendance();
                    a.setId(rs.getInt("id"));
                    a.setEmployeeId(rs.getInt("employee_id"));
                    a.setCheckIn(rs.getTimestamp("check_in"));
                    a.setCheckOut(rs.getTimestamp("check_out"));
                    a.setDate(rs.getDate("date").toLocalDate());
                    list.add(a);
                }
            }
        }
        return list;
    }
    public List<Attendance> findAllByMonth(int year, int month) throws SQLException {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE YEAR(date) = ? AND MONTH(date) = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Attendance a = new Attendance();
                    a.setId(rs.getInt("id"));
                    a.setEmployeeId(rs.getInt("employee_id"));
                    a.setCheckIn(rs.getTimestamp("check_in"));
                    a.setCheckOut(rs.getTimestamp("check_out"));
                    a.setDate(rs.getDate("date").toLocalDate());
                    list.add(a);
                }
            }
        }
        return list;
    }

    
}