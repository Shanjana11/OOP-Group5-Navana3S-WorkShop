package com.group5.navana3s_workshop.Tasfia;

public class MonthlyStockReportModel {
    private String partId;
    private String partName;
    private int openingStock;
    private int received;
    private int used;
    private int closingStatus;

    public MonthlyStockReportModel(String partId, int openingStock, String partName, int received, int used, int closingStatus) {
        this.partId = partId;
        this.openingStock = openingStock;
        this.partName = partName;
        this.received = received;
        this.used = used;
        this.closingStatus = closingStatus;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getOpeningStock() {
        return openingStock;
    }

    public void setOpeningStock(int openingStock) {
        this.openingStock = openingStock;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public int getClosingStatus() {
        return closingStatus;
    }

    public void setClosingStatus(int closingStatus) {
        this.closingStatus = closingStatus;
    }

    @Override
    public String toString() {
        return "MonthlyStockReportModel{" +
                "partId='" + partId + '\'' +
                ", partName='" + partName + '\'' +
                ", openingStock=" + openingStock +
                ", received=" + received +
                ", used=" + used +
                ", closingStatus=" + closingStatus +
                '}';
    }
}
