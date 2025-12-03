package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class BookService implements Serializable {
    private String bookingId;
    private String vehicleId;
    private String serviceType;
    private LocalDate bookingDate;
    private String timeSlot;

    public BookService(String bookingId, String vehicleId, String serviceType, LocalDate bookingDate, String timeSlot) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.bookingDate = bookingDate;
        this.timeSlot = timeSlot;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookingId='" + bookingId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", bookingDate=" + bookingDate +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }
}
