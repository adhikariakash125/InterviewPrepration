package LLD.ParkingSystem.ParkingStratergy;

import LLD.ParkingSystem.ParkingLevel;
import LLD.ParkingSystem.ParkingSpot;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.*;
import java.util.stream.Collectors;

public class NearestParkingSpotStrategy implements Strategy{

    @Override
    public ParkingSpot getParkingSpots(List<ParkingLevel> levels, VehicleSize vehicleSize) {
        Set<ParkingLevel> collect = levels.stream().sorted(Comparator.comparingInt(ParkingLevel::getLevel)).collect(Collectors.toCollection(LinkedHashSet::new));
        for (ParkingLevel parkingLevel : collect){
            HashMap<Integer, ParkingSpot> available = parkingLevel.getAvailable();
            for (ParkingSpot parkingSpot : available.values()){
                if (parkingSpot.getVehicleSize().equals(vehicleSize))
                    return parkingSpot;
            }
        }
        System.out.println("No Parking Spot Found");
        return null;
    }
}
