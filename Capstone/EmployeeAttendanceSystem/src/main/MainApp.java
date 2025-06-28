package main;

import controller.AdminController;
import controller.AppController;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        AppController userCtrl = new AppController();
        AdminController adminCtrl = new AdminController();

        while (true) {
            System.out.println("Login as:\n (1) Admin \n (2) Employee \n (3) Exit:");
            String opt = in.next();

            if ("1".equals(opt)) {
                System.out.print("Admin : ");
                String u = in.next();
                System.out.print("Pass : ");
                String p = in.next();

                if (adminCtrl.login(u, p)) {
                    System.out.println("\nAdmin logged in\n");
                    adminLoop(in, adminCtrl);
                } else {
                    System.out.println("Invalid admin");
                }

            } else if ("2".equals(opt)) {
                System.out.print("Employee ID: ");
                int id = in.nextInt();
                userCtrl.login(id);
                System.out.println("Employee logged in");
                empLoop(in, userCtrl);

            } else {
                System.out.println("Bye!");
                break;
            }
        }

        in.close();
    }

    private static void empLoop(Scanner in, AppController c) throws SQLException {
        while (true) {
            System.out.println("(1) Check-In \n (2) Check-Out \n (3) History \n (4) History by Month \n (5) Logout");
            String o = in.next();

            if ("1".equals(o))
                c.markCheckIn();
            else if ("2".equals(o))
                c.markCheckOut();
            else if ("3".equals(o))
                c.viewHistory();
            else if ("4".equals(o)) {
                System.out.print("Enter Year (e.g., 2024): ");
                int year = in.nextInt();
                System.out.print("Enter Month (1-12): ");
                int month = in.nextInt();
                c.viewHistoryForMonth(year, month);
            } else {
                c.logout();
                break;
            }
        }
    }

    private static void adminLoop(Scanner in, AdminController c) throws Exception {
        while (true) {
            System.out.println("\tADMIN MODULE\nChoose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee Name");
            System.out.println("4. View Attendance");
            System.out.println("5. View Employees");
            System.out.println("6. Export to CSV");
            System.out.println("7. View All Attendance for a Specific Month");
            System.out.println("8. Logout");

            String o = in.next();
            switch (o) {
                case "1":
                    System.out.println("Give id as 'employee_id' 'name_of_employee'");
                    System.out.print("Enter ID and Name: ");
                    System.out.println(c.addEmployee(in.nextInt(), in.next()) ? "Added" : "Fail");
                    break;

                case "2":
                    System.out.print("Enter ID to remove: ");
                    System.out.println(c.removeEmployee(in.nextInt()) ? "Removed" : "Fail");
                    break;

                case "3":
                    System.out.print("Enter Employee ID to update: ");
                    int id = in.nextInt();
                    String currentName = c.getEmployeeNameById(id);
                    if (currentName == null) {
                        System.out.println("Employee not found.");
                    } else {
                        System.out.println("Current Name: " + currentName);
                        System.out.println("1. Change Name");
                        System.out.println("2. Exit");
                        String choice = in.next();

                        if ("1".equals(choice)) {
                            System.out.print("Enter New Name: ");
                            String newName = in.next();
                            if (c.updateEmployeeName(id, newName))
                                System.out.println("Name updated successfully.");
                            else
                                System.out.println("Update failed.");
                        } else {
                            System.out.println("Update cancelled.");
                        }
                    }
                    break;

                case "4":
                    System.out.println("\tEMPLOYEE MODULE\nView Attendance:");
                    System.out.println("1. View All");
                    System.out.println("2. View by Employee ID");
                    String attChoice = in.next();

                    if ("1".equals(attChoice))
                        c.viewAllAttendance();
                    else if ("2".equals(attChoice)) {
                        System.out.print("Enter Employee ID: ");
                        int empId = in.nextInt();
                        c.viewAttendance(empId);
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case "5":
                    c.viewAllEmployees();
                    break;

                case "6":
                    System.out.print("Enter filename for export (e.g., attendance.csv): ");
                    String filename = in.next();
                    System.out.println(c.exportAll(filename) ? "Exported Successfully" : "Export Failed");
                    break;

                case "7":
                	 System.out.println("Enter Year (e.g., 2024): ");
                     int year = in.nextInt();
                     System.out.println("Enter Month (1-12): ");
                     int month = in.nextInt();
                     c.viewAllAttendanceForMonth(year, month);
                     break;

                 default:
                     System.out.println("Invalid option.");
                     break;
                    
                case "8":
                   
                    System.out.println("Logged out.");
                    return;
            }
        }
    }
}
