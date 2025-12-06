package com.group5.navana3s_workshop.Tasfia;

import java.time.LocalDate;

public class UrgentRequestModel {
    private String requestId;
    private String partId;
    private String partName;
    private int quantity;
    private LocalDate requiredBy;
    private String status;

    public UrgentRequestModel(String requestId, String partId, String partName, int quantity, LocalDate requiredBy, String status) {
        this.requestId = requestId;
        this.partId = partId;
        this.partName = partName;
        this.quantity = quantity;
        this.requiredBy = requiredBy;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public LocalDate getRequiredBy() {
        return requiredBy;
    }

    public void setRequiredBy(LocalDate requiredBy) {
        this.requiredBy = requiredBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UrgentRequestModel{" +
                "requestId='" + requestId + '\'' +
                ", partId='" + partId + '\'' +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", requiredBy=" + requiredBy +
                ", status='" + status + '\'' +
                '}';
    }
}
