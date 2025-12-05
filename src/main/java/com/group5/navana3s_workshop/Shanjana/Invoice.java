package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class Invoice implements Serializable {

    private String bookingId;
    private String serviceType;
    private double amount;
    private String status;
    private String paymentMethod;
    private LocalDate date;

    @Override
    public String toString() {
        return "Invoice{" +
                "bookingId='" + bookingId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date=" + date +
                '}';
    }

    public Invoice(String bookingId, String serviceType, double amount, String status, String paymentMethod, LocalDate date) {
        this.bookingId = bookingId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Invoice(String bookingId, String serviceType, double amount, String status) {
        this.bookingId = bookingId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }
}
