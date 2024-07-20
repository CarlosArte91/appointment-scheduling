package model.entity;

import java.util.UUID;

public abstract class User {
    private UUID id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        id = UUID.randomUUID();
    }

    public User() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toCSV() {
        return id + "," + name + "," + email;
    }
}
