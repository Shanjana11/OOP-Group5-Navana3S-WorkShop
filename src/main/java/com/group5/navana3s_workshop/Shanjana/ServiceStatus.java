package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiceStatus implements Serializable {
    private String bookingId;
    private String vehicleId;
    private String serviceType;
    private String status;

    @Override
    public String toString() {
        return "ServiceStatus{" +
                "bookingId='" + bookingId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public ServiceStatus(String bookingId, String vehicleId, String serviceType, String status) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.status = status;
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
