package com.group5.navana3s_workshop.Tasfia;

public class WarrantyClaim {
    private String partName;
    private String description;
    private String claimDate;

    public WarrantyClaim(String partName, String description, String claimDate) {
        this.partName = partName;
        this.description = description;
        this.claimDate = claimDate;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    @Override
    public String toString() {
        return "WarrantyClaim{" +
                "partName='" + partName + '\'' +
                ", description='" + description + '\'' +
                ", claimDate='" + claimDate + '\'' +
                '}';
    }
}
