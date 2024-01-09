package model;

import java.util.Objects;

public class Car extends Vehicle{
    private byte noOfSeats;
    private String type;

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
        final String CSV_SEPARATOR= ",";
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
    public Car() {
    }

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
