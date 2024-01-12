package repository;

import model.Vehicle;

public interface IVehicleFromCsv {
    public Vehicle csvToVehicle(String csv);
}
