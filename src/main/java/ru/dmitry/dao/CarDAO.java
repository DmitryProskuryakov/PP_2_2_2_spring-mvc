package ru.dmitry.dao;

import ru.dmitry.Util.Connect;
import ru.dmitry.model.Car;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private Car car;

    public CarDAO() {
    }

    public CarDAO(Car car) {
        this.car = car;
    }

    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();

        try (Connection connection = Connect.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String model = resultSet.getString("model");
                int age = resultSet.getInt("age");
                String color = resultSet.getString("color");
                carList.add(new Car(model, age, color));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carList;
    }

    public List<Car> getAllCars(int count) {
        if (count < 0) {
            return null;
        }

        List<Car> carList = new ArrayList<>();

        try (Connection connection = Connect.getConnection()) {
            PreparedStatement preparedStatement = null;

            if (count >= 5) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cars");
            }

            else {
                preparedStatement = connection.prepareStatement("SELECT * FROM cars LIMIT ?");
                preparedStatement.setInt(1, count);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String model = resultSet.getString("model");
                int age = resultSet.getInt("age");
                String color = resultSet.getString("color");
                carList.add(new Car(model, age, color));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carList;
    }
}
