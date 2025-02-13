package com.directi.training.srp.proposed_solution;

import java.util.List;
import com.directi.training.srp.Proposed_Solution.models.Car; 

public class CarEvaluator {
    public Car getBestCar(List<Car> cars) {
        Car bestCar = null;
        for (Car car : cars) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
