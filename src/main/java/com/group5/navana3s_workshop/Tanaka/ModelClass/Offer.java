package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.time.LocalDate;

public class Offer {
    private String offerName;
    private int discountPercentage;
    private String startDate;
    private String endDate;
    private String offerId;
    private String title;
    private String description;
    private boolean active;
    private String applicability;
    private String editOffer;
    private String newOffer;
    private String endOffer;
    private LocalDate date;
    private String select;
    private String delete;

    public Offer(String offerName, int discountPercentage, String startDate, String endDate, String offerId, String title, String description, boolean active, String applicability, String editOffer, String newOffer, String endOffer, LocalDate date, String select, String delete) {
        this.offerName = offerName;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.active = active;
        this.applicability = applicability;
        this.editOffer = editOffer;
        this.newOffer = newOffer;
        this.endOffer = endOffer;
        this.date = date;
        this.select = select;
        this.delete = delete;
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

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getApplicability() {
        return applicability;
    }

    public void setApplicability(String applicability) {
        this.applicability = applicability;
    }

    public String getEditOffer() {
        return editOffer;
    }

    public void setEditOffer(String editOffer) {
        this.editOffer = editOffer;
    }

    public String getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(String newOffer) {
        this.newOffer = newOffer;
    }

    public String getEndOffer() {
        return endOffer;
    }

    public void setEndOffer(String endOffer) {
        this.endOffer = endOffer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerName='" + offerName + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", offerId='" + offerId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", applicability='" + applicability + '\'' +
                ", editOffer='" + editOffer + '\'' +
                ", newOffer='" + newOffer + '\'' +
                ", endOffer='" + endOffer + '\'' +
                ", date=" + date +
                ", select='" + select + '\'' +
                ", delete='" + delete + '\'' +
                '}';
    }
}
