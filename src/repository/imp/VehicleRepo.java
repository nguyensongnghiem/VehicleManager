package repository.imp;

import model.Manufacturer;
import model.Vehicle;
import repository.IVehicleFromCsv;
import repository.IVehicleRepo;
import utils.FileIo;

import java.util.ArrayList;

public class VehicleRepo implements IVehicleRepo<Vehicle> {
    private String path;
    private IVehicleFromCsv vehicleFromCsv;
    public static ArrayList<Manufacturer> manufacturers;
    static {
        manufacturers.add(new Manufacturer("HSX-001","Yamaha","Nhật Bản"));
        manufacturers.add(new Manufacturer("HSX-002","Honda","Nhật Bản"));
        manufacturers.add(new Manufacturer("HSX-003","Dongfeng","Trung Quốc"));
        manufacturers.add(new Manufacturer("HSX-004","Huyndai","Hàn Quốc"));
        manufacturers.add(new Manufacturer("HSX-004","Ford","Mỹ"));
        manufacturers.add(new Manufacturer("HSX-005","Toyota","Nhật Bản"));
        manufacturers.add(new Manufacturer("HSX-006","Hino","Nhật Bản"));
    }

    public VehicleRepo() {
    }

    public VehicleRepo(String path, IVehicleFromCsv vehicleFromCsv) {
        this.path = path;
        this.vehicleFromCsv = vehicleFromCsv;
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
                Vehicle v = vehicleFromCsv.csvToVehicle(arrCsv.get(i));
                list.add(v);
        }
        return list;
    }

}
