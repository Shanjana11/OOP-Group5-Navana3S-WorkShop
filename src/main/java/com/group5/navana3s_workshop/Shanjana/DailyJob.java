package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class DailyJob implements Serializable {
    private String vehicleId;
    private String serviceType;
    private String technician;
    private String status;
    private LocalDate date;

    @Override
    public String toString() {
        return "DailyJob{" +
                "vehicleId='" + vehicleId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", technician='" + technician + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
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

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
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

    public DailyJob(String vehicleId, String serviceType, String technician, String status, LocalDate date) {
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.technician = technician;
        this.status = status;
        this.date = date;
    }
}
