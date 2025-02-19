package Misc.Wayfair.Intv5;

import java.util.HashMap;

public class Menu {
    HashMap<String,Integer> items;

    public Menu() {
        items = new HashMap<>();
    }

    public void addItem(String name, int price){
        items.put(name,price);
    }

    public void removeItem(String name){
        items.remove(name);
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "items=" + items +
                '}';
    }
}
