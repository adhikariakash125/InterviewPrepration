package LLD.ParkingSystem.observer;

import LLD.ParkingSystem.ParkingLevel;
import LLD.ParkingSystem.ParkingSpot;

import java.util.concurrent.ConcurrentHashMap;

public class DisplayBoard implements ParkingObserver{
    @Override
    public void displaySpots(ParkingLevel parkingLevel) {
        ConcurrentHashMap<Integer, ParkingSpot> available = parkingLevel.getAvailable();
        System.out.println("Parking available for level:- " + parkingLevel.getLevel());
        for (ParkingSpot parkingSpot : available.values()){
            System.out.println("id: - "+ parkingSpot.getId());
            System.out.println("Parking size:- " + parkingSpot.getVehicleSize());
        }
    }
}
