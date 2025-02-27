# SRP Example Solution - Car Management System

## Overview

This solution demonstrates how to apply the **Single Responsibility Principle (SRP)** to a car management system while incorporating the **Facade Pattern**. The system manages car data, formats car names, and evaluates the best car based on its model. The code has been refactored to separate responsibilities into different classes. The `CarManager` class acts as a facade and implements the `CarManagerAPI`, simplifying the interaction with other services, and the car database is managed through the **Singleton Pattern**.

## Package Structure

The classes are organized into a more refined package structure:
```
com
 └── directi
     └── training
         └── srp
             └── proposed_solution
                 ├── api
                 │    ├── CarManagerAPI.java
                 │    └── implementation
                 │        └── CarManager.java
                 ├── database
                 │    └── CarDB.java
                 ├── models
                 │    └── Car.java
                 └── services
                      ├── CarEvaluator.java
                      └── CarFormatter.java

```

## Structure of the Classes

### 1. **Car.java (DTO)**

The `Car` class is located in the `models` package and represents a car. It contains the following fields:

- **`id`**: The unique identifier for the car.
- **`model`**: The model name of the car.
- **`brand`**: The brand of the car.

**Methods**:
- **`getCarName()`**: Returns a concatenation of the car's brand and model (e.g., `"Volkswagen Golf III"`).

---

### 2. **CarDB.java (Singleton)**

The `CarDB` class is a singleton located in the `database` package. It acts as the in-memory database for the car management system, containing a list of cars and providing methods to interact with them.

**Methods**:
- **`getInstance()`**: Ensures that only one instance of the `CarDB` class exists (singleton pattern).
- **`getCarById(String carId)`**: Retrieves a car by its ID from the database.

---

### 3. **CarManagerAPI.java (Facade Interface)**

The `CarManagerAPI` interface, located in the `api` package, defines the operations available to interact with the car management system. It provides a simple and unified API for consumers of the system to retrieve car data, format car names, and evaluate the best car.

**Methods**:
- **`getCarById(String carId)`**: Fetches a car by its ID.
- **`getAllCarNames()`**: Fetches and formats all car names.
- **`getBestCar()`**: Retrieves the best car based on the model evaluation.

---

### 4. **CarManager.java (Facade Implementation)**

The `CarManager` class, located in the `api/implementation` package, is the facade that implements the `CarManagerAPI`. It provides a simplified interface for interacting with the system and delegates operations to the appropriate services (e.g., `CarEvaluator`, `CarFormatter`) and the `CarDB` database.

**Methods**:
- **`getCarById(String carId)`**: Uses `CarDB` to retrieve the car by ID.
- **`getAllCarNames()`**: Uses `CarFormatter` to format and return all car names.
- **`getBestCar()`**: Uses `CarEvaluator` to determine the best car from the list of cars.

---

### 5. **CarEvaluator.java**

The `CarEvaluator` class, located in the `services` package, is responsible for evaluating which car is the best based on the model name. This class contains the logic to compare and determine the best car.

**Methods**:
- **`getBestCar(List<Car> cars)`**: Iterates through a list of cars and compares their models to determine the "best" car.

---

### 6. **CarFormatter.java**

The `CarFormatter` class, located in the `services` package, is responsible for formatting the car names. It iterates through a list of cars and returns a formatted string containing each car's name (brand + model), separated by commas.

**Methods**:
- **`getCarsNames(List<Car> cars)`**: Formats the list of car names into a single string.

---

## Benefits of the SRP Refactor with Facade and Singleton Patterns

### 1. **Single Responsibility Principle (SRP)**

Each class has a single, clearly defined responsibility:

- **`Car`**: Represents car data.
- **`CarDB`**: Manages the database (singleton pattern).
- **`CarManagerAPI`**: Defines the API for interacting with the car system.
- **`CarManager`**: Acts as the facade, providing a simplified interface and delegating responsibilities to other classes.
- **`CarEvaluator`**: Evaluates the best car.
- **`CarFormatter`**: Formats car names.

### 2. **Facade Pattern**

The `CarManager` class, located in the `api/implementation` package, provides a unified API to the clients of the system. Consumers of the `CarManagerAPI` don’t need to know about the underlying services like `CarEvaluator`, `CarFormatter`, or the database. This simplifies interactions with the system.

### 3. **Singleton Pattern**

The `CarDB` class ensures that only one instance of the car database exists, providing centralized access to car data. This reduces the complexity of managing multiple instances of the database.

### 4. **Improved Maintainability**

By following SRP and structuring the code with clear separation of concerns, it’s easier to modify or extend specific functionality without affecting other parts of the system. For example, changing the way cars are evaluated can be done in `CarEvaluator` without modifying `CarManager` or the database.

### 5. **Easier Testing**

Each class is focused on a single task, making unit testing easier. For example, `CarFormatter` and `CarEvaluator` can be tested in isolation, and `CarManager` can be tested as a facade to ensure it interacts correctly with the underlying services.

### 6. **Scalability**

This architecture is extensible. For instance, adding a new service (like `CarPriceCalculator`) is straightforward without affecting existing functionality. The facade (`CarManager`) can simply delegate the new responsibility as needed.
