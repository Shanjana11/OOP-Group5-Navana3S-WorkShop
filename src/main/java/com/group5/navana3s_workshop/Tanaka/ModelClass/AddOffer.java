package com.group5.navana3s_workshop.Tanaka.ModelClass;

public class AddOffer {
    private String offerName;
    private int discount;
    private String startStr;
    private String endStr;

    public AddOffer(String offerName, int discount, String startStr, String endStr) {
        this.offerName = offerName;
        this.discount = discount;
        this.startStr = startStr;
        this.endStr = endStr;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getStartStr() {
        return startStr;
    }

    public void setStartStr(String startStr) {
        this.startStr = startStr;
    }

    public String getEndStr() {
        return endStr;
    }

    public void setEndStr(String endStr) {
        this.endStr = endStr;
    }

    @Override
    public String toString() {
        return "AddOffer{" +
                "offerName='" + offerName + '\'' +
                ", discount=" + discount +
                ", startStr='" + startStr + '\'' +
                ", endStr='" + endStr + '\'' +
                '}';
    }
}
