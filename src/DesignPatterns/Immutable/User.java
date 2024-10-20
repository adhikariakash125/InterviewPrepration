package DesignPatterns.Immutable;

import java.util.HashMap;

final class User {
    private final int id;
    private final String name;
    private final HashMap<String, Integer> department;

    public User(int id, String name, HashMap<String, Integer> department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getDepartment() {
        return new HashMap<>(department);
    }
}


/*
 1. Make the class final
 2. Make the fields private & final
 3. Remove setter methods
 4. Make deep copy of immutable object like ( List, HashMap and collections)
 5. Set the objects using constructor
 */