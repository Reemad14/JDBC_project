package com.sapiens.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Crud {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Enter 1 to add a row to the table");
        System.out.println("*******  *******  *******  *******  *******  ");
        System.out.println("Enter 2 to update a row at the table");
        System.out.println("*******  *******  *******  *******  *******  ");
        System.out.println("Enter 3 to delete a row at the table");
        System.out.println("*******  *******  *******  *******  *******  ");
        System.out.println("Enter 4 to view a row at the table");
        System.out.println("*******  *******  *******  *******  *******  ");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A Number :");
        String choose = scanner.next();

        switch (choose) {
            case "1":
                add();
                break;
            case "2":
                update();
                break;
            case "3":
                delete();
                break;
            case "4":
                view();
                break;
            default:
                System.out.println("Please enter a number between 1 to 4!!!");
        }

    }
    private static void add() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root","root123");
        System.out.println("Connection Established Successfully to employees DB");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String id  = scanner.next();
        System.out.println("Enter Name:");
        String name  = scanner.next();

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO DEVELOPERS VALUES("+id+",'"+name+"')";
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

    private static void update() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String id = scanner.next();
        System.out.println("Enter new Name:");
        String newName = scanner.next();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");

        Statement statement = connection.createStatement();
        String sql = "UPDATE DEVELOPERS SET NAME = '"+newName+"' WHERE ID = "+id;
        statement.executeUpdate(sql);

        System.out.println("Row updated successfully");
        connection.close();

    }
    private static void delete() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        String id = scanner.next();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");

        Statement statement = connection.createStatement();
        String sql = "DELETE FROM DEVELOPERS WHERE ID = "+id;
        statement.executeUpdate(sql);

        System.out.println("Row Deleted successfully");
        connection.close();
    }

    private static void view() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM DEVELOPERS";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("Developers Details : ");
        while (resultSet.next()){
            System.out.println("ID:" + resultSet.getString(1));
            System.out.println("Name:" + resultSet.getString(2));
        }
        connection.close();
    }


}
