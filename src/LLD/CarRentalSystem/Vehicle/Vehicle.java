package LLD.CarRentalSystem.Vehicle;

import java.util.Date;

public class Vehicle {
    private String modelNumber;
    private Date mfgYear;
    private String numberPlate;
    private int price;
    private VehicleType vehicleType;
    private Boolean isBooked;

    public Vehicle(String modelNumber, Date mfgYear, String numberPlate, int price, VehicleType vehicleType) {
        this.modelNumber = modelNumber;
        this.mfgYear = mfgYear;
        this.numberPlate = numberPlate;
        this.price = price;
        this.vehicleType = vehicleType;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Date getMfgYear() {
        return mfgYear;
    }

    public void setMfgYear(Date mfgYear) {
        this.mfgYear = mfgYear;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
