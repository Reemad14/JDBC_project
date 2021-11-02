package com.sapiens.jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SelectData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    List data = new ArrayList();

		try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root123");
        System.out.println("Connection Established Successfully to employees DB");



        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM EMPLOYEEDETAILS";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String id = resultSet.getString("ID");
            String name = resultSet.getString("NAME");
            String age = resultSet.getString("AGE");
            String dept = resultSet.getString("DEPT");
            String desig = resultSet.getString("DESIG");
            String qual = resultSet.getString("QUALIFICATION");
            String email = resultSet.getString("EMAIL_ID");
            String contact = resultSet.getString("CONTACT");
            String salary = resultSet.getString("SALARY");
            String years = resultSet.getString("TOTAL_YEARS_OF_EXP");
            data.add(id + " " + name + " " + age + " " + dept+ " " + desig+ " " + qual+ " " + email+ " " + contact+ " " + salary+ " " + years);
        }

        writeToFile(data, "C:\\Users\\reema.dabour\\OneDrive - Sapiens\\Desktop\\CoreJavaCourse\\JDBC_project\\src\\main\\java\\com\\sapiens\\jdbc\\Employee.txt");
        resultSet.close();
    } catch (Exception e) {
        System.out.println(e);
        }
    }
    private static void writeToFile(java.util.List list, String path) {
        BufferedWriter out = null;
        try {
            File file = new File(path);
            out = new BufferedWriter(new FileWriter(file, true));
            for (Object s : list  ) {
                out.write((String) s);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
        }
    }

}
