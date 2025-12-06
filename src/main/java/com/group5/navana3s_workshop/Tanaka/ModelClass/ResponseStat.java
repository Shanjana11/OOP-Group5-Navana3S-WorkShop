package com.group5.navana3s_workshop.Tanaka.ModelClass;

public class ResponseStat {
    private String id;
    private String campaignId;
    private int views;
    private int clicks;
    private int leads;
    private int bookings;

    public ResponseStat(String id, String campaignId, int views, int clicks, int leads, int bookings) {
        this.id = id;
        this.campaignId = campaignId;
        this.views = views;
        this.clicks = clicks;
        this.leads = leads;
        this.bookings = bookings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getLeads() {
        return leads;
    }

    public void setLeads(int leads) {
        this.leads = leads;
    }

    public int getBookings() {
        return bookings;
    }

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "ResponseStat{" +
                "id='" + id + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", views=" + views +
                ", clicks=" + clicks +
                ", leads=" + leads +
                ", bookings=" + bookings +
                '}';
    }
}
