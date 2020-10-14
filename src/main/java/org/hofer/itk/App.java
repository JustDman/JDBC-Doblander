package org.hofer.itk;

import java.sql.Date;

public class App {
    public static void main(String[] args) {

        final String DATABASE = "test";
        final String USER = "root";
        final String PASS = "1234";
        String table = "Invoice";

        Date date = new Date(System.currentTimeMillis());

        SQLInvoiceDaoImpl con = new SQLInvoiceDaoImpl(DATABASE, USER, PASS, table);
        con.showInvoices();
        con.insertInvoice(date, "shoes", 50.5, true);
        con.showInvoices();
        con.updateInvoice(2,date,"nike air",60.8,false);
        con.showInvoices();
        con.deleteInvoice(5);
        con.showInvoices();
        con.closeConnection();

        /*
        InvoiceDaoImpl inv = new InvoiceDaoImpl();
        inv.insertInvoice(date, "shoes", 50.5, true);
        inv.insertInvoice(date, "nike air", 60.5, false);
        inv.showInvoices();
        inv.updateInvoice(2,date,"old pair", 30, true);
        inv.showInvoices();
        inv.deleteInvoice(2);
        inv.showInvoices();
         */
    }
}


