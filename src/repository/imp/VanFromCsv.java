package repository.imp;

import model.Car;
import model.Van;
import repository.IVehicleFromCsv;

public class VanFromCsv implements IVehicleFromCsv {
    @Override
    public Van csvToVehicle(String csv) {
        final String CSV_SEPARATOR = ",";
        Van van = new Van();
        String[] arr = csv.split(CSV_SEPARATOR);
        van.setPlateNumber(arr[0]);
        van.setBrand(arr[1]);
        van.setYearOfProduce(arr[2]);
        van.setOwner(arr[3]);
        van.setPayLoad(Float.parseFloat(arr[4]));

        return van;
    }
}
