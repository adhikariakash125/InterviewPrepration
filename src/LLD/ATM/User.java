package LLD.ATM;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    private int id;
    private String name;

    public User(String name) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
