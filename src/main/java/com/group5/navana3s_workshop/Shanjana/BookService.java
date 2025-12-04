package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class BookService implements Serializable {
    private String vehicleId;
    private LocalDate date;
    private String timeSlot;
    private String serviceType;
    private String confirmationId;

    public BookService(String vehicleId, LocalDate date, String timeSlot, String serviceType, String confirmationId) {
        this.vehicleId = vehicleId;
        this.date = date;
        this.timeSlot = timeSlot;
        this.serviceType = serviceType;
        this.confirmationId = confirmationId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "vehicleId='" + vehicleId + '\'' +
                ", date=" + date +
                ", timeSlot='" + timeSlot + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", confirmationId='" + confirmationId + '\'' +
                '}';
    }
}
