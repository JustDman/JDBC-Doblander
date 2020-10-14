package org.hofer.itk;

import java.sql.Date;

public interface InvoiceDao {

    /**
     * Shows all Invoices from the table "Invoice"
     */
    void showInvoices();

    /**
     * Inserts a new record into the database
     *
     * @param date        Date, the date the item was bought
     * @param description String, the description of the item
     * @param value       double, the price the item has on the invoice
     * @param paid        boolean, if it is paid already
     */
    void insertInvoice(Date date, String description, double value, boolean paid);

    /**
     * Updates a record in the table. All parameters are required
     *
     * @param id          int, id of the record
     * @param date        Date, the new Date of the invoice
     * @param description String, the new description of the invoice
     * @param value       double, the new value of the invoice
     * @param paid        boolean, the new status of the invoice (paid or not)
     */
    void updateInvoice(int id, Date date, String description, double value, Boolean paid);

    /**
     * Deletes a record from the database, if it exists
     * @param id int, the id of the record
     */
    void deleteInvoice(int id);
}
