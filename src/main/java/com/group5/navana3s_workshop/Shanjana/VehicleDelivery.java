package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;

public class VehicleDelivery implements Serializable {

    private String bookingId;
    private String vehicleId;
    private String serviceType;
    private String deliveryStatus;

    public VehicleDelivery(String bookingId, String vehicleId, String serviceType, String deliveryStatus) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.deliveryStatus = deliveryStatus;
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

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return "VehicleDelivery{" +
                "bookingId='" + bookingId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                '}';
    }
}
