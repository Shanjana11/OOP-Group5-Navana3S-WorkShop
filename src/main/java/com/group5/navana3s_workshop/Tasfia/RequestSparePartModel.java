package com.group5.navana3s_workshop.Tasfia;

public class RequestSparePartModel {
    private String partName;
    private int quantity;
    private String reason;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RequestSparePartModel{" +
                "partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", reason='" + reason + '\'' +
                '}';
    }

    public RequestSparePartModel(String partName, int quantity, String reason) {
        this.partName = partName;
        this.quantity = quantity;
        this.reason = reason;
    }
}
