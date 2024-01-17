package repository.imp;

import model.Van;
import model.Vehicle;
import repository.IVehicleFactory;

public class VanFactory implements IVehicleFactory {
    @Override
    public Van createVehicle(String[] data) {
        Van van = new Van();
        van.setPlateNumber(data[0]);
        van.setBrand(data[1]);
        van.setYearOfProduce(data[2]);
        van.setOwner(data[3]);
        van.setPayLoad(Float.parseFloat(data[4]));

        return van;
    }
}
