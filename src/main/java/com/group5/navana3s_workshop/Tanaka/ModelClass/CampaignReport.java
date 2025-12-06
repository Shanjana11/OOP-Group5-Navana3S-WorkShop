package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.time.LocalDate;

public class CampaignReport {
    private String campaignName;
    private int customerCount;
    private int reach;
    private int clicks;
    private int conversions;
    private String status;

    public CampaignReport(String campaignName, int customerCount, int reach, int clicks, int conversions, String status) {
        this.campaignName = campaignName;
        this.customerCount = customerCount;
        this.reach = reach;
        this.clicks = clicks;
        this.conversions = conversions;
        this.status = status;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getConversions() {
        return conversions;
    }

    public void setConversions(int conversions) {
        this.conversions = conversions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CampaignReport{" +
                "campaignName='" + campaignName + '\'' +
                ", customerCount=" + customerCount +
                ", reach=" + reach +
                ", clicks=" + clicks +
                ", conversions=" + conversions +
                ", status='" + status + '\'' +
                '}';
    }
}
