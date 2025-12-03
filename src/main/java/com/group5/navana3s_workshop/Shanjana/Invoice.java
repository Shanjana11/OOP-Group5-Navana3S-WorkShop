package com.group5.navana3s_workshop.Shanjana;

import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private String bookingId;
    private LocalDate invoiceDate;
    private double amount;
    private String paymentStatus;
    private LocalDate dueDate;

    public Invoice(String invoiceId, String bookingId, LocalDate invoiceDate, double amount, String paymentStatus, LocalDate dueDate) {
        this.invoiceId = invoiceId;
        this.bookingId = bookingId;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.dueDate = dueDate;
    }

    public Invoice(String invoiceId, LocalDate dueDate, double amount, String paymentStatus) {
        this.invoiceId = invoiceId;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
