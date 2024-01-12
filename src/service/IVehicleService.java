package service;

import model.Vehicle;
import repository.IVehicleRepo;

import java.util.ArrayList;

public interface IVehicleService {

    String add(Vehicle vehicle);
    String delete(String plateNumber);
    Vehicle get(String plateNumber);

    ArrayList<Vehicle> getAll();

}
