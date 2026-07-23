package LLD.LRU;

public class LRUDemo {
    public static void main(String[] args) {
        Cache cache = Cache.getInstance(5); // capacity now specified by the caller

        System.out.println("---- basic put/get ----");
        cache.put(1, 100);
        System.out.println("get(1) expect 100: " + cache.get(1));

        System.out.println("---- update existing key ----");
        cache.put(1, 999);
        System.out.println("get(1) expect 999: " + cache.get(1));

        System.out.println("---- get on missing key ----");
        System.out.println("get(42) expect -1: " + cache.get(42));

        System.out.println("---- filling cache to capacity ----");
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        // LRU -> MRU order right now: 1, 2, 3, 4, 5

        System.out.println("---- touching key 1 so key 2 becomes the new LRU ----");
        cache.get(1);
        // LRU -> MRU order right now: 2, 3, 4, 5, 1

        System.out.println("---- overflowing capacity, should evict key 2 ----");
        cache.put(6, 6);

        System.out.println("get(2) expect -1 (evicted): " + cache.get(2));
        System.out.println("get(1) expect 999 (survived, was touched): " + cache.get(1));
        System.out.println("get(3) expect 3 (survived): " + cache.get(3));
        System.out.println("get(6) expect 6 (just added): " + cache.get(6));
    }
}
