package com.group5.navana3s_workshop.Tasfia;

import java.io.Serializable;

public class Delivery implements Serializable {
    private String partName;
    private int quantity;
    private String deliveryDate;

    public Delivery(String partName, int quantity, String deliveryDate) {
        this.partName = partName;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }
}
