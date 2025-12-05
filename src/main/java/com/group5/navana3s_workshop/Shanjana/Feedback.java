package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Feedback implements Serializable {
    private String bookingId;
    private String serviceType;
    private String rating;
    private LocalDateTime submittedAt;

    @Override
    public String toString() {
        return "Feedback{" +
                "bookingId='" + bookingId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", rating='" + rating + '\'' +
                ", submittedAt=" + submittedAt +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public Feedback(String bookingId, String serviceType, String rating, LocalDateTime submittedAt) {
        this.bookingId = bookingId;
        this.serviceType = serviceType;
        this.rating = rating;
        this.submittedAt = submittedAt;
    }
}
