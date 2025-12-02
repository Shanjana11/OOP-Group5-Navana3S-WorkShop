package com.group5.navana3s_workshop.Tasfia;

public class UnresolvedIssue {
    private String JobId;
    private String vechicleNo;
    private String issueDescription;
    private String priority;

    public UnresolvedIssue(String jobId, String vechicleNo, String issueDescription, String priority) {
        JobId = jobId;
        this.vechicleNo = vechicleNo;
        this.issueDescription = issueDescription;
        this.priority = priority;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getVechicleNo() {
        return vechicleNo;
    }

    public void setVechicleNo(String vechicleNo) {
        this.vechicleNo = vechicleNo;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "UnresolvedIssue{" +
                "JobId='" + JobId + '\'' +
                ", vechicleNo='" + vechicleNo + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
