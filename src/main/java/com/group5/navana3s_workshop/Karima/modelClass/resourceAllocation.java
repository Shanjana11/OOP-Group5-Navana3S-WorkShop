package com.group5.navana3s_workshop.Karima.modelClass;

public class resourceAllocation {
    private String staffName;
    private String assignedTask;
    private String availabilityStatus;
    private int vehicleNo;
    private int jobId;


    public resourceAllocation(String staffName, String assignedTask, String availabilityStatus, int vehicleNo, int jobId) {
        this.staffName = staffName;
        this.assignedTask = assignedTask;
        this.availabilityStatus = availabilityStatus;
        this.vehicleNo = vehicleNo;
        this.jobId = jobId;

    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(String assignedTask) {
        this.assignedTask = assignedTask;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }



    @Override
    public String toString() {
        return "resourceAllocation{" +
                "staffName='" + staffName + '\'' +
                ", assignedTask='" + assignedTask + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", vehicleNo=" + vehicleNo +
                ", jobId=" + jobId +
                '}';
    }
}
