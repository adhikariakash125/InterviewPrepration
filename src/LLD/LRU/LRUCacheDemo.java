package LLD.LRU;

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRU<Integer,String> cache = new LRU<>(3);
        cache.addData(1, "Value 1");
        cache.addData(2, "Value 2");
        cache.addData(3, "Value 3");

        System.out.println(cache.getData(1)); // Output: Value 1
        System.out.println(cache.getData(2)); // Output: Value 2

        cache.addData(4, "Value 4");

        System.out.println(cache.getData(3)); // Output: null
        System.out.println(cache.getData(4)); // Output: Value 4

        cache.addData(2, "Updated Value 2");

        System.out.println(cache.getData(1)); // Output: Value 1
        System.out.println(cache.getData(2)); // Output: Updated Value 2
    }
}
