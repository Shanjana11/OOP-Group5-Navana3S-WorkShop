package com.group5.navana3s_workshop.Karima.modelClass;

public class inventoryRequest {
    private String itemName;
    private Integer quantity;
    private String requestedBy;
    private String reason;
    private Integer currentStock;
    private String status;

    public inventoryRequest(String itemName, Integer quantity, String requestedBy, String reason, Integer currentStock, String status) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.requestedBy = requestedBy;
        this.reason = reason;
        this.currentStock = currentStock;
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "inventoryRequest{" +
                "itemName='" + itemName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", requestedBy='" + requestedBy + '\'' +
                ", reason='" + reason + '\'' +
                ", currentStock='" + currentStock + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
