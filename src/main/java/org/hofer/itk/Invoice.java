package org.hofer.itk;

import java.sql.Date;

public class Invoice {

    private int id;
    private Date date;
    private String description;
    private double value;
    private boolean paid;

    public Invoice(int id, Date date, String description, double value, boolean paid) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.value = value;
        this.paid = paid;
    }

    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", paid=" + paid +
                '}';
    }
}
