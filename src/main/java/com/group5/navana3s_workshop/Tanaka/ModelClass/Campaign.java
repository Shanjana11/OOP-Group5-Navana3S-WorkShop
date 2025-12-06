package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.io.ObjectInputFilter;
import java.time.LocalDate;
import java.util.List;

public class Campaign {
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> channels;
    private String status;
    private String description;
    private String campaignId;
    private String title;
    private String season; // Monsoon, Eid, Summer, etc.
    private List<String> targetServices;

    public Campaign(String campaignName, LocalDate startDate, LocalDate endDate, List<String> channels, String status, String description) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.channels = channels;
        this.status = status;
        this.description = description;
    }

    public Campaign(String campaignId, String title, String season, String description, LocalDate startDate, LocalDate endDate, List<String> targetServices, String status, String campaignName) {
        this.campaignId = campaignId;
        this.title = title;
        this.season = season;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.targetServices = targetServices;
        this.status = status;
        this.campaignName = campaignName;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<String> getTargetServices() {
        return targetServices;
    }

    public void setTargetServices(List<String> targetServices) {
        this.targetServices = targetServices;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "campaignId='" + campaignId + '\'' +
                ", title='" + title + '\'' +
                ", season='" + season + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", targetServices=" + targetServices +
                ", status='" + status + '\'' +
                ", campaignName='" + campaignName + '\'' +
                '}';
    }
}
