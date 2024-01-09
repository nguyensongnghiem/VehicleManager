package model;

import java.util.Objects;

public class Bike extends Vehicle{
    private float power;

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
        stringBuilder.append(getPower());
        return stringBuilder.toString();
    }

    public Bike() {
    }

    public Bike(String plateNumber, String brand, String yearOfProduce, String owner, float power) {
        super(plateNumber, brand, yearOfProduce, owner);
        this.power = power;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "power=" + power +
                '}'+ super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(getPlateNumber(), bike.getPlateNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNumber());
    }
}
