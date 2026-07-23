package LLD.LRU;

import java.util.HashMap;

public class LRUCache<K,V> {
    private final HashMap<K, Node<K,V>> cacheMap;
    private final Node<K,V> left;
    private final Node<K,V> right;
    private final int size;

    public LRUCache(int size) {
        this.cacheMap = new HashMap<>();
        this.left = new Node<K,V>(null, null);
        this.right = new Node<K,V>(null,null);
        this.size = size;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public synchronized void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            Node<K, V> tempNode = cacheMap.get(key);
            removeNode(tempNode);
        }
        Node<K, V> node = new Node<>(key, value);
        insertNode(node);
        cacheMap.put(key, node);
        if (cacheMap.size() > size) {
            Node<K, V> leftMost = this.left.next;
            removeNode(leftMost);
            cacheMap.remove(leftMost.key);
        }
    }

    public synchronized V get(K key){
        if (cacheMap.containsKey(key)){
            Node<K, V> node = cacheMap.get(key);
            removeNode(node);
            insertNode(node);
            return node.value;
        }
        System.out.println("No key-value pair found for: " + key);
        return null;
    }

    private void removeNode(Node<K, V> node) {
        Node<K, V> prevNode = node.prev;
        Node<K, V> nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertNode(Node<K, V> node) {
        Node<K, V> currFirstNode = this.right.prev;
        currFirstNode.next = node;
        node.prev = currFirstNode;
        node.next = this.right;
        this.right.prev = node;
    }
}
