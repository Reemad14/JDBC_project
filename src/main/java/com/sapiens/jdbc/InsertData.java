package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String id  = scanner.next();
        System.out.println("Enter Name:");
        String name  = scanner.next();
        System.out.println("Enter Age:");
        String age  = scanner.next();
        System.out.println("Enter Department:");
        String dept  = scanner.next();
        System.out.println("Enter Designation:");
        String desig  = scanner.next();
        System.out.println("Enter Qualification:");
        String qual  = scanner.next();
        System.out.println("Enter Email:");
        String email  = scanner.next();
        System.out.println("Enter Contact:");
        String contact  = scanner.next();
        System.out.println("Enter Salary:");
        String salary  = scanner.next();
        System.out.println("Enter Total years of experiment:");
        String exp  = scanner.next();



        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO EMPLOYEEDETAILS VALUES("+id+",'"+name+"',"+age+",'"+dept+"','"+desig+"','"+qual+"','"+email+"','"+contact+"',"+salary+","+exp+")";
        int result = statement.executeUpdate(sql);
        if(result == 1) {
            System.out.println("Transaction is successful");
        }
        else{
            System.out.println("Transaction is Failed");
        }
        System.out.println("Table updated successfully");
        connection.close();
    }
}
