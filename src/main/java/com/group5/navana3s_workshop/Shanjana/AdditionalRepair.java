package com.group5.navana3s_workshop.Shanjana;

import java.io.Serializable;
import java.time.LocalDate;

public class AdditionalRepair implements Serializable {
    private String bookingId;
    private String repairDescription;
    private double estimatedCost;
    private LocalDate date;

    @Override
    public String toString() {
        return "AdditionalRepair{" +
                "bookingId='" + bookingId + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", estimatedCost=" + estimatedCost +
                ", date=" + date +
                '}';
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AdditionalRepair(String bookingId, String repairDescription, double estimatedCost, LocalDate date) {
        this.bookingId = bookingId;
        this.repairDescription = repairDescription;
        this.estimatedCost = estimatedCost;
        this.date = date;
    }
}
