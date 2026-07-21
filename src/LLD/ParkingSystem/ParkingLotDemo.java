package LLD.ParkingSystem;

import LLD.ParkingSystem.ParkingStrategy.BestPossibleParkingSpot;
import LLD.ParkingSystem.PaymentStrategy.Cash;
import LLD.ParkingSystem.Vehicle.Bike;
import LLD.ParkingSystem.Vehicle.Car;
import LLD.ParkingSystem.Vehicle.Truck;
import LLD.ParkingSystem.enums.VehicleSize;
import LLD.ParkingSystem.observer.DisplayBoard;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingLevel level1 = new ParkingLevel(1);
        level1.addParkingSpot(new ParkingSpot(1, 10, VehicleSize.SMALL));
        level1.addParkingSpot(new ParkingSpot(2, 10, VehicleSize.SMALL));
        level1.addParkingSpot(new ParkingSpot(3, 20, VehicleSize.MEDIUM));
        level1.addParkingSpot(new ParkingSpot(4, 30, VehicleSize.LARGE));
        level1.addObserver(new DisplayBoard());
        parkingLot.addLevel(level1);

        Bike bikeA = new Bike(1111);
        Bike bikeB = new Bike(2222);
        Bike bikeC = new Bike(3333);
        Car car = new Car(4444);
        Truck truck = new Truck(5555);

        ParkingTicket bikeATicket = parkingLot.entry(bikeA);
        ParkingTicket bikeBTicket = parkingLot.entry(bikeB);
        ParkingTicket carTicket = parkingLot.entry(car);
        ParkingTicket truckTicket = parkingLot.entry(truck);

        // DisplayBoard already printed availability after each entry() above via the observer, so no need to poll it here

        // both SMALL spots are now taken, so this should fail gracefully instead of double-booking
        ParkingTicket bikeCTicket = parkingLot.entry(bikeC);
        System.out.println("bikeC entry result: " + (bikeCTicket == null ? "rejected, lot full for SMALL" : "ticket " + bikeCTicket.getId()));

        System.out.println("---- paying and exiting bikeA ----");
        Payment bikeAPayment = parkingLot.exit(bikeATicket, new Cash());
        System.out.println("Payment status: " + bikeAPayment.getPaymentStatus() + ", amount: " + bikeAPayment.getAmount());

        // a SMALL spot just freed up, so bikeC should get in now
        bikeCTicket = parkingLot.entry(bikeC);
        System.out.println("bikeC entry result: " + (bikeCTicket == null ? "rejected" : "ticket " + bikeCTicket.getId()));

        System.out.println("---- paying and exiting remaining vehicles ----");
        parkingLot.exit(bikeBTicket, new Cash());
        parkingLot.exit(carTicket, new Cash());
        parkingLot.exit(truckTicket, new Cash());
        if (bikeCTicket != null){
            parkingLot.exit(bikeCTicket, new Cash());
        }

        System.out.println("---- switching to BestPossibleParkingSpot strategy ----");
        parkingLot.setParkingStrategy(new BestPossibleParkingSpot());

        // all spots are free again; carD takes the MEDIUM spot (tightest fit)
        Car carD = new Car(7777);
        ParkingTicket carDTicket = parkingLot.entry(carD);
        System.out.println("carD entry result: " + (carDTicket == null ? "rejected" : "ticket " + carDTicket.getId()));

        // MEDIUM spot is now taken; NearestParkingSpotStrategy would reject carE outright,
        // but BestPossibleParkingSpot lets it fall back to the LARGE spot
        Car carE = new Car(8888);
        ParkingTicket carETicket = parkingLot.entry(carE);
        System.out.println("carE entry result: " + (carETicket == null ? "rejected" : "ticket " + carETicket.getId()));

        parkingLot.exit(carDTicket, new Cash());
        parkingLot.exit(carETicket, new Cash());
    }
}
