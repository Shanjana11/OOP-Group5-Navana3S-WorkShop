package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Feedback implements Serializable {
    private String feedbackId;
    private String customerName;
    private String serviceType;
    private String rating;
    private LocalDateTime submittedDate;

    public Feedback(String feedbackId, String customerName, String serviceType, String rating, LocalDateTime submittedDate) {
        this.feedbackId = feedbackId;
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.rating = rating;
        this.submittedDate = submittedDate;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDateTime getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDateTime submittedDate) {
        this.submittedDate = submittedDate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", rating=" + rating +
                ", submittedDate=" + submittedDate +
                '}';
    }
}
