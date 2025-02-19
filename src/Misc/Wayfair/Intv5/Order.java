package Misc.Wayfair.Intv5;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String userName;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(String userName, Restaurant restaurant) {
        this.userName = userName;
        this.orderItems = new ArrayList<>();
        this.restaurant = restaurant;
    }

    public double getTotal(){
        return orderItems.stream()
                .map(OrderItem::getTotal)
                .mapToDouble(Double::valueOf)
                .sum();
    }
}
