package LLD.CarRentalSystem;

import LLD.CarRentalSystem.Vehicle.Vehicle;
import LLD.CarRentalSystem.Vehicle.VehicleType;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookingManager {
    private HashMap<VehicleType, List<Vehicle>> vehiclesMap;

    private HashMap<Integer, BookingDetails> bookingMap;

    public BookingManager() {
        this.vehiclesMap = new HashMap<>();
        this.bookingMap = new HashMap<>();
    }

    public void addBooking(BookingDetails bookingDetails){
        bookingMap.put(bookingDetails.getId(),bookingDetails);
    }

    public void cancelBooking(BookingDetails bookingDetails){
        bookingDetails.getVehicle().setBooked(false);
        bookingMap.remove(bookingDetails.getId());
    }

    public void updateBooking(BookingDetails bookingDetails){
        BookingDetails previousBooking = bookingMap.get(bookingDetails.getId());
        if (previousBooking.getVehicle()!=bookingDetails.getVehicle()){
            previousBooking.getVehicle().setBooked(false);
            previousBooking.setVehicle(bookingDetails.getVehicle());
        }
        previousBooking.setStartDate(bookingDetails.getStartDate());
        previousBooking.setEndDate(bookingDetails.getEndDate());
        bookingMap.put(previousBooking.getId(),previousBooking);
    }

    public void addVehicle(Vehicle vehicle){
        if (!vehiclesMap.containsKey(vehicle.getVehicleType())){
            vehiclesMap.put(vehicle.getVehicleType(),new ArrayList<>());
        }
        vehiclesMap.get(vehicle.getVehicleType()).add(vehicle);
    }

    public double getTotalCost(BookingDetails bookingDetails){
        return bookingDetails.getVehicle().getPrice();
    }

    public List<Vehicle> getAvailableCarsByType(VehicleType vehicleType){
        return vehiclesMap.get(vehicleType).stream()
                                    .filter(vehicle -> Boolean.TRUE.equals(vehicle.getBooked()))
                                    .toList();
    }

    public List<Vehicle> getAvailableCarsByDate(VehicleType vehicleType, Date date){
        List<Vehicle> availableCarsByType = getAvailableCarsByType(vehicleType);
        List<Vehicle> list = bookingMap.values().stream()
                                                .filter(v -> date.after(v.getEndDate()))
                                                .map(BookingDetails::getVehicle).toList();
        return Stream.concat(availableCarsByType.stream(), list.stream()).collect(Collectors.toList());
    }
}
