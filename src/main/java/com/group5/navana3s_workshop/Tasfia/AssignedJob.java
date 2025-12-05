package com.group5.navana3s_workshop.Tasfia;

public class AssignedJob {
    private String jobId;
    private String customerName;
    private String vehicleModel;
    private String issue;

    public AssignedJob(String jobId, String customerName, String vehicleModel, String issue) {
        this.jobId = jobId;
        this.customerName = customerName;
        this.vehicleModel = vehicleModel;
        this.issue = issue;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "AssignedJob{" +
                "jobId='" + jobId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", issue='" + issue + '\'' +
                '}';
    }
}
