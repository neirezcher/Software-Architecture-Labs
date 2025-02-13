package com.directi.training.srp.proposed_solution;

import java.util.List;
import com.directi.training.srp.Proposed_Solution.models.Car; 

public class CarManager {
    private final List<Car> carsDb;

    public CarManager(List<Car> carsDb) {
        this.carsDb = carsDb;
    }

    public Car getFromDb(final String carId) {
        for (Car car : carsDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
}
