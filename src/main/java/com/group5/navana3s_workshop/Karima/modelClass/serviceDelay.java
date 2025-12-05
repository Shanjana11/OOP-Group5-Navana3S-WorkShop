package com.group5.navana3s_workshop.Karima.modelClass;

public class serviceDelay {
    private int serviceID;
    private String serviceName;
    private String delayedBy;
    private String delayReason;
    private String expectedCompletion;

    public serviceDelay(int serviceID, String serviceName, String delayedBy, String delayReason, String expectedCompletion) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.delayedBy = delayedBy;
        this.delayReason = delayReason;
        this.expectedCompletion = expectedCompletion;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDelayedBy() {
        return delayedBy;
    }

    public void setDelayedBy(String delayedBy) {
        this.delayedBy = delayedBy;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public String getExpectedCompletion() {
        return expectedCompletion;
    }

    public void setExpectedCompletion(String expectedCompletion) {
        this.expectedCompletion = expectedCompletion;
    }

    @Override
    public String toString() {
        return "serviceDelay{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", delayedBy='" + delayedBy + '\'' +
                ", delayReason='" + delayReason + '\'' +
                ", expectedCompletion='" + expectedCompletion + '\'' +
                '}';
    }
}
