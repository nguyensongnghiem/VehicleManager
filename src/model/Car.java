package model;

import java.util.ArrayList;
import java.util.Objects;

public class Car extends Vehicle{
    private byte noOfSeats;
    private String type;
    public final static String CSV_SEPARATOR= ",";
    public Car() {
    }
    public Car(String plateNumber, String brand, String yearOfProduce, String owner, byte noOfSeats, String type) {
        super(plateNumber, brand, yearOfProduce, owner);
        this.noOfSeats = noOfSeats;
        this.type = type;
    }

    public byte getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(byte noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toCsvLine() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPlateNumber());
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(getBrand());
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(getYearOfProduce());
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(getOwner());
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(getNoOfSeats());
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(getType());
        return stringBuilder.toString();
    }

//    @Override
//    public Car fromCsvLine(String csv) {
//        Car car = new Car();
//        String[] arr = csv.split(CSV_SEPARATOR);
//        car.setPlateNumber(arr[0]);
//        car.setBrand(arr[1]);
//        car.setYearOfProduce(arr[2]);
//        car.setOwner(arr[3]);
//        car.setNoOfSeats(Byte.parseByte(arr[4]));
//        car.setType(arr[5]);
//        return car;
//    }


    @Override
    public String toString() {
        return "Car{" +
                "noOfSeats=" + noOfSeats +
                ", type='" + type + '\'' +
                '}' + super.toString() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getPlateNumber(), car.getPlateNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNumber());
    }
}
