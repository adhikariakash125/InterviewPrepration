package Java.MultiThreading;

public class Test {
    public static void main(String[] args) {
//        World world = new World();
//        world.start();
        Hello hello = new Hello();
        Thread thread = new Thread(hello);
        thread.start();
    }
}
