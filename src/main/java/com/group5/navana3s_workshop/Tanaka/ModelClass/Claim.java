package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.math.BigDecimal;
import java.time.LocalDate;
//import java.type.ClaimType;

public class Claim {
    private int claimId;
    private String invoiceNo;
    private String customerName;
    private String claimType;
    private String issueDetails;
    private String approvalStatus;
    private String status;
    private LocalDate date;

    public Claim(int claimId, String invoiceNo, String customerName, String claimType, String issueDetails, String approvalStatus, String status, LocalDate date) {
        this.claimId = claimId;
        this.invoiceNo = invoiceNo;
        this.customerName = customerName;
        this.claimType = claimType;
        this.issueDetails = issueDetails;
        this.approvalStatus = approvalStatus;
        this.status = status;
        this.date = date;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(String issueDetails) {
        this.issueDetails = issueDetails;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", claimType='" + claimType + '\'' +
                ", issueDetails='" + issueDetails + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
