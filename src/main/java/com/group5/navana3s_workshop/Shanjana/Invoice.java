package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class Invoice implements Serializable {

    private String bookingId;
    private String vehicleId;
    private String serviceType;
    private LocalDate date;
    private double amount;
    private String status;

    @Override
    public String toString() {
        return "Invoice{" +
                "bookingId='" + bookingId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Invoice(String bookingId, String vehicleId, String serviceType, LocalDate date, double amount, String status) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }
}
