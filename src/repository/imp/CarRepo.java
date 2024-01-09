package repository.imp;

import model.Car;
import model.Vehicle;
import repository.IVehicleRepo;

import java.util.ArrayList;

public class CarRepo implements IVehicleRepo<Car> {
    @Override
    public String add(Car car) {
        return null;
    }

    @Override
    public String delete(String plateNumber) {
        return null;
    }

    @Override
    public Vehicle get(String plateNumber) {
        return null;
    }

    @Override
    public ArrayList<Car> getAll() {
        return null;
    }
}
