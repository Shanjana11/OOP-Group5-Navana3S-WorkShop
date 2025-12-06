package com.group5.navana3s_workshop.Tanaka.ModelClass;

public class AccountOfficer {
    private String invoiceNo;
    private String customerName;
    private double amount;
    private String paymentStatus; // Paid / Unpaid
    private String date;

    public AccountOfficer(String invoiceNo, String customerName, double amount, String paymentStatus, String date) {
        this.invoiceNo = invoiceNo;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.date = date;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AccountOfficer{" +
                "invoiceNo='" + invoiceNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


