package org.hofer.itk;

import java.sql.Date;

public class App {
    public static void main(String[] args) {

        final String DATABASE = "test";
        final String USER = "root";
        final String PASS = "1234";
        String table = "Invoice";

        Date date = new Date(System.currentTimeMillis());

        Connectivity con = new Connectivity(DATABASE, USER, PASS, table);
        con.showInvoices();
        con.insertInvoice(date, "shoes", 50.5, true);
        con.showInvoices();
        con.updateInvoice(2,date,"nike air",60.5,false);
        con.showInvoices();
        con.deleteInvoice(4);
        con.showInvoices();
        con.closeConnection();
    }
}


