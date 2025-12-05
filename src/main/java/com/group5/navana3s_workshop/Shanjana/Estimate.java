package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;

public class Estimate implements Serializable {
    private String bookingId;
    private String serviceType;
    private int quantity;
    private double unitPrice;
    private double totalCost;

    @Override
    public String toString() {
        return "Estimate{" +
                "bookingId='" + bookingId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalCost=" + totalCost +
                '}';
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Estimate(String bookingId, String serviceType, int quantity, double unitPrice, double totalCost) {
        this.bookingId = bookingId;
        this.serviceType = serviceType;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalCost = totalCost;
    }
}
