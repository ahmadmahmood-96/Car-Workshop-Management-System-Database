package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*System.out.println("This is our Dream Workshop Management System");
        String url = "jdbc:mysql://localhost:3306/workshop";
        String uname = "root";
        String pwd = "hailhydra";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, uname, pwd);
        Statement statement = connection.createStatement();
        String query = "SELECT username, password FROM admin";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.print(resultSet.getString(1));
            System.out.print("\t");
            System.out.println(resultSet.getString(2));
        }*/
        int[] array = new int[3];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        for (int i = 0; i < array.length; i++){

            array[i] = input.nextInt();
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
