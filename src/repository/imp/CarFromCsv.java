package repository.imp;

import model.Car;
import repository.IVehicleFromCsv;

public class CarFromCsv implements IVehicleFromCsv {
    @Override
    public Car csvToVehicle(String csv) {
        final String CSV_SEPARATOR = ",";
        Car car = new Car();
        String[] arr = csv.split(CSV_SEPARATOR);
        car.setPlateNumber(arr[0]);
        car.setBrand(arr[1]);
        car.setYearOfProduce(arr[2]);
        car.setOwner(arr[3]);
        car.setNoOfSeats(Byte.parseByte(arr[4]));
        car.setType(arr[5]);
        return car;
    }
}
