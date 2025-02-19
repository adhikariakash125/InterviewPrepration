package LLD.CarRentalSystem.Vehicle;

import java.util.Date;

public class Sedan extends Vehicle{
    public Sedan(String modelNumber, Date mfgYear, String numberPlate, int price, VehicleType vehicleType) {
        super(modelNumber, mfgYear, numberPlate, price,vehicleType);
    }
}
