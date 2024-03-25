package ru.dmitry.dao;

import ru.dmitry.model.Car;
import java.util.List;

public interface CarDAOInterface {
    List<Car> getAllCars();

    List<Car> getAllCars(int count);
}
