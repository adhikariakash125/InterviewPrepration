package LLD.ParkingSystem.PaymentStrategy;

public class Cash implements PaymentService{
    @Override
    public boolean pay(int amount) {
        System.out.println("Received amount:- " + amount);
        return true;
    }
}
