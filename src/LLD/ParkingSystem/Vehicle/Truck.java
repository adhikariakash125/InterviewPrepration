package LLD.ParkingSystem.Vehicle;

import LLD.ParkingSystem.enums.VehicleSize;

public class Truck extends Vehicle{

    public Truck(int licenseNumber) {
        super(VehicleSize.LARGE, licenseNumber);
    }
}
