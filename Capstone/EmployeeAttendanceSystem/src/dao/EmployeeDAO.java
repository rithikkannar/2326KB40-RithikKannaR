package dao;

import model.Employee;
import util.DBUtil;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {

	public boolean add(Employee e) throws SQLException {
	    if (findById(e.getId()) != null) {
	        return false; // Employee already exists
	    }

	    String sql = "INSERT INTO employees (id, name) VALUES (?, ?)";
	    try (Connection c = DBUtil.getConnection();
	         PreparedStatement ps = c.prepareStatement(sql)) {
	        ps.setInt(1, e.getId());
	        ps.setString(2, e.getName());
	        return ps.executeUpdate() == 1;
	    }
	}
	public String getEmployeeNameById(int id) throws SQLException {
	    String sql = "SELECT name FROM employees WHERE id = ?";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getString("name");
	            }
	        }
	    }
	    return null;
	}


    public boolean remove(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    public Employee findById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("id"), rs.getString("name"));
                }
            }
        }
        return null;
    }
    public boolean updateEmployeeName(int id, String newName) throws SQLException {
        String sql = "UPDATE employees SET name = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }


    public List<Employee> findAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("id"), rs.getString("name")));
            }
        }
        return list;
    }
}
