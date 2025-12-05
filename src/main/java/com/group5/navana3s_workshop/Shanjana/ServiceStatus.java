package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiceStatus implements Serializable {
    private String bookingId;
    private String status;

    @Override
    public String toString() {
        return "ServiceStatus{" +
                "bookingId='" + bookingId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ServiceStatus(String bookingId, String status) {
        this.bookingId = bookingId;
        this.status = status;
    }
}
