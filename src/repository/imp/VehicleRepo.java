package repository.imp;

import model.Manufacturer;
import model.Vehicle;
import repository.IVehicleFactory;
import repository.IVehicleRepo;
import utils.FileIo;

import java.util.ArrayList;

public class VehicleRepo implements IVehicleRepo<Vehicle> {
    private String path;
    private IVehicleFactory vehicleFactory;
    private static final String CSV_SEPARTOR = ",";
    public VehicleRepo() {
    }

    public VehicleRepo(String path, IVehicleFactory vehicleFactory) {
        this.path = path;
        this.vehicleFactory = vehicleFactory;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }


    @Override
    public void add(Vehicle vehicle) {
        FileIo file = new FileIo(path);
        ArrayList<Vehicle> list = getAll();
        if (!list.contains(vehicle)) {
        String csv = vehicle.toCsvLine();
        file.write(csv, true);
        } else {
            System.out.println("Exist !");
        }

    }

    @Override
    public void delete(String plateNumber) {
        FileIo file = new FileIo(path);
        ArrayList<Vehicle> list = getAll();
        Vehicle deletedVehicle = get(plateNumber);
        if (deletedVehicle!=null) {
            list.remove(deletedVehicle);
        ArrayList<String> strList = new ArrayList<>();
        for (Vehicle v: list) {
            strList.add(v.toCsvLine());
        }
        file.writeList(strList,false);
        }
        else {
            System.out.println("Doesn't exist !");
        }
    }

    @Override
    public Vehicle get(String plateNumber) {
        Vehicle getVehicle = null ;
        ArrayList<Vehicle> list = getAll();
        for (Vehicle v : list) {
            if (v.getPlateNumber().equals(plateNumber)) {
                getVehicle = v;
                break;
            }
        }
        return getVehicle;
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        FileIo file = new FileIo(path);
        ArrayList<Vehicle> list = new ArrayList<>();
        ArrayList<String> arrCsv = file.readList();
        for (int i = 0; i < arrCsv.size(); i++) {
                Vehicle v = vehicleFactory.createVehicle(arrCsv.get(i).split(CSV_SEPARTOR));
                list.add(v);
        }
        return list;
    }

}
