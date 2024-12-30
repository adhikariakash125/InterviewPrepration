package Misc.Wayfair.Intv1;

abstract class Order {
    private final Integer amount;

    Order(Integer amount) {
        this.amount = amount;
    }

    Integer getAmount() {
        return amount;
    }
}
