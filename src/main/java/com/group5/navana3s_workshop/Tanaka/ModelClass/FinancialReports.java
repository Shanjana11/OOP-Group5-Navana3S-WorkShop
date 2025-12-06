package com.group5.navana3s_workshop.Tanaka.ModelClass;

public class FinancialReports {
    private String reportType;
    private String fromDate;
    private String toDate;

    public FinancialReports(String reportType, String fromDate, String toDate) {
        this.reportType = reportType;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "FinancialReports{" +
                "reportType='" + reportType + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }
}
