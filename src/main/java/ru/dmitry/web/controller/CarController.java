package ru.dmitry.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dmitry.model.Car;
import ru.dmitry.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class CarController {
    @GetMapping("/cars")
    public String getAllCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        CarService carService = new CarService();
        List<Car> carList = new ArrayList<>();

        if (count == null) {
            carList = carService.getAllCars();
            model.addAttribute("cars", carList);
            return "cars";
        }

        carList = carService.getAllCars(count);
        model.addAttribute("cars", carList);
        return "cars";
    }
}
