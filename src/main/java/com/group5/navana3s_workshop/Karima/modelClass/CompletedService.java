package com.group5.navana3s_workshop.Karima.modelClass;

import java.time.LocalDate;

public class CompletedService {
    private  Integer serviceId;
    private  String vehicleNumber;
    private  String serviceType;
    private  String mechanicName;
    private  int serviceCost;

    public CompletedService(Integer serviceId, String vehicleNumber, String serviceType, String mechanicName,  int serviceCost) {
        this.serviceId = serviceId;
        this.vehicleNumber = vehicleNumber;
        this.serviceType = serviceType;
        this.mechanicName = mechanicName;
        this.serviceCost = serviceCost;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }



    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "CompletedService{" +
                "serviceId=" + serviceId +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", mechanicName='" + mechanicName + '\'' +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
