package com.group5.navana3s_workshop.Karima.modelClass;

public class salesHistory {
    private String customerName;
    private String vehicle;
    private double amount;
    private String date;

    public salesHistory(String customerName, String vehicle, double amount, String date) {
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "salesHistory{" +
                "customerName='" + customerName + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
