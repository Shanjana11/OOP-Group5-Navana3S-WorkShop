package com.group5.navana3s_workshop.Shanjana;

import java.time.LocalDate;

public class RepairApproval {
    private String approvalId;
    private String bookingId;
    private String customerId;
    private String repairDescription;
    private double estimatedCost;
    private LocalDate requestDate;
    private String status; // Pending, Approved, Rejected
    private String customerResponse;

    public RepairApproval(String approvalId, String bookingId, String customerId, String repairDescription, double estimatedCost, LocalDate requestDate, String status, String customerResponse) {
        this.approvalId = approvalId;
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.repairDescription = repairDescription;
        this.estimatedCost = estimatedCost;
        this.requestDate = requestDate;
        this.status = status;
        this.customerResponse = customerResponse;
    }

    public RepairApproval(String bookingId, String repairDescription, double estimatedCost, LocalDate requestDate, String status) {
        this.bookingId = bookingId;
        this.repairDescription = repairDescription;
        this.estimatedCost = estimatedCost;
        this.requestDate = requestDate;
        this.status = status;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerResponse() {
        return customerResponse;
    }

    public void setCustomerResponse(String customerResponse) {
        this.customerResponse = customerResponse;
    }

    @Override
    public String toString() {
        return "RepairApproval{" +
                "approvalId='" + approvalId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", estimatedCost=" + estimatedCost +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", customerResponse='" + customerResponse + '\'' +
                '}';
    }
}
