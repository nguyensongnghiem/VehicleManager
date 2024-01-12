package repository.imp;

import model.Bike;
import model.Van;
import repository.IVehicleFromCsv;

public class BikeFromCsv implements IVehicleFromCsv {
    @Override
    public Bike csvToVehicle(String csv) {
        final String CSV_SEPARATOR = ",";
        Bike bike = new Bike();
        String[] arr = csv.split(CSV_SEPARATOR);
        bike.setPlateNumber(arr[0]);
        bike.setBrand(arr[1]);
        bike.setYearOfProduce(arr[2]);
        bike.setOwner(arr[3]);
        bike.setPower(Float.parseFloat(arr[4]));

        return bike;
    }
}
