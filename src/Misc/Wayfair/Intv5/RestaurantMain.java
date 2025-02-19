package Misc.Wayfair.Intv5;

public class RestaurantMain {
    public static void main(String[] args) {
        RestaurantManager restaurantManager = new RestaurantManager();
        Menu r1menu = new Menu();
        r1menu.addItem("Veg Biryani",100);
        r1menu.addItem("Paneer Butter Masala",150);
        restaurantManager.addRestaurant("R1", new Restaurant("R1", 5 , 0, r1menu));
        System.out.println(restaurantManager.getMenu("R1"));
        System.out.println(restaurantManager.updateMenu("R1","Paneer Butter Masala",300));

    }
}
