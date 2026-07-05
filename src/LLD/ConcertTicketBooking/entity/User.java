package LLD.ConcertTicketBooking.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger counter = new AtomicInteger();
    @Getter
    private int id;
    @Setter
    private String name;
    @Setter
    private String email;

    public User(String name, String email) {
        this.id = counter.getAndIncrement();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
