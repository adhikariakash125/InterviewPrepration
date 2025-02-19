package LLD.PubSub;

public class Message<V> {
    V data;

    public Message(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }
}
