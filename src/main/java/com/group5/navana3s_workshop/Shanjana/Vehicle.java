package com.group5.navana3s_workshop.Shanjana;

public class Vehicle {
    private String vehicleId;
    private String customerId;
    private String brand;
    private String model;
    private String registrationNumber;
    private int year;
    private String color;

    public Vehicle(String vehicleId, String customerId, String brand, String model, String registrationNumber, int year, String color) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.year = year;
        this.color = color;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
