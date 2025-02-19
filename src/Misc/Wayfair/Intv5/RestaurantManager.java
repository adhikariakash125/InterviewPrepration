package Misc.Wayfair.Intv5;

import java.util.*;

public class RestaurantManager {

    Map<String,Restaurant> restaurants;

    public RestaurantManager() {
        this.restaurants = new HashMap<>();
    }

    public void addRestaurant(String name, Restaurant restaurant) {
        restaurants.put(name,restaurant);
    }

    public void removeRestaurant(String name) {
        restaurants.remove(name);
    }

    public List<Restaurant> getAllRestaurant() {
        return restaurants.values().stream().toList();
    }

    public HashMap<String, Integer> getMenu(String name){
        return restaurants.get(name).getMenu().getItems();
    }

    public Restaurant updateMenu(String restaurantName, String item,int updatedPrice){
        Restaurant restaurant = restaurants.get(restaurantName);
        restaurant.getMenu().addItem(item,updatedPrice);
        return restaurant;
    }
}
