package com.group5.navana3s_workshop.Karima.modelClass;

import javafx.beans.property.StringProperty;

public class FinancingPlan {
    private  String  planName;
    private  String  emi;
    private  String downPayment;

    public FinancingPlan(String planName, String emi, String downPayment) {
        this.planName = planName;
        this.emi = emi;
        this.downPayment = downPayment;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }
}
