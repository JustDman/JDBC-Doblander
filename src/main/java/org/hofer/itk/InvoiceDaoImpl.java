package org.hofer.itk;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {

    private List<Invoice> invoices;
    private int nextId;

    public InvoiceDaoImpl() {
        nextId = 1;
        this.invoices = new ArrayList<>();
    }

    /**
     * Shows all Invoices from the table "Invoice"
     */
    @Override
    public void showInvoices() {
        for (Invoice i : invoices) {
            System.out.println(i);
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
    @Override
    public void insertInvoice(Date date, String description, double value, boolean paid) {
        invoices.add(new Invoice(this.nextId, date, description, value, paid));
        this.nextId++;
        System.out.println("Successfully added a new Invoice!");
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
    @Override
    public void updateInvoice(int id, Date date, String description, double value, Boolean paid) {
        Iterator it = invoices.iterator();
        while (it.hasNext()) {
            Invoice inv = (Invoice) it.next();
            if (inv.getId() == id) {
                inv.setDate(date);
                inv.setDescription(description);
                inv.setValue(value);
                inv.setPaid(paid);
                System.out.println("Successfully changed Invoice!");
            }
        }
    }

    /**
     * Deletes a record from the database, if it exists
     *
     * @param id int, the id of the record
     */
    @Override
    public void deleteInvoice(int id) {
        Iterator it = invoices.iterator();
        while (it.hasNext()) {
            Invoice inv = (Invoice) it.next();
            if (inv.getId() == id) {
                it.remove();
                System.out.println("Successfully deleted Invoice!");
            }
        }
    }
}
