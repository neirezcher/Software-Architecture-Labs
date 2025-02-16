package com.directi.training.srp.proposed_solution.API;

import com.directi.training.srp.proposed_solution.Models.Car;

public interface CarAPI {
    Car getCarById(String carId);
    String getAllCarNames();
    Car getBestCar();
}
