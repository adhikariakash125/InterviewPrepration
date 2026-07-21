package LLD.ParkingSystem;

import LLD.ParkingSystem.Vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
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
        long minutes = Duration.between(entryTime, endTime).toMinutes();
        long billedHours = Math.max(1, (minutes + 59) / 60); // round up, minimum 1 hour
        return (int) (price * billedHours);
    }

    public int getId() {
        return id;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
