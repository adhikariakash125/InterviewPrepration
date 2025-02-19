package LLD.CarRentalSystem;

import LLD.CarRentalSystem.Vehicle.Vehicle;
import LLD.CarRentalSystem.Vehicle.VehicleType;

import java.util.Date;

public class RentalService {
    public static void main(String[] args) {
        // Create Cars
        Vehicle ciaz = new Vehicle("AVC",
                new Date(2020, 1, 1),
                "23BH123",
                5,
                VehicleType.SEDAN);

        Vehicle city = new Vehicle("RTY",
                new Date(2014, 1, 1),
                "12BH13",
                8,
                VehicleType.SEDAN);

        Vehicle baleno = new Vehicle("EDF",
                new Date(2016, 1, 1),
                "22BH63",
                2,
                VehicleType.HATCHBACK);

        Vehicle thar = new Vehicle("POI",
                new Date(2014, 1, 1),
                "20BH43",
                10,
                VehicleType.COUPE);

        // add Cars
        BookingManager bookingManager = new BookingManager();
        bookingManager.addVehicle(ciaz);
        bookingManager.addVehicle(city);
        bookingManager.addVehicle(baleno);
        bookingManager.addVehicle(thar);

        //
    }
}
