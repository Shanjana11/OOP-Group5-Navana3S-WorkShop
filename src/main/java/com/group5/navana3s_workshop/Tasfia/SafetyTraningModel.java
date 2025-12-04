package com.group5.navana3s_workshop.Tasfia;

import java.time.LocalDate;

public class SafetyTraningModel {
    private String module;
    private LocalDate date;
    private String status;
    private String notes;

    public SafetyTraningModel(String module, LocalDate date, String status, String notes) {
        this.module = module;
        this.date = date;
        this.status = status;
        this.notes = notes;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "SafetyTraningModel{" +
                "module='" + module + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
