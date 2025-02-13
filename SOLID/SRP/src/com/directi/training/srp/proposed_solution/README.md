# SRP Example Solution - Car Management System

## Overview

This solution demonstrates how to apply the **Single Responsibility Principle (SRP)** to a car management system. The system allows management of car data, displaying car names, and evaluating the best car based on its model. The code has been refactored to separate these responsibilities into different classes.


## Package Structure

The classes are organized into a package structure:

com
 └── directi
     └── training
         └── srp
             └── Proposed_Solution
                 ├── CarManager.java
                 ├── CarFormatter.java
                 ├── CarEvaluator.java
                 └── models
                     └── Car.java

## Structure of the Classes

### 1. **Car.java**

The `Car` class is located in the `com.directi.training.srp.proposed_solution.models` package and represents a car. It has the following fields:

- `id`: The unique identifier for the car.
- `model`: The model name of the car.
- `brand`: The brand of the car.

**Methods**:
- `getCarName()`: Returns a concatenation of the car's brand and model (e.g., `"Volkswagen Golf III"`).

### 2. **CarManager.java**

The `CarManager` class is located in the `com.directi.training.srp.proposed_solution` package and is responsible for managing a list of cars. It provides the following functionality:

- `getFromDb(String carId)`: Retrieves a car by its ID from the database (list of cars).

### 3. **CarFormatter.java**

The `CarFormatter` class is located in the `com.directi.training.srp.proposed_solution` package and is responsible for formatting car names. It includes the following method:

- `getCarsNames(List<Car> cars)`: Iterates through a list of cars and returns a formatted string containing each car's name (brand + model), separated by commas.

### 4. **CarEvaluator.java**

The `CarEvaluator` class is located in the `com.directi.training.srp.proposed_solution` package and is responsible for evaluating the "best" car. It includes the following method:

- `getBestCar(List<Car> cars)`: Iterates through a list of cars and compares the car models to determine the "best" car based on the model name.

## Benefits of the SRP Refactor

By refactoring the code to follow the **Single Responsibility Principle (SRP)**, we have:

- **Separation of Concerns**: Each class now has a single, clearly defined responsibility:
  - `Car` handles car data and formatting its name.
  - `CarManager` handles retrieving cars from the database.
  - `CarDisplay` handles displaying the list of car names.
  - `CarEvaluator` handles evaluating the best car.

- **Improved Maintainability**: If we need to modify the behavior of one responsibility (e.g., change how car names are displayed or how cars are evaluated), we can do so without affecting the other responsibilities.

- **Easier Testing**: Each class is focused on a single task, which makes unit testing easier and more isolated.
