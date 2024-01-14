package service.imp;

import model.Vehicle;
import repository.IVehicleRepo;
import repository.imp.VehicleRepo;
import service.IVehicleService;

import java.util.ArrayList;

public class VehicleService implements IVehicleService {
    private IVehicleRepo<Vehicle> vehicleRepo;

    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public void add(Vehicle vehicle){
        vehicleRepo.add(vehicle);
    }

    @Override
    public void delete(String plateNumber) {
        vehicleRepo.delete(plateNumber);
    }

    @Override
    public Vehicle get(String plateNumber) {
        Vehicle vehicle = vehicleRepo.get(plateNumber);
        return vehicle;
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        return vehicleRepo.getAll();
    }
}

