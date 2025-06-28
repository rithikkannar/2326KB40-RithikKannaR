package service;

import model.Attendance;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class ReportService {

    // Generates a map of LocalDate -> count of attendance records on that date
    public Map<LocalDate, Long> dailySummary(List<Attendance> list) {
        return list.stream()
            .collect(Collectors.groupingBy(Attendance::getDate, Collectors.counting()));
    }

    public void exportCSV(List<Attendance> list, String filename) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("EmployeeID,Date,CheckIn,CheckOut");
            for (Attendance attendance : list) {
                pw.printf("%d,%s,%s,%s%n",
                    attendance.getEmployeeId(),
                    attendance.getDate(),
                    attendance.getCheckIn(),
                    attendance.getCheckOut());
            }
        }
    }
}
