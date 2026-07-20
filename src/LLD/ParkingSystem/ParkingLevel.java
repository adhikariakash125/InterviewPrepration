package LLD.ParkingSystem;

import java.util.HashMap;
import java.util.List;

public class ParkingLevel {
    private int level;
    private HashMap<Integer, ParkingSpot> available;
    private HashMap<Integer, ParkingSpot> occupied;

    public ParkingLevel(int level) {
        this.level = level;
        this.available = new HashMap<>();
        this.occupied = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        available.put(parkingSpot.getId(), parkingSpot);
    }

    public void occupySpot(ParkingSpot parkingSpot){
        ParkingSpot spot = available.get(parkingSpot.getId());
        if (spot!=null){
            available.remove(spot.getId());
            occupied.put(spot.getId(),spot);
            System.out.println("Parking Spot booked with id: " + spot.getId());
            return;
        }
        System.out.println("No parking spot available with id :- " + spot.getId());
    }

    public void freeSpot(ParkingSpot parkingSpot){
        ParkingSpot spot = occupied.get(parkingSpot.getId());
        if (spot!=null){
            spot.freeParkingSpot();
            occupied.remove(spot.getId());
            available.put(spot.getId(),spot);
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HashMap<Integer, ParkingSpot> getAvailable() {
        return available;
    }

    public void setAvailable(HashMap<Integer, ParkingSpot> available) {
        this.available = available;
    }

    public HashMap<Integer, ParkingSpot> getOccupied() {
        return occupied;
    }

    public void setOccupied(HashMap<Integer, ParkingSpot> occupied) {
        this.occupied = occupied;
    }
}
