package LLD.LRU;

import java.util.HashMap;

public class LRU<K,V> {
    Node<K,V> left;
    Node<K,V> right;
    HashMap<Integer, Node<K,V>> lruMap = new HashMap<>();

    private final int size;

    public LRU(int size) {
        this.size = size;
        left = new Node<>(0, null);
        right = new Node<>(0, null);
        left.next = right;
        right.prev = left;
    }

    public void addData(int key, String value) {
        if(lruMap.containsKey(key)){
            remove(lruMap.get(key));
        }
        Node<K,V> newNode = new Node<>(key,value);
        lruMap.put(key,newNode);
        insert(lruMap.get(key));
        if (lruMap.size()>this.size){
            lruMap.remove(left.next.id);
            remove(left.next);
        }
    }

    public void deleteData(int key) {
        if (lruMap.containsKey(key)){
            remove(lruMap.get(key));
            lruMap.remove(key);
        }
    }

    public String getData(int key){
        if (lruMap.containsKey(key)){
            remove(lruMap.get(key));
            insert(lruMap.get(key));
            return lruMap.get(key).name;
        }
        return "Key not found";
    }

    private void insert(Node<K,V> node) {
        Node<K,V> temp = right.prev;
        temp.next = node;
        node.prev = temp;
        node.next = right;
        right.prev = node;
    }

    private void remove(Node<K,V> node) {
        Node<K,V> tempPrev = node.prev;
        Node<K,V> tempNext = node.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }
}