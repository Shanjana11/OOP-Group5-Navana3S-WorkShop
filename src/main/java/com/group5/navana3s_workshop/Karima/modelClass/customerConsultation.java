package com.group5.navana3s_workshop.Karima.modelClass;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class customerConsultation implements Serializable {
    private String budget;
    private String model;
    private String color;

    public customerConsultation(String budget, String model, String color) {
        this.budget = budget;
        this.model = model;
        this.color = color;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "customerConsultation{" +
                "budget='" + budget + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
