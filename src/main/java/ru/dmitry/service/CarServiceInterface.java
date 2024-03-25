package ru.dmitry.service;

import ru.dmitry.model.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAllCars();

    List<Car> getAllCars(int count);
}
