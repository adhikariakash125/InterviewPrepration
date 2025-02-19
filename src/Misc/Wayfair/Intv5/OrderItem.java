package Misc.Wayfair.Intv5;

public class OrderItem {
    private String  name;
    private int quantity;
    private int price;

    public OrderItem(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal(){
        return quantity * price;
    }
}
