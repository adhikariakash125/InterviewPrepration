package Misc.Wayfair.Intv2;

public class CartManagement {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new CartItem("Pencil",2, 5.0));
        cart.addItem(new CartItem("Paper",1, 10));

        System.out.println(cart.getTotalCartValue());
    }
}
