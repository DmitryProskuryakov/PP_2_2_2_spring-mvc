package ru.dmitry.dao;


import ru.dmitry.model.Car;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO implements CarDAOInterface{
    private List<Car> carList;

    public CarDAO() {
        carList.add(new Car("Toyota", 1999, "Yellow"));
        carList.add(new Car("Honda", 2010, "Yellow"));
        carList.add(new Car("BMW", 2001, "Red"));
        carList.add(new Car("Nissan", 2009, "Black"));
        carList.add(new Car("Ford", 2013, "White"));
    }


    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public List<Car> getAllCars(int count) {
        List<Car> carlist2 = carList.stream().limit(count).collect(Collectors.toList());
        return  carlist2;
    }
}
