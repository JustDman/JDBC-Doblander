package org.hofer.itk.Connectivity;

import java.sql.*;
import java.util.Locale;

public class Connectivity {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String table;

    /***
     * Sets up the connection to the database and executes the queries
     * @param database String, the database to be connected to
     * @param username String, the username of the database
     * @param password String, the password of the database
     * @param table String, the table to be connected to
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

    /**
     * Inserts a new record into the database
     *
     * @param date        Date, the date the item was bought
     * @param description String, the description of the item
     * @param value       double, the price the item has on the invoice
     * @param paid        boolean, if it is paid already
     */
    public void insertInvoice(Date date, String description, double value, boolean paid) {
        try {
            int temp;
            if (paid)
                temp = 1;
            else
                temp = 0;
            String query = String.format(Locale.ROOT, "INSERT INTO `Invoice` (`date`, `description`, `value`, `paid`) values('%s', '%s', '%f', '%d')", date.toString(), description, value, temp);
            this.stmt.executeUpdate(query);

            System.out.println("Successfully inserted record!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Updates a record in the table. All parameters are required
     *
     * @param id          int, id of the record
     * @param date        Date, the new Date of the invoice
     * @param description String, the new description of the invoice
     * @param value       double, the new value of the invoice
     * @param paid        boolean, the new status of the invoice (paid or not)
     */
    public void updateInvoice(int id, Date date, String description, double value, Boolean paid) {

        try {
            int temp;
            if (paid)
                temp = 1;
            else
                temp = 0;
            String query = String.format(Locale.ROOT, "UPDATE `Invoice` SET `date` = '%s', `description` = '%s', `value` = '%f', `paid` = '%d' WHERE (`id` = '%d')", date.toString(), description, value, temp, id);

            this.stmt.executeUpdate(query);

            System.out.println("Successfully altered record!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Deletes a record from the database, if it exists
     * @param id int, the id of the record
     */
    public void deleteInvoice(int id) {
        try {
            String query = String.format("DELETE FROM `Invoice` WHERE `id` = '%d'", id);

            this.stmt.executeUpdate(query);

            System.out.println("Successfully deleted record!");
        } catch (SQLException e) {
            System.out.println(e);
        }

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
