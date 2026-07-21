package LLD.ParkingSystem.ParkingStrategy;

import LLD.ParkingSystem.ParkingLevel;
import LLD.ParkingSystem.ParkingSpot;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.List;

public class BestPossibleParkingSpot implements Strategy{
    @Override
    public ParkingSpot getParkingSpots(List<ParkingLevel> levels, VehicleSize vehicleSize) {
        for (ParkingLevel parkingLevel : sortedByLevel(levels)){
            ParkingSpot bestSuited = null;
            for (ParkingSpot parkingSpot : parkingLevel.getAvailable().values()){
                if (parkingSpot.getVehicleSize().ordinal() < vehicleSize.ordinal())
                    continue; // too small to fit this vehicle
                if (bestSuited == null || parkingSpot.getVehicleSize().ordinal() < bestSuited.getVehicleSize().ordinal())
                    bestSuited = parkingSpot; // tighter fit than what we've seen on this level
            }
            if (bestSuited != null){
                System.out.println("Parking Spot found");
                return bestSuited;
            }
        }
        System.out.println("No Parking Spot Found");
        return null;
    }
}
