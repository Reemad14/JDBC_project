package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root","root123");
        System.out.println("Connection Established Successfully to employees DB");

        String sql = "CREATE TABLE EMPLOYEEDETAILS(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20), AGE INT, DEPT VARCHAR(20)," +
                "DESIG VARCHAR(20), QUALIFICATION VARCHAR(20), EMAIL_ID VARCHAR(50), CONTACT VARCHAR(20)," +
                "SALARY DECIMAL(6.2), TOTAL_YEARS_OF_EXP INT, PRIMARY KEY(ID))";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("EMPLOYEEDETAILS Table Created Successfully");

        String sql1 = "CREATE TABLE MANAGERS(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20), PRIMARY KEY(ID))";
        Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);
        System.out.println("MANAGERS Table Created Successfully");

        String sql2 = "CREATE TABLE DEVELOPERS(ID INT NOT NULL AUTO_INCREMENT, NAME VARCHAR(20), PRIMARY KEY(ID))";
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate(sql2);
        System.out.println("DEVELOPERS Table Created Successfully");
    }
}
