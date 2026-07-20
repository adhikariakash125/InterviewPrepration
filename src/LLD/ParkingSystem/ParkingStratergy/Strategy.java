package LLD.ParkingSystem.ParkingStratergy;

import LLD.ParkingSystem.ParkingLevel;
import LLD.ParkingSystem.ParkingSpot;
import LLD.ParkingSystem.enums.VehicleSize;

import java.util.List;

public interface Strategy {
    ParkingSpot getParkingSpots(List<ParkingLevel> levels, VehicleSize vehicleSize);
}
