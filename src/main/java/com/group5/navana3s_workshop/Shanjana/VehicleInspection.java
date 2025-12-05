package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.util.List;

public class VehicleInspection implements Serializable {
    private String vehicleId;
    private String conditionLevel;
    private String inspectDate;
    private boolean tyre;
    private boolean engine;
    private boolean brake;
    private boolean others;

    public VehicleInspection(String bookingId, String string, String condition, List<String> issues) {
    }

    @Override
    public String toString() {
        return "VehicleInspection{" +
                "vehicleId='" + vehicleId + '\'' +
                ", conditionLevel='" + conditionLevel + '\'' +
                ", inspectDate='" + inspectDate + '\'' +
                ", tyre=" + tyre +
                ", engine=" + engine +
                ", brake=" + brake +
                ", others=" + others +
                '}';
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getConditionLevel() {
        return conditionLevel;
    }

    public void setConditionLevel(String conditionLevel) {
        this.conditionLevel = conditionLevel;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }

    public boolean isTyre() {
        return tyre;
    }

    public void setTyre(boolean tyre) {
        this.tyre = tyre;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public boolean isBrake() {
        return brake;
    }

    public void setBrake(boolean brake) {
        this.brake = brake;
    }

    public boolean isOthers() {
        return others;
    }

    public void setOthers(boolean others) {
        this.others = others;
    }

    public VehicleInspection(String vehicleId, String conditionLevel, String inspectDate, boolean tyre, boolean engine, boolean brake, boolean others) {
        this.vehicleId = vehicleId;
        this.conditionLevel = conditionLevel;
        this.inspectDate = inspectDate;
        this.tyre = tyre;
        this.engine = engine;
        this.brake = brake;
        this.others = others;
    }
}
