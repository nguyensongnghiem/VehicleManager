package repository;

import model.Vehicle;

import java.util.ArrayList;

public interface IVehicleRepo<T>{
    public void add(T t);
    public void delete(String plateNumber);
    public T get(String plateNumber);
    public ArrayList<T> getAll() ;


}
