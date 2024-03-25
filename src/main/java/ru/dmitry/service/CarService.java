package ru.dmitry.service;


import ru.dmitry.dao.CarDAO;
import ru.dmitry.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService implements CarServiceInterface{
    private CarDAO carDAO;

    public CarService() {
    }

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public List<Car> getAllCars(int count) {
        return carDAO.getAllCars(count);
    }
}
