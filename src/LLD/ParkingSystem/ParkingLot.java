package LLD.ParkingSystem;

import LLD.ParkingSystem.ParkingStrategy.NearestParkingSpotStrategy;
import LLD.ParkingSystem.ParkingStrategy.Strategy;
import LLD.ParkingSystem.PaymentStrategy.PaymentService;
import LLD.ParkingSystem.Vehicle.Vehicle;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final List<ParkingLevel> parkingLevels = new ArrayList<>();
    private Strategy parkingStrategy;

    private ParkingLot() {
        parkingStrategy = new NearestParkingSpotStrategy();
    }

    public void setParkingStrategy(Strategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
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

    public void addLevel(ParkingLevel parkingLevel){
        parkingLevels.add(parkingLevel);
    }

    public ParkingSpot getAvailableSpot(VehicleSize vehicleSize){
        return parkingStrategy.getParkingSpots(parkingLevels, vehicleSize);
    }

    public ParkingTicket entry(Vehicle vehicle){
        ParkingSpot availableSpot = getAvailableSpot(vehicle.getVehicleSize());
        if (availableSpot == null){
            System.out.println("No available spot for vehicle: " + vehicle.getLicenseNumber());
            return null;
        }
        ParkingSpot reservedSpot = availableSpot.getParkingLevel().occupySpot(availableSpot, vehicle);
        if (reservedSpot == null){
            System.out.println("Spot was taken by another vehicle, please retry: " + vehicle.getLicenseNumber());
            return null;
        }
        return new ParkingTicket(reservedSpot);
    }

    public Payment exit(ParkingTicket parkingTicket, PaymentService paymentService){
        parkingTicket.markExit();
        int amountDue = parkingTicket.calculateTotalPrice();
        boolean paymentSucceeded = paymentService.pay(amountDue);
        PaymentStatus status = paymentSucceeded ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
        if (paymentSucceeded){
            ParkingSpot spot = parkingTicket.getSpot();
            spot.getParkingLevel().freeSpot(spot);
        }
        return new Payment(parkingTicket.getId(), amountDue, status, paymentService);
    }

    public HashMap<Integer, List<ParkingSpot>> getAvailableParkingSpots(){
        HashMap<Integer,List<ParkingSpot>> availableParkingSpots = new HashMap<>();
        for (ParkingLevel parkingLevel : this.parkingLevels) {
            availableParkingSpots.put(parkingLevel.getLevel(), parkingLevel.getAvailable().values().stream().toList());
        }
        return availableParkingSpots;
    }
}