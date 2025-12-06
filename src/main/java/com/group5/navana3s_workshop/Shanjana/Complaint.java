package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class Complaint implements Serializable {
    private String bookingId;
    private String complaintText;

    @Override
    public String toString() {
        return "Complaint{" +
                "bookingId='" + bookingId + '\'' +
                ", complaintText='" + complaintText + '\'' +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public Complaint(String bookingId, String complaintText) {
        this.bookingId = bookingId;
        this.complaintText = complaintText;
    }
}
