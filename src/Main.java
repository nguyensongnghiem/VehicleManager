import model.Car;
import model.Van;
import model.Vehicle;
import repository.imp.CarFromCsv;
import repository.imp.VanFromCsv;
import repository.imp.VehicleRepo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Car car = new Car("1","Honda","1987","Nghiem", (byte) 2,"sedan");
        Van van = new Van("1","Honda","1987","Nghiem",100f);
        VehicleRepo carRepo = new VehicleRepo("src/data/carDB.csv",new CarFromCsv());
        VehicleRepo vanRepo = new VehicleRepo("src/data/vanDB.csv",new VanFromCsv());
        carRepo.add(car);
        vanRepo.add(van);
        ArrayList<Vehicle> carList = new ArrayList<>();
        carList = carRepo.getAll();
        System.out.println(carList);




    }
}