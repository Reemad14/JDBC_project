package com.sapiens.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DropTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chooses Table Name You Want To Drop:");
        String tableName = scanner.next();

        Statement statement = connection.createStatement();
        String sql = "DROP TABLE "+ tableName;
        statement.executeUpdate(sql);

        System.out.println("Table was dropped successfully");
        connection.close();

    }
}
