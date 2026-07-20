package LLD.ParkingSystem.Vehicle;

import LLD.ParkingSystem.enums.VehicleSize;

public abstract class Vehicle {
    VehicleSize vehicleSize;
    int licenseNumber;

    public Vehicle(VehicleSize vehicleSize, int licenseNumber) {
        this.vehicleSize = vehicleSize;
        this.licenseNumber = licenseNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }
}
