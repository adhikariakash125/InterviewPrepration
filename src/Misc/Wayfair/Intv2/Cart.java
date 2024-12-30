package Misc.Wayfair.Intv2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(CartItem cartItem){
        cartItems.add(cartItem);
        System.out.println("Added Cart Item :- "+ cartItem.getProductName());
    }

    public void removeItem(CartItem cartItem){
        cartItems.remove(cartItem);
        System.out.println("Removed Cart Item :- "+ cartItem.getProductName());
    }

    public double getTotalCartValue(){
        return cartItems.stream()
                .map(CartItem::totalPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
