package ru.dmitry.service;


import ru.dmitry.dao.CarDAO;
import ru.dmitry.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService {
    private CarDAO carDAO = new CarDAO();

    public CarService() {
    }

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public List<Car> getAllCars(int count) {
        return carDAO.getAllCars(count);
    }
}
