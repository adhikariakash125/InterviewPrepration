package LLD.ParkingSystem.ParkingStrategy;

import LLD.ParkingSystem.ParkingLevel;
import LLD.ParkingSystem.ParkingSpot;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.Comparator;
import java.util.List;

public interface Strategy {
    ParkingSpot getParkingSpots(List<ParkingLevel> levels, VehicleSize vehicleSize);

    default List<ParkingLevel> sortedByLevel(List<ParkingLevel> levels){
        return levels.stream().sorted(Comparator.comparingInt(ParkingLevel::getLevel)).toList();
    }
}
