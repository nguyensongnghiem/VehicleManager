package model;

import java.util.Objects;

public class Van extends Vehicle{
    private float payLoad;

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
        stringBuilder.append(getPayLoad());
        return stringBuilder.toString();
    }

    public Van() {
    }

    public Van(String plateNumber, String brand, String yearOfProduce, String owner, float payLoad) {
        super(plateNumber, brand, yearOfProduce, owner);
        this.payLoad = payLoad;
    }

    public float getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(float payLoad) {
        this.payLoad = payLoad;
    }

    @Override
    public String toString() {
        return "Van{" +
                "payLoad=" + payLoad +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Van van = (Van) o;
        return Objects.equals(getPlateNumber(), van.getPlateNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNumber());
    }
}
