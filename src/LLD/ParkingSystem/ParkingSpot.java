package LLD.ParkingSystem;

import LLD.ParkingSystem.Vehicle.Vehicle;
import LLD.ParkingSystem.enums.VehicleSize;

public class ParkingSpot {
    private int id;
    private int price;
    private boolean isOccupied;
    private Vehicle vehicle;
    private VehicleSize vehicleSize;

    public ParkingSpot(int id, int price, VehicleSize vehicleSize) {
        this.id = id;
        this.price = price;
        this.isOccupied = false;
        this.vehicleSize = vehicleSize;
    }

    public void freeParkingSpot(){
        this.isOccupied = false;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
}
