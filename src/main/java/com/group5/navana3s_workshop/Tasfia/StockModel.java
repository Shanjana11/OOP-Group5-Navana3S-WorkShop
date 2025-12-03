package com.group5.navana3s_workshop.Tasfia;

public class StockModel {
    private String partId;
    private String partName;
    private int quantity;
    private String location;
    private String status;

    public StockModel(String partId, String partName, int quantity, String location, String status) {
        this.partId = partId;
        this.partName = partName;
        this.quantity = quantity;
        this.location = location;
        this.status = status;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StockModel{" +
                "partId='" + partId + '\'' +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
