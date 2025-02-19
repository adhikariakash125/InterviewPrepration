package LLD.ParkingSystem;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingLevel parkingLevel1 = new ParkingLevel(1);
        parkingLevel1.addParkingSpot(new ParkingSpot(1,Vehicle.CAR));
        parkingLevel1.addParkingSpot(new ParkingSpot(2, Vehicle.TRUCKS));
        parkingLevel1.addParkingSpot(new ParkingSpot(3,Vehicle.CAR));

        ParkingLevel parkingLevel2 = new ParkingLevel(2);
        parkingLevel2.addParkingSpot(new ParkingSpot(1,Vehicle.MOTORCYCLES));
        parkingLevel2.addParkingSpot(new ParkingSpot(2, Vehicle.MOTORCYCLES));
        parkingLevel2.addParkingSpot(new ParkingSpot(3,Vehicle.CAR));
        parkingLevel2.addParkingSpot(new ParkingSpot(4,Vehicle.TRUCKS));

        parkingLot.addParkingLevel(parkingLevel1);
        parkingLot.addParkingLevel(parkingLevel2);

        parkingLot.parkVehicle(2,2, Vehicle.MOTORCYCLES);

        parkingLot.parkVehicle(1,2, Vehicle.TRUCKS);

        parkingLot.parkVehicle(2,4, Vehicle.TRUCKS);

        System.out.println(parkingLot.getFreeSpacesByLevel());

        parkingLot.unParkVehicle(2, 2);

        System.out.println(parkingLot.getFreeSpacesByLevel());
    }
}
