package com.directi.training.srp.proposed_solution.API.Implementation;

import java.util.List;

import com.directi.training.srp.proposed_solution.API.CarAPI;
import com.directi.training.srp.proposed_solution.Models.Car;
import com.directi.training.srp.proposed_solution.Database.CarDB;
import com.directi.training.srp.proposed_solution.Services.CarFormatter;
import com.directi.training.srp.proposed_solution.Services.CarEvaluator;

public class CarManager  implements CarAPI {
    private final CarDB carDB;
    private final CarFormatter carFormatter;
    private final CarEvaluator carEvaluator;

    public CarManager(List<Car> cars) {
        this.carDB = CarDB.getInstance(cars);
        this.carFormatter = new CarFormatter();
        this.carEvaluator = new CarEvaluator();
    }

    @Override
    public Car getCarById(String carId) {
        return carDB.getFromDb(carId);
    }

    @Override
    public String getAllCarNames() {
        return carFormatter.getCarsNames(carDB.getAllCars());
    }

    @Override
    public Car getBestCar() {
        return carEvaluator.getBestCar(carDB.getAllCars());
    }
}
