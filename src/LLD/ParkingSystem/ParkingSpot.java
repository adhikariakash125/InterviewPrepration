package LLD.ParkingSystem;

public class ParkingSpot {
    private Integer id;
    private Boolean isEmpty;
    private Vehicle allowedVehicle;

    public ParkingSpot(int id, Vehicle allowedVehicle) {
        this.id = id;
        this.isEmpty = true;
        this.allowedVehicle = allowedVehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getAllowedVehicle() {
        return allowedVehicle;
    }

    public void setAllowedVehicle(Vehicle allowedVehicle) {
        this.allowedVehicle = allowedVehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", isEmpty=" + isEmpty +
                ", allowedVehicle=" + allowedVehicle +
                '}';
    }
}
