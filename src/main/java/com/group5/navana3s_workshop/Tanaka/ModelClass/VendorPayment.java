package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendorPayment {
    private String vendorName;
    private double dueAmount;
    private String dueDate;
    private String paymentStatus;

    public VendorPayment(String vendorName, double dueAmount, String dueDate, String paymentStatus) {
        this.vendorName = vendorName;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
        this.paymentStatus = paymentStatus;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "VendorPayment{" +
                "vendorName='" + vendorName + '\'' +
                ", dueAmount=" + dueAmount +
                ", dueDate='" + dueDate + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
