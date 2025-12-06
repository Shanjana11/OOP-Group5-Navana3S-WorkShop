package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private String vehicleNo;
    private int jobCardNo;
    private int customerId;
    private double amount;
    private String maintenanceDetails;
    private LocalDate invoiceDate;
    private String paymentType;

    public Invoice(String vehicleNo, int jobCardNo, int customerId, double amount, String maintenanceDetails, LocalDate invoiceDate, String paymentType) {
        this.vehicleNo = vehicleNo;
        this.jobCardNo = jobCardNo;
        this.customerId = customerId;
        this.amount = amount;
        this.maintenanceDetails = maintenanceDetails;
        this.invoiceDate = invoiceDate;
        this.paymentType = paymentType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getJobCardNo() {
        return jobCardNo;
    }

    public void setJobCardNo(int jobCardNo) {
        this.jobCardNo = jobCardNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMaintenanceDetails() {
        return maintenanceDetails;
    }

    public void setMaintenanceDetails(String maintenanceDetails) {
        this.maintenanceDetails = maintenanceDetails;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", jobCardNo=" + jobCardNo +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", maintenanceDetails='" + maintenanceDetails + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
