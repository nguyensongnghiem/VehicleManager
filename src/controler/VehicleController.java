package controler;

import model.Vehicle;
import service.IVehicleService;
import service.imp.VehicleService;

import java.util.ArrayList;

public class VehicleController {
    private IVehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public String add(Vehicle vehicle) {
        String plateNum = vehicle.getPlateNumber();
        if (vehicleService.get(plateNum) == null) {
            vehicleService.add(vehicle);
            return "Add successfull";
        }
        return "Vehicle already exist !";

    }

    public String delete(String plateNum) {
        if (vehicleService.get(plateNum) != null) {
            vehicleService.delete(plateNum);
            return "Delete successfull";
        }
        return "Vehicle does not exist !";
    }

    public ArrayList<Vehicle> getAll() {
        return vehicleService.getAll();
    }
    public Vehicle get(String plateNum) {
      return vehicleService.get(plateNum);
    }

}
