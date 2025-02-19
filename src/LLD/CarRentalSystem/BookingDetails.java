package LLD.CarRentalSystem;

import LLD.CarRentalSystem.Vehicle.Vehicle;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingDetails {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int id;
    private Date startDate;
    private Date endDate;
    private Double totalCost;
    private Vehicle vehicle;
    private User user;

    public BookingDetails(Date startDate, Date endDate, Vehicle vehicle, User user) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicle = vehicle;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotalCost() {
        long totalTime = TimeUnit.MILLISECONDS.toDays(endDate.getTime() - startDate.getTime()) % 365;
        return (double) (getVehicle().getPrice() * totalTime);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
