package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiceHistory implements Serializable {
    private String bookingId;
    private LocalDate serviceDate;
    private String serviceType;
    private String invoiceNo;
    private double amount;
    private String status;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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

    public ServiceHistory(String bookingId, LocalDate serviceDate, String serviceType, String invoiceNo, double amount, String status) {

        this.bookingId = bookingId;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.invoiceNo = invoiceNo;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceHistory{" +
                "bookingId='" + bookingId + '\'' +
                ", serviceDate=" + serviceDate +
                ", serviceType='" + serviceType + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
