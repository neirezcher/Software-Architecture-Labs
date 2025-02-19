package com.directi.training.srp.proposed_solution.Services;

import java.util.List;
import com.directi.training.srp.proposed_solution.Models.Car; 

public class CarFormatter {

    public String getCarsNames(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCarName());
            sb.append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }
}
