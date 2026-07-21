package LLD.ParkingSystem.ParkingStrategy;

import LLD.ParkingSystem.ParkingLevel;
import LLD.ParkingSystem.ParkingSpot;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.List;

public class NearestParkingSpotStrategy implements Strategy{

    @Override
    public ParkingSpot getParkingSpots(List<ParkingLevel> levels, VehicleSize vehicleSize) {
        for (ParkingLevel parkingLevel : sortedByLevel(levels)){
            for (ParkingSpot parkingSpot : parkingLevel.getAvailable().values()){
                if (parkingSpot.getVehicleSize().equals(vehicleSize) && !parkingSpot.isOccupied())
                    return parkingSpot;
            }
        }
        System.out.println("No Parking Spot Found");
        return null;
    }
}
