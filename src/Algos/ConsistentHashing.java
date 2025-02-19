package Algos;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
    private final TreeMap<Long, String> serverMap;
    private final int numberOfReplicas;
    private final MessageDigest md;

    public ConsistentHashing(int numberOfReplicas) throws NoSuchAlgorithmException {
        this.serverMap = new TreeMap<>();
        this.numberOfReplicas = numberOfReplicas;
        this.md = MessageDigest.getInstance("MD5");
    }

    public void addNode(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            long hash = generateHash(server + i);
            serverMap.put(hash, server);
        }
    }

    public void removeNode(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            long hash = generateHash(server + i);
            serverMap.remove(hash);
        }
    }

    public String getNode(String key) {
        if (serverMap.isEmpty()) return null;
        long hash = generateHash(key);
        if (!serverMap.containsKey(hash)) {
            SortedMap<Long, String> tailedMap = serverMap.tailMap(hash);
            hash = tailedMap.isEmpty() ? serverMap.firstKey() : tailedMap.firstKey();
        }
        return serverMap.get(hash);
    }

    private long generateHash(String key) {
        md.reset();
        md.update(key.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        long hash = ((long) (digest[3] & 0xFF) << 24) |
                ((long) (digest[2] & 0xFF) << 16) |
                ((long) (digest[1] & 0xFF) << 8) |
                ((long) (digest[0] & 0xFF));
        return hash;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ConsistentHashing ch = new ConsistentHashing(3);
        ch.addNode("server1");
        ch.addNode("server2");
        ch.addNode("server3");


        System.out.println("key1: is present on server: " + ch.getNode("key1"));
        System.out.println("key67890: is present on server: " + ch.getNode("key67890"));

        ch.removeNode("server1");
        System.out.println("After removing server1");

        System.out.println("key1: is present on server: " + ch.getNode("key1"));
        System.out.println("key67890: is present on server: " + ch.getNode("key67890"));

    }
}
