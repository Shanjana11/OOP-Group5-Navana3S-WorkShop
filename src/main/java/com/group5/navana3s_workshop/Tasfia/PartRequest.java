package com.group5.navana3s_workshop.Tasfia;

public class PartRequest {
    private String requestId;
    private String partName;
    private int quantity;
    private String reason;
    private String TechnicianName;
    private String status;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTechnicianName() {
        return TechnicianName;
    }

    public void setTechnicianName(String technicianName) {
        TechnicianName = technicianName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PartRequest(String requestId, String partName, int quantity, String reason, String technicianName, String status) {
        this.requestId = requestId;
        this.partName = partName;
        this.quantity = quantity;
        this.reason = reason;
        TechnicianName = technicianName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "PartRequest{" +
                "requestId='" + requestId + '\'' +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", reason='" + reason + '\'' +
                ", TechnicianName='" + TechnicianName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
