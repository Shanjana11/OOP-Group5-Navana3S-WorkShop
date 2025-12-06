package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.time.LocalDate;

public class Announcement {
    private String title;
    private String message;
    private String priority; // HIGH, MEDIUM, LOW
    private LocalDate date;
    private boolean sendAll;
    private String sentBy;

    public Announcement(String title, String message, String priority, LocalDate date, boolean sendAll, String sentBy) {
        this.title = title;
        this.message = message;
        this.priority = priority;
        this.date = date;
        this.sendAll = sendAll;
        this.sentBy = sentBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isSendAll() {
        return sendAll;
    }

    public void setSendAll(boolean sendAll) {
        this.sendAll = sendAll;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", priority='" + priority + '\'' +
                ", date=" + date +
                ", sendAll=" + sendAll +
                ", sentBy='" + sentBy + '\'' +
                '}';
    }
}
