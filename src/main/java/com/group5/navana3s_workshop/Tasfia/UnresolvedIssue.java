package com.group5.navana3s_workshop.Tasfia;

public class UnresolvedIssue {
    private String description;
    private String severity;
    private String manager;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public UnresolvedIssue(String description, String severity, String manager) {
        this.description = description;
        this.severity = severity;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "UnresolvedIssue{" +
                "description='" + description + '\'' +
                ", severity='" + severity + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
