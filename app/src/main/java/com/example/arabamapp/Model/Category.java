package com.example.arabamapp.Model;

public class Category {

    private float id;
    private String name;

    public Category(float id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
