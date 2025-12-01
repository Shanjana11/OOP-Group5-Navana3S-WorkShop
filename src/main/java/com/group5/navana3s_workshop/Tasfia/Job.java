package com.group5.navana3s_workshop.Tasfia;

public class Job {
    private String JobId;
    private String VechicleNo;
    private String TechnicianName;
    private String status;

    public Job(String jobId, String vechicleNo, String technicianName, String status) {
        JobId = jobId;
        VechicleNo = vechicleNo;
        TechnicianName = technicianName;
        this.status = status;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getVechicleNo() {
        return VechicleNo;
    }

    public void setVechicleNo(String vechicleNo) {
        VechicleNo = vechicleNo;
    }

    public String getTechnicianName() {
        return TechnicianName;
    }

    public void setTechnicianName(String technicianName) {
        TechnicianName = technicianName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Job{" +
                "JobId='" + JobId + '\'' +
                ", VechicleNo='" + VechicleNo + '\'' +
                ", TechnicianName='" + TechnicianName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
