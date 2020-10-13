package org.hofer.itk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Produkte");
            while (rs.next()) {
                int i = 1;
                System.out.println(rs.getInt(i) + " " + rs.getString(i + 1));
                i = i + 2;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


