package LLD.ParkingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private final Map<Integer, ParkingLevel> parkingLotMap;
    private static ParkingLot parkingLot;

    public static synchronized ParkingLot getInstance() {
        if (parkingLot != null) {
            return parkingLot;
        }
        return new ParkingLot();
    }

    private ParkingLot() {
        this.parkingLotMap = new ConcurrentHashMap<>();
    }

    public Map<Integer, ParkingLevel> getParkingLotMap() {
        return parkingLotMap;
    }

    public void addParkingLevel(ParkingLevel parkingLevel){
        parkingLotMap.put(parkingLevel.getId(),parkingLevel);
    }

    public Map<Integer, List<ParkingSpot>> getFreeSpacesByLevel() {
        Map<Integer, List<ParkingSpot>> availableSpace = new HashMap<>();
        for (Integer parkingLevels : parkingLotMap.keySet()) {
            Map<Integer, ParkingSpot> parkingSpots = parkingLotMap.get(parkingLevels).getParkingSpots();
            List<ParkingSpot> emptySpaces = parkingSpots.values()
                                                        .stream()
                                                        .filter(spots -> spots.getEmpty().equals(Boolean.TRUE))
                                                        .toList();
            availableSpace.put(parkingLevels, emptySpaces);
        }
        return availableSpace;
    }

    public void parkVehicle(Integer level, Integer spotNumber, Vehicle vehicle){
        ParkingLevel parkingLevel = parkingLotMap.get(level);
        if (parkingLevel!=null)
            parkingLevel.occupySpot(spotNumber,vehicle);
        else{
            System.out.println("No such level");
        }
    }

    public void unParkVehicle(Integer level,Integer spotNumber){
        ParkingLevel parkingLevel = parkingLotMap.get(level);
        if (parkingLevel!=null)
            parkingLevel.emptySpot(spotNumber);
        else{
            System.out.println("No such level");
        }
    }
}
