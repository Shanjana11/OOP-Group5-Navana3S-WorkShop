package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RequestWarranty implements Serializable {
    private String bookingId;
    private String partName;
    private String description;
    private LocalDateTime submittedAt;

    @Override
    public String toString() {
        return "RequestWarranty{" +
                "bookingId='" + bookingId + '\'' +
                ", partName='" + partName + '\'' +
                ", description='" + description + '\'' +
                ", submittedAt=" + submittedAt +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public RequestWarranty(String bookingId, String partName, String description, LocalDateTime submittedAt) {
        this.bookingId = bookingId;
        this.partName = partName;
        this.description = description;
        this.submittedAt = submittedAt;
    }
}
