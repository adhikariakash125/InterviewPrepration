package Misc.Wayfair.Intv5;

public class Restaurant {
    private String name;
    private int maxOrders;
    private double rating;
    private Menu menu;
    private int orderCount;

    public Restaurant(String name, int maxOrders, double rating, Menu menu) {
        this.name = name;
        this.maxOrders = maxOrders;
        this.rating = rating;
        this.menu = menu;
        this.orderCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", maxOrders=" + maxOrders +
                ", rating=" + rating +
                ", menu=" + menu +
                '}';
    }
}
