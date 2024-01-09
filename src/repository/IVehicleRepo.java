package repository;

import model.Vehicle;

import java.util.ArrayList;

public interface IVehicleRepo<T>{
    public String add(T t);
    public String delete(String plateNumber);
    public Vehicle get(String plateNumber);
    public ArrayList<T> getAll() ;


}
