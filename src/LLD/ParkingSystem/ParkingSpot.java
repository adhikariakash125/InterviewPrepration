package LLD.ParkingSystem;

import LLD.ParkingSystem.Vehicle.Vehicle;
import LLD.ParkingSystem.enums.VehicleSize;

public class ParkingSpot {
    private int id;
    private int price;
    private boolean isOccupied;
    private Vehicle vehicle;
    private VehicleSize vehicleSize;
    private ParkingLevel parkingLevel;

    public ParkingSpot(int id, int price, VehicleSize vehicleSize) {
        this.id = id;
        this.price = price;
        this.isOccupied = false;
        this.vehicleSize = vehicleSize;
    }

    public void freeParkingSpot(){
        this.isOccupied = false;
        this.vehicle = null;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setParkingLevel(ParkingLevel parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }
}
