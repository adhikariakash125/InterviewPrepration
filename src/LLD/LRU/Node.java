package LLD.LRU;

public class Node<K, V> {
    Node<K, V> prev;
    Node<K, V> next;
    int id;
    String name;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
