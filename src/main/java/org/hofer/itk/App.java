package org.hofer.itk;

public class App {
    public static void main(String[] args) {

        Connectivity con = new Connectivity("test", "root", "1234", "Invoice");
        con.showInvoices();
        con.closeConnection();
    }
}


