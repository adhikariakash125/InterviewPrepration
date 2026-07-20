package LLD.ParkingSystem.Vehicle;

import LLD.ParkingSystem.enums.VehicleSize;

public class Bike extends Vehicle{
    public Bike(int licenseNumber) {
        super(VehicleSize.SMALL, licenseNumber);
    }
}
