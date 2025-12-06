package com.group5.navana3s_workshop.Tanaka.ModelClass;

public class EditOffer {
    private String offerName;
    private int discountPercentage;
    private String startDate;   // "2025-01-01" format
    private String endDate;

    public EditOffer(String offerName, int discountPercentage, String startDate, String endDate) {
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

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
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
        return "EditOffer{" +
                "offerName='" + offerName + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
