package service;

import model.Vehicle;
import repository.IVehicleRepo;

import java.util.ArrayList;

public interface IVehicleService {

    void add(Vehicle vehicle);
    void delete(String plateNumber);
    Vehicle get(String plateNumber);
    ArrayList<Vehicle> getAll();

}
