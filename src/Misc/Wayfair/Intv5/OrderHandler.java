package Misc.Wayfair.Intv5;

public class OrderHandler {

    public void placeOrder(Order order){
        // check if current order count is permissible
        Restaurant restaurant = order.getRestaurant();
        if(restaurant.getMaxOrders()>=restaurant.getOrderCount()+1){
            order.setOrderStatus(OrderStatus.ACCEPTED);
            restaurant.setOrderCount(restaurant.getOrderCount()+1);
        }else {
            order.setOrderStatus(OrderStatus.CANCELLED);
        }
    }

    public void deliverOrder(Order order){
        order.setOrderStatus(OrderStatus.DELIVERED);
        order.getRestaurant().setOrderCount(order.getRestaurant().getOrderCount()-1);
    }
}
