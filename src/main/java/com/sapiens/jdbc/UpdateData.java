package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String id = scanner.next();
        System.out.println("Enter new Name:");
        String newName = scanner.next();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");

        Statement statement = connection.createStatement();
        String sql = "UPDATE EMPLOYEEDETAILS SET NAME = '"+newName+"' WHERE ID = "+id;
        statement.executeUpdate(sql);

        System.out.println("Row updated successfully");
        connection.close();

    }
}
