package org.hofer.itk;

import java.sql.*;
import java.util.Locale;

public class Connectivity {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String table;

    /***
     * Sets up the connection to the database and executes the queries
     * @param database the database to be connected to
     * @param username the username of the database
     * @param password the password of the database
     * @param table the table to be connected to
     */
    public Connectivity(String database, String username, String password, String table) {
        this.table = table;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + database, username, password);
            this.stmt = this.con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /***
     * Shows all Invoices from the table "Invoice"
     */
    public void showInvoices() {
        try {
            String query = "SELECT * FROM " + this.table;
            this.rs = this.stmt.executeQuery(query);

            while (this.rs.next()) {
                int id = this.rs.getInt("id");
                Date date = this.rs.getDate("date");
                String description = this.rs.getString("description");
                float value = this.rs.getFloat("value");
                boolean paid = this.rs.getBoolean("paid");

                System.out.printf("ID: %d; Date: %s; Description: %s; Value: %.2f; Paid: %b%n", id, date.toString(), description, value, paid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInvoice(Date date, String description, double value, boolean paid) {
        try {
            int temp;
            if (paid)
                temp = 1;
            else
                temp = 0;
            String query = String.format(Locale.ROOT,"INSERT INTO Invoice (date, description, value, paid) values('%s', '%s', '%f', '%d')", date.toString(), description, value, temp);
            System.out.printf("%f",value);
            stmt.executeUpdate(query);

            System.out.println("Daten erfolgreich eingefügt");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateInvoice(int id, Date date, String description, double value, Boolean paid) {

    }

    public void deleteInvoice(int id) {

    }

    public void closeConnection() {
        try {
            this.rs.close();
            this.stmt.close();
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
