package Misc.Wayfair.Intv1;

public class OrderManagement {
    public static void main(String[] args) {
        OrderBill orderBill = new OrderBill();
        orderBill.addOrder(40);
        orderBill.addOrder(100);

        Double billAmount = orderBill.calculateBillAmount();
        System.out.println(billAmount);
    }
}
