package LLD.ParkingSystem.Vehicle;

import LLD.ParkingSystem.enums.VehicleSize;

public class Car extends Vehicle{
    public Car(int licenseNumber) {
        super(VehicleSize.MEDIUM, licenseNumber);
    }
}
