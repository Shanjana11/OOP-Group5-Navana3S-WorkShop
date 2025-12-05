package com.group5.navana3s_workshop.Karima.modelClass;

import java.io.Serializable;

public class vehicleBooking implements Serializable {
    private String customerName;
    private String model;
    private String color;
    private String contact;


    public vehicleBooking(String customerName, String model, String color, String contact) {

        this.customerName = customerName;
        this.model = model;
        this.color = color;
        this.contact = contact;

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "vehicleBooking{" +
                "customerName='" + customerName + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
