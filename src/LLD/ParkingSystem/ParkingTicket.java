package LLD.ParkingSystem;

import LLD.ParkingSystem.Vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private static final AtomicInteger counter = new AtomicInteger();
    private int id;
    private ParkingSpot spot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingTicket(ParkingSpot spot) {
        this.id = counter.getAndIncrement();
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public void markExit(){
        this.exitTime = LocalDateTime.now();
    }

    public int calculateTotalPrice(){
        int price = spot.getPrice();
        LocalDateTime endTime = this.exitTime != null ? this.exitTime : LocalDateTime.now();
        long hours = Duration.between(endTime,entryTime).toMinutes();
        long totalTime = (hours + 59) / 60; // round of partial hours
        return (int) (price * totalTime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
