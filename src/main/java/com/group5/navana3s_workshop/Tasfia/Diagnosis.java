package com.group5.navana3s_workshop.Tasfia;

public class Diagnosis {
    private String JobId;
    private String issue;
    private String severity;
    private String notes;

    public Diagnosis(String jobId, String issue, String severity, String notes) {
        JobId = jobId;
        this.issue = issue;
        this.severity = severity;
        this.notes = notes;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "JobId='" + JobId + '\'' +
                ", issue='" + issue + '\'' +
                ", severity='" + severity + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
