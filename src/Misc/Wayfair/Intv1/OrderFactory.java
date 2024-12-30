package Misc.Wayfair.Intv1;

public class OrderFactory {

    public static Order createOrder(Integer amount) {
        if (amount<40) return new MinimumOrder(amount);
        else if (amount<100) return new MediumOrder(amount);
        else return new MaximumOrder(amount);
    }
}
