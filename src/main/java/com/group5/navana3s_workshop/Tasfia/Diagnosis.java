package com.group5.navana3s_workshop.Tasfia;

public class Diagnosis {
    private String error;
    private String description;
    private String jobid;
    private String vechicleno;

    public Diagnosis(String error, String description, String jobid, String vechicleno) {
        this.error = error;
        this.description = description;
        this.jobid = jobid;
        this.vechicleno = vechicleno;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getVechicleno() {
        return vechicleno;
    }

    public void setVechicleno(String vechicleno) {
        this.vechicleno = vechicleno;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "error='" + error + '\'' +
                ", description='" + description + '\'' +
                ", jobid='" + jobid + '\'' +
                ", vechicleno='" + vechicleno + '\'' +
                '}';
    }
}
