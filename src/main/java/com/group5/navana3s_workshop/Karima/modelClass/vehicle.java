package com.group5.navana3s_workshop.Karima.modelClass;

public class vehicle {
    private String model;
    private String fuelType;
    private String features;
    private String engineType;
    private int stock;


    public vehicle(String model, String fuelType, String features, String engineType, int stock) {
        this.model = model;
        this.fuelType = fuelType;
        this.features = features;
        this.engineType = engineType;
        this.stock = stock;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", features='" + features + '\'' +
                ", engineType='" + engineType + '\'' +
                ", stock=" + stock +
                '}';
    }
}


