package repository;

import model.Vehicle;

public interface IVehicleFactory {
    public Vehicle createVehicle(String[] data);
}
