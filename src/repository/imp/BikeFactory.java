package repository.imp;

import model.Bike;
import repository.IVehicleFactory;

public class BikeFactory implements IVehicleFactory {
    @Override
    public Bike createVehicle(String[] data) {
        Bike bike = new Bike();
        bike.setPlateNumber(data[0]);
        bike.setBrand(data[1]);
        bike.setYearOfProduce(data[2]);
        bike.setOwner(data[3]);
        bike.setPower(Float.parseFloat(data[4]));
        return bike;
    }
}
