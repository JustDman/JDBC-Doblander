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
        System.out.println();
        con.updateInvoice(4,date,"nike air",60.5,false);
        con.showInvoices();
        con.closeConnection();
    }
}


