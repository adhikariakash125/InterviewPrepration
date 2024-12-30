package Misc.Wayfair.Intv4;

import java.util.HashMap;
import java.util.Map;

public class Category {
    Map<String,String> coupons;
    Map<String,String> categories;

    public Category() {
        this.coupons = new HashMap<>();
        this.categories = new HashMap<>();
    }

    public static void getCoupon(String category){

    }
    public static void main(String[] args) {
        Category category = new Category();
        category.coupons.put("Comforter Sets","Comforters Sale");
        category.coupons.put("Bedding","Savings on Bedding");
        category.coupons.put("Bed & Bath","Low price for Bed & Bath");

        category.categories.put("Comforter Sets","Bedding");
        category.categories.put("Bedding","Bed & Bath");
        category.categories.put("Soap Dispensers","Bathroom Accessories");
        category.categories.put("Bathroom Accessories","Bed & Bath");
        category.categories.put("Toy Organizers","Baby And Kids");
        category.categories.put("Baby And Kids",null);

        getCoupon("");

    }
}
