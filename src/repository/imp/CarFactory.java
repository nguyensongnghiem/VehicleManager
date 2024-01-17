package repository.imp;

import model.Car;
import repository.IVehicleFactory;

public class CarFactory implements IVehicleFactory {
    @Override
    public Car createVehicle(String[] data) {

        Car car = new Car();

        car.setPlateNumber(data[0]);
        car.setBrand(data[1]);
        car.setYearOfProduce(data[2]);
        car.setOwner(data[3]);
        car.setNoOfSeats(Byte.parseByte(data[4]));
        car.setType(data[5]);
        return car;
    }
}
