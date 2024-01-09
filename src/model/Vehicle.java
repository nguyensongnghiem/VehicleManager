package model;

public abstract class Vehicle {
    private String plateNumber ;
    private String brand;
    private String yearOfProduce;
    private String owner;
    public abstract String toCsvLine() ;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearOfProduce() {
        return yearOfProduce;
    }

    public void setYearOfProduce(String yearOfProduce) {
        this.yearOfProduce = yearOfProduce;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Vehicle() {
    }

    public Vehicle(String plateNumber, String brand, String yearOfProduce, String owner) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.yearOfProduce = yearOfProduce;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfProduce='" + yearOfProduce + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
