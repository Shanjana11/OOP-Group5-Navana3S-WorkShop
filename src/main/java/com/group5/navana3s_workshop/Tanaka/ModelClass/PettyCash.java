package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PettyCash {
    private int amount;
    private LocalDate date;
    private String type;
    private String description;

    public PettyCash(int amount, LocalDate date, String type, String description) {
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PettyCash{" +
                "amount=" + amount +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
