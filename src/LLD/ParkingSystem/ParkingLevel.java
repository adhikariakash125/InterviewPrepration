package LLD.ParkingSystem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLevel {
    private int id;
    private final Map<Integer,ParkingSpot> parkingSpots; // key is parkingSpot location on level -> Lvl 1 P 3

    public ParkingLevel(int id) {
        this.id = id;
        this.parkingSpots = new ConcurrentHashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpots.put(parkingSpot.getId(),parkingSpot);
    }

    public void occupySpot(int spotNumber,Vehicle vehicle){
        ParkingSpot parkingSpot = parkingSpots.get(spotNumber);
        if (parkingSpot==null){
            System.out.println("No such parking spot present");
            return;
        }
        if (!parkingSpot.getAllowedVehicle().equals(vehicle)){
            throw new IllegalStateException(vehicle + " vehicle is not supported at this spot");
        }
        parkingSpot.setEmpty(Boolean.FALSE);
        parkingSpots.put(spotNumber,parkingSpot);
    }

    public void emptySpot(Integer spotNumber) {
        ParkingSpot parkingSpot = parkingSpots.get(spotNumber);
        if (parkingSpot==null){
            System.out.println("No such parking spot present");
        }else {
            parkingSpot.setEmpty(Boolean.TRUE);
            parkingSpots.put(spotNumber,parkingSpot);
        }
    }
}
