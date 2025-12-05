package com.group5.navana3s_workshop.Karima.modelClass;

public class complaint {
    private String complaintId;
    private String customerName;
    private String issue;
    private String status;


    public complaint(String complaintId, String customerName, String issue, String status) {
        this.complaintId = complaintId;
        this.customerName = customerName;
        this.issue = issue;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "complaint{" +
                "complaintId='" + complaintId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", issue='" + issue + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
