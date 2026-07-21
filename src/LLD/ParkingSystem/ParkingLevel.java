package LLD.ParkingSystem;

import LLD.ParkingSystem.Vehicle.Vehicle;
import LLD.ParkingSystem.observer.ParkingObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLevel {
    private final int level;
    private final ConcurrentHashMap<Integer, ParkingSpot> available;
    private final ConcurrentHashMap<Integer, ParkingSpot> occupied;
    private final List<ParkingObserver> observers = new ArrayList<>();


    public ParkingLevel(int level) {
        this.level = level;
        this.available = new ConcurrentHashMap<>();
        this.occupied = new ConcurrentHashMap<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpot.setParkingLevel(this);
        available.put(parkingSpot.getId(), parkingSpot);
    }

    public synchronized ParkingSpot occupySpot(ParkingSpot parkingSpot, Vehicle vehicle){
        ParkingSpot spot = available.remove(parkingSpot.getId());
        if (spot!=null){
            spot.parkVehicle(vehicle);
            occupied.put(spot.getId(),spot);
            System.out.println("Parking Spot booked with id: " + spot.getId());
            notifyObservers();
            return spot;
        }
        System.out.println("No parking spot available with id :- " + parkingSpot.getId());
        return null;
    }

    public synchronized void freeSpot(ParkingSpot parkingSpot){
        ParkingSpot spot = occupied.remove(parkingSpot.getId());
        if (spot!=null){
            spot.freeParkingSpot();
            available.put(spot.getId(),spot);
            notifyObservers();
        }
    }

    public int getLevel() {
        return level;
    }

    public ConcurrentHashMap<Integer, ParkingSpot> getAvailable() {
        return available;
    }

    public ConcurrentHashMap<Integer, ParkingSpot> getOccupied() {
        return occupied;
    }

    public void addObserver(ParkingObserver parkingObserver){
        observers.add(parkingObserver);
    }

    public void notifyObservers(){
        for (ParkingObserver observer : observers){
            observer.displaySpots(this);
        }
    }
}
