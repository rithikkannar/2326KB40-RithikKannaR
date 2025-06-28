package model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Attendance {
    private int id, employeeId;
    private Timestamp checkIn, checkOut;
    private LocalDate date;

    public Attendance() {}

    public int getId() { return id; }
    public int getEmployeeId() { return employeeId; }
    public Timestamp getCheckIn() { return checkIn; }
    public Timestamp getCheckOut() { return checkOut; }
    public LocalDate getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setCheckIn(Timestamp checkIn) { this.checkIn = checkIn; }
    public void setCheckOut(Timestamp checkOut) { this.checkOut = checkOut; }
    public void setDate(LocalDate date) { this.date = date; }
}