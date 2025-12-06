package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.time.LocalDate;

public class DeleteOffer {
    private String offerName;
    private double discountPercentage;
    private String startDate;
    private String endDate;

    public DeleteOffer(String offerName, double discountPercentage, String startDate, String endDate) {
        this.offerName = offerName;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DeleteOffer{" +
                "offerName='" + offerName + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
