package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private int invoiceNumber;
    private double paymentAmount;
    private String paymentMethod;
    private String transactionId;
    private String invoiceStatus;

    public Payment(int invoiceNumber, double paymentAmount, String paymentMethod, String transactionId, String invoiceStatus) {
        this.invoiceNumber = invoiceNumber;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.invoiceStatus = invoiceStatus;
    }

    public Payment(int invoiceNumber, String transactionId, String paymentMethod, double paymentAmount, String invoiceStatus) {
        this.invoiceNumber = invoiceNumber;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.invoiceStatus = invoiceStatus;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "invoiceNumber=" + invoiceNumber +
                ", transactionId='" + transactionId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", invoiceStatus='" + invoiceStatus + '\'' +
                '}';
    }
}