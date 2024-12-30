package Misc.Wayfair.Intv1;

public class DiscountCalculator {
    public static Double calculateDiscount(Order order) {
        if (order instanceof MinimumOrder)
            return 40.00;
        else if (order instanceof MediumOrder) {
            return 0.2 * order.getAmount();
        }else return 0.15 * order.getAmount();
    }
}
