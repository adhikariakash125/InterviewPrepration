package LLD.LRU;

import java.util.HashMap;

public class Cache {
    private static volatile Cache instance;
    private final HashMap<Integer, Node> cacheMap;
    private final Node left;
    private final Node right;
    private final int size;

    private Cache(int size) {
        this.cacheMap = new HashMap<>();
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        this.size = size;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public static Cache getInstance(int capacity) {
        if (instance == null) {
            synchronized (Cache.class) {
                if (instance == null) {
                    instance = new Cache(capacity);
                }
            }
        }
        return instance;
    }

    public synchronized void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node tempNode = cacheMap.get(key);
            removeNode(tempNode);
        }
        Node node = new Node(key, value);
        insertNode(node);
        cacheMap.put(key, node);
        if (cacheMap.size() > size) {
            Node leftMost = this.left.next;
            removeNode(leftMost);
            cacheMap.remove(leftMost.key);
        }
    }

    public synchronized Integer get(int key){
        if (cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            removeNode(node);
            insertNode(node);
            return node.value;
        }
        System.out.println("No key-value pair found for: " + key);
        return -1;
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertNode(Node node) {
        Node currFirstNode = this.right.prev;
        currFirstNode.next = node;
        node.prev = currFirstNode;
        node.next = this.right;
        this.right.prev = node;
    }
}
