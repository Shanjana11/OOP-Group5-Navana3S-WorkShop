package com.group5.navana3s_workshop.Karima.modelClass;

import java.io.Serializable;

public class customerManagement implements Serializable {
    private String name;
    private String contact;
    private String interestModel;

    public customerManagement(String name, String contact, String interestModel) {
        this.name = name;
        this.contact = contact;
        this.interestModel = interestModel;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInterestModel() {
        return interestModel;
    }

    public void setInterestModel(String interestModel) {
        this.interestModel = interestModel;
    }





    @Override
    public String toString() {
        return "customerManagement{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", interestModel='" + interestModel + '\'' +
                '}';
    }
}
