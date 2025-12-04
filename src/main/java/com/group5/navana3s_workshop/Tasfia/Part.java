package com.group5.navana3s_workshop.Tasfia;

import java.io.Serializable;
import java.util.List;

public class Part implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private String partName;
    private String partId;
    private String availability;
    private double price;
    private List<String> alternativeParts;

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", partName='" + partName + '\'' +
                ", partId='" + partId + '\'' +
                ", availability='" + availability + '\'' +
                ", price=" + price +
                ", alternativeParts=" + alternativeParts +
                '}';
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getAlternativeParts() {
        return alternativeParts;
    }

    public void setAlternativeParts(List<String> alternativeParts) {
        this.alternativeParts = alternativeParts;
    }

    public Part(String partName, String partId, String availability, double price, List<String> alternativeParts) {
        this.partName = partName;
        this.partId = partId;
        this.availability = availability;
        this.price = price;
        this.alternativeParts = alternativeParts;
    }

    public Part(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
