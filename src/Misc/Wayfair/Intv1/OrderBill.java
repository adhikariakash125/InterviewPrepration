package Misc.Wayfair.Intv1;

import java.util.ArrayList;
import java.util.List;

class OrderBill {
    private final List<Order> orders;

    // todo - singleton for orderBill
    OrderBill() {
        orders = new ArrayList<>();
    }

    public void addOrder(final Integer amount) {
        orders.add(OrderFactory.createOrder(amount));
    }

    public Double calculateBillAmount() {
        return orders
                .stream()
                .map(order -> Double.valueOf(order.getAmount()) - DiscountCalculator.calculateDiscount(order))
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}