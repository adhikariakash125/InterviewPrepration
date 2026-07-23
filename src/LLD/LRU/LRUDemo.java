package LLD.LRU;

public class LRUDemo {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(5);

        System.out.println("---- basic put/get ----");
        cache.put("a", 100);
        System.out.println("get(a) expect 100: " + cache.get("a"));

        System.out.println("---- update existing key ----");
        cache.put("a", 999);
        System.out.println("get(a) expect 999: " + cache.get("a"));

        System.out.println("---- get on missing key ----");
        System.out.println("get(missing) expect null: " + cache.get("missing"));

        System.out.println("---- filling cache to capacity ----");
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);
        cache.put("e", 5);
        // LRU -> MRU order right now: a, b, c, d, e

        System.out.println("---- touching key a so key b becomes the new LRU ----");
        cache.get("a");
        // LRU -> MRU order right now: b, c, d, e, a

        System.out.println("---- overflowing capacity, should evict key b ----");
        cache.put("f", 6);

        System.out.println("get(b) expect null (evicted): " + cache.get("b"));
        System.out.println("get(a) expect 999 (survived, was touched): " + cache.get("a"));
        System.out.println("get(c) expect 3 (survived): " + cache.get("c"));
        System.out.println("get(f) expect 6 (just added): " + cache.get("f"));
    }
}
