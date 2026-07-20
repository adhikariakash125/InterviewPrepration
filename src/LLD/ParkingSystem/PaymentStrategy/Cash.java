package LLD.ParkingSystem.PaymentStrategy;

public class Cash implements PaymentService{
    @Override
    public void pay(int amount) {
        System.out.println("Received amount:- " + amount);
    }
}
