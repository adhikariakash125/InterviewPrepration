package LLD.ParkingSystem;

import LLD.ParkingSystem.ParkingStratergy.NearestParkingSpotStrategy;
import LLD.ParkingSystem.ParkingStratergy.Strategy;
import LLD.ParkingSystem.PaymentStrategy.PaymentService;
import LLD.ParkingSystem.Vehicle.Vehicle;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<ParkingLevel> parkingLevels = new ArrayList<>();
    private final Strategy parkingStrategy;

    private ParkingLot() {
        parkingStrategy = new NearestParkingSpotStrategy();
    }

    public static ParkingLot getInstance(){
        if (instance==null){
            synchronized (ParkingLot.class){
                if (instance==null){
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public ParkingSpot getAvailableSpot(VehicleSize vehicleSize){
        return parkingStrategy.getParkingSpots(parkingLevels, vehicleSize);
    }

    public ParkingTicket entry(Vehicle vehicle){
        ParkingSpot availableSpot = getAvailableSpot(vehicle.getVehicleSize());
        availableSpot.parkVehicle(vehicle);
        return new ParkingTicket(availableSpot);
    }

    public void exit(ParkingTicket parkingTicket, PaymentService paymentService){
        int moneyToBePaid = parkingTicket.calculateTotalPrice();
        ParkingSpot spot = parkingTicket.getSpot();
        paymentService.pay(moneyToBePaid);
        spot.freeParkingSpot();
    }


}
