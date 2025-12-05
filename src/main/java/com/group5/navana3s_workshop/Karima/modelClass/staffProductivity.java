package com.group5.navana3s_workshop.Karima.modelClass;

import java.io.Serializable;

public class staffProductivity implements Serializable {
    private String staffName;
    private String status;
    private int jobsCompleted;
    private int hoursWorked;
    private String rating;
    private double efficiency;

    public staffProductivity(String staffName, String status, int jobsCompleted, int hoursWorked, String rating, double efficiency) {
        this.staffName = staffName;
        this.status = status;
        this.jobsCompleted = jobsCompleted;
        this.hoursWorked = hoursWorked;
        this.rating = rating;
        this.efficiency = efficiency;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPresentStatus() {
        return status;
    }

    public void setPresentStatus(String presentStatus) {
        this.status = presentStatus;
    }

    public int getJobsCompleted() {
        return jobsCompleted;
    }

    public void setJobsCompleted(int jobsCompleted) {
        this.jobsCompleted = jobsCompleted;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return "staffProductivity{" +
                "staffName='" + staffName + '\'' +
                ", presentStatus='" + status + '\'' +
                ", jobsCompleted=" + jobsCompleted +
                ", hoursWorked=" + hoursWorked +
                ", rating=" + rating +
                ", efficiency='" + efficiency + '\'' +
                '}';
    }
}
