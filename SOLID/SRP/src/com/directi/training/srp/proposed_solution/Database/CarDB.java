package com.directi.training.srp.proposed_solution.Database;

import java.util.List;
import com.directi.training.srp.proposed_solution.Models.Car;

public class CarDB {
    private static CarDB instance;
    private final List<Car> carsDb;

    private CarDB(List<Car> carsDb) {
        this.carsDb = carsDb;
    }

    public static synchronized CarDB getInstance(List<Car> carsDb) {
        if (instance == null) {
            instance = new CarDB(carsDb);
        }
        return instance;
    }

    public Car getFromDb(final String carId) {
        for (Car car : carsDb) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAllCars() {
        return carsDb;
    }
}
