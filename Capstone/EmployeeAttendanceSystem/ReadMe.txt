EMPLOYEE ATTENDANCE TRACKER
---------------------------

Description:
-------------
This is a console-based Java application for tracking employee attendance. 
It supports admin login, employee registration, daily attendance marking, 
and report generation. The system uses Core Java, JDBC, and MySQL.

Technologies Used:
------------------
- Java (JDK 8 or higher)
- MySQL Database
- JDBC for database connectivity

Project Modules:
----------------
1. Employee Management:
   - Add, View, and Remove Employees

2. Attendance Management:
   - Mark attendance (Check-in / Check-out)
   - View attendance records

3. Reports:
   - Generate and view monthly attendance reports

Project Structure:
------------------
src/
│
├── main/
│   └── MainApp.java                # Entry point
│
├── controller/
│   ├── AdminController.java
│   └── AppController.java
│
├── dao/
│   ├── EmployeeDAO.java
│   └── AttendanceDAO.java
│
├── model/
│   ├── Employee.java
│   └── Attendance.java
│
├── service/
│   └── ReportService.java
│
├── db/
│   └── DBConnection.java          # MySQL connection utility

Database Tables:
----------------
1. employees
   - id (INT, PRIMARY KEY)
   - name (VARCHAR)
   - role (VARCHAR)

2. attendance
   - id (INT, PRIMARY KEY)
   - employee_id (INT, FOREIGN KEY REFERENCES employees(id) ON DELETE CASCADE)
   - date (DATE)
   - status (VARCHAR)

How to Run:
-----------
1. Open the project in Eclipse or any Java IDE.
2. Make sure MySQL is running and the database is created.
3. Update DBConnection.java with your database credentials.
4. Compile and run MainApp.java.

Admin Functions:
----------------
- Add Employee
- Remove Employee
- Update Employee
- View All Employees
- Generate Reports

Employee Functions:
-------------------
- Mark Attendance
- View Attendance History

Team Members:
-------------
- Developed By Rithik Kanna R 

Institution:
------------
KG College Of Arts And Science
Department of Computer Technology
Mini Project Submission – Full Stack Development
Submission Date: 28/06/2025

