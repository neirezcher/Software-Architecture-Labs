package com.directi.training.srp.proposed_solution.Models;

public class Car {
    private final String _id;
    private final String _model;
    private final String _brand;

    public Car(String id, String model, String brand) {
        _id = id;
        _model = model;
        _brand = brand;
    }

    public String getId() {
        return _id;
    }

    public String getModel() {
        return _model;
    }

    public String getBrand() {
        return _brand;
    }

    // Getting the full car name
    public String getCarName() {
        return _brand + " " + _model;
    }
}
