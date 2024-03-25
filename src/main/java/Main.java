import ru.dmitry.Util.Connect;
import ru.dmitry.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 1999, "Yellow");
        Car car2 = new Car("Honda", 2010, "Yellow");
        Car car3 = new Car("BMW", 2001, "Red");
        Car car4 = new Car("Nissan", 2009, "Black");
        Car car5 = new Car("Ford", 2013, "White");

        List<Car> listCars = new ArrayList<>();

        listCars.add(car1);
        listCars.add(car2);
        listCars.add(car3);
        listCars.add(car4);
        listCars.add(car5);

        try (Connection connection = Connect.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Cars VALUES (?,?,?)");

            for (Car car: listCars) {
                preparedStatement.setString(1, car.getModel());
                preparedStatement.setInt(2, car.getAge());
                preparedStatement.setString(3, car.getColor());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}
