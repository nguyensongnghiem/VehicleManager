import controler.VehicleController;
import model.Bike;
import model.Car;
import model.Van;
import model.Vehicle;
import repository.imp.BikeFactory;
import repository.imp.CarFactory;
import repository.imp.VanFactory;
import repository.imp.VehicleRepo;
import service.imp.VehicleService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleService carService = new VehicleService(new VehicleRepo("src/data/carDB.csv", new CarFactory()));
        VehicleController carController = new VehicleController(carService);
        VehicleService vanService = new VehicleService(new VehicleRepo("src/data/vanDB.csv", new VanFactory()));
        VehicleController vanController = new VehicleController(vanService);
        VehicleService bikeService = new VehicleService(new VehicleRepo("src/data/bikeDB.csv", new BikeFactory()));
        VehicleController bikeController = new VehicleController(bikeService);
        boolean flag ;
        boolean returnFlag;
        do {
            flag = false;
            System.out.println("Chọn chức năng : \n" +
                    "1.Thêm mới phương tiện\n" +
                    "2.Hiển thị phương tiện\n" +
                    "3.Xóa Phương tiện\n" +
                    "4.Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    do {
                        returnFlag = false;
                        System.out.println("-Thêm mới phương tiện");
                        System.out.println("---Chọn Loại phương tiện :\n" +
                                "1.Thêm xe tải\n" +
                                "2.Thêm ô tô\n" +
                                "3.Thêm xe máy\n" +
                                "4.Thoát");
                        int addType = Integer.parseInt(scanner.nextLine());

                        switch (addType) {
                            case 1:
                                Van newVan = getVanInfo();
                                System.out.println(vanController.add(newVan));
                                break;
                            case 2:
                                Car newCar = getCarInfo();
                                System.out.println(carController.add(newCar));
                                break;
                            case 3:
                                Bike newBike = getBikeInfo();
                                System.out.println(bikeController.add(newBike));
                                break;
                            case 4:
                                returnFlag = true;
                                break;
                        }
                    } while (!returnFlag);
                    break;
                case 2:
                    System.out.println("Hiển thị DS phương tiện");
                    System.out.println("---DS xe tải---");
                    ArrayList<Vehicle> vanList = vanController.getAll();
                    for (Vehicle v : vanList) {
                        System.out.println(v.toString());
                    }
                    System.out.println("---DS xe hơi---");
                    ArrayList<Vehicle> carList = carController.getAll();
                    for (Vehicle c : carList) {
                        System.out.println(c.toString());
                    }
                    System.out.println("---DS xe máy---");
                    ArrayList<Vehicle> bikeList = bikeController.getAll();
                    for (Vehicle b : bikeList) {
                        System.out.println(b.toString());
                    }
                    break;
                case 3:
                    System.out.println("Xóa phương tiện");
                    System.out.println("Nhập biển kiểm soát :");
                    String plateNum = scanner.nextLine();
                    if (carController.get(plateNum) != null || vanController.get(plateNum) != null || bikeController.get(plateNum) != null) {
                        System.out.println("Xác nhận xóa phương tiện (Y/N) : ");
                        String confirm = scanner.nextLine();
                        if (confirm.equals("Y")) {
                            if (carController.get(plateNum) != null) System.out.println(carController.delete(plateNum));
                            if (vanController.get(plateNum) != null) System.out.println(vanController.delete(plateNum));
                            if (bikeController.get(plateNum) != null)
                                System.out.println(bikeController.delete(plateNum));
                        } else System.out.printf("Hủy việc xóa phương tiện !");

                    } else System.out.println("Biển số xe không tồn tại !");

                    // code xoá
                    break;
                case 4:
                    flag = true;
                    break;
            }
        } while (!flag);

        System.out.println("Kết thúc chương trình ");

    }

    public static Van getVanInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plate Number :");
        String plateNum = sc.nextLine();
        System.out.println("Enter brand :");
        String brand = sc.nextLine();
        System.out.println("Enter year :");
        String year = sc.nextLine();
        System.out.println("Enter owner :");
        String owner = sc.nextLine();
        System.out.println("Enter payload :");
        float payload = Float.parseFloat(sc.nextLine());
        return new Van(plateNum, brand, year, owner, payload);

    }

    public static Car getCarInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plate Number :");
        String plateNum = sc.nextLine();
        System.out.println("Enter brand :");
        String brand = sc.nextLine();
        System.out.println("Enter year :");
        String year = sc.nextLine();
        System.out.println("Enter owner :");
        String owner = sc.nextLine();
        System.out.println("Enter No of seats :");
        Byte noOfSeats = Byte.parseByte(sc.nextLine());
        System.out.println("Enter type :");
        String type = sc.nextLine();
        return new Car(plateNum, brand, year, owner, noOfSeats, type);

    }

    public static Bike getBikeInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plate Number :");
        String plateNum = sc.nextLine();
        System.out.println("Enter brand :");
        String brand = sc.nextLine();
        System.out.println("Enter year :");
        String year = sc.nextLine();
        System.out.println("Enter owner :");
        String owner = sc.nextLine();
        System.out.println("Enter Power :");
        Float pw = Float.parseFloat(sc.nextLine());
        return new Bike(plateNum, brand, year, owner, pw);

    }
}