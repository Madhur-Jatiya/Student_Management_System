package Student_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Dao {

    Student student = new Student();
    Address address = new Address();
    ResultSet rs = null;
    PreparedStatement psmt = null;
    Connection con = null;

    public Dao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "My$ql123");
    }

    public void addStudent() throws SQLException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter student Name (quit for exit) = ");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("quit")) {
                break;
            }
            student.setName(s);
            System.out.print("Enter student Email = ");
            student.setEmail(sc.nextLine());
            System.out.print("Enter student Mobile Number = ");
            try {
                student.setMobile(sc.nextLong());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sc.nextLine();
            System.out.print("Enter student House number = ");
            address.setStreet(sc.nextLine());
            System.out.print("Enter student Colony = ");
            address.setLandmark(sc.nextLine());
            System.out.print("Enter student City = ");
            address.setDistrict(sc.nextLine());
            System.out.print("Enter student State = ");
            address.setState(sc.nextLine());
            System.out.print("Enter student Country = ");
            address.setCountry(sc.nextLine());

            System.out.println("");
            System.out.println("");

            psmt = con.prepareStatement("insert into Address(street,landmark,city,state,country) values(?,?,?,?,?)");
            psmt.setString(1, address.getStreet());
            psmt.setString(2, address.getLandmark());
            psmt.setString(3, address.getDistrict());
            psmt.setString(4, address.getState());
            psmt.setString(5, address.getCountry());
            psmt.executeUpdate();

            psmt = con.prepareStatement("SELECT id FROM address ORDER BY id DESC LIMIT 1");
            rs = psmt.executeQuery();

            while (rs.next()) {
                psmt = con.prepareStatement("insert into students(student_name,email,number, address_id) values(?,?,?,?)");
                psmt.setString(1, student.getName());
                psmt.setString(2, student.getEmail());
                psmt.setLong(3, student.getMobile());
                psmt.setInt(4, rs.getInt("id"));
                psmt.execute();
            }

            System.out.println("");
            System.out.println("");
        }

    }

    public void getData() throws SQLException {
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM students JOIN address ON students.address_id = address.id");
        int count = 1;
        while (rs.next()) {
            System.out.println("Serial number = " + count);
            System.out.println("Student Name = " + rs.getString("student_name"));
            System.out.println("Student Email = " + rs.getString("email"));
            System.out.println("Student number = " + Long.parseLong(rs.getString("number")));
            System.out.println("Student house number = " + rs.getString("street"));
            System.out.println("Student colony = " + rs.getString("landmark"));
            System.out.println("Student city = " + rs.getString("city"));
            System.out.println("Student state = " + rs.getString("state"));
            count++;
            System.out.println("");
        }
    }
}
