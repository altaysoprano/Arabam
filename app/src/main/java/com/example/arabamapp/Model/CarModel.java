package com.example.arabamapp.Model;

import java.util.ArrayList;

public class CarModel {
    private float id;
    private String title;
    private Location location;
    private Category category;
    private String modelName;
    private float price;
    private String priceFormatted;
    private String date;
    private String dateFormatted;
    private String photo;
    private ArrayList<Property> properties;

    public CarModel(float id, String title, Location location, Category category, String modelName, float price, String priceFormatted, String date, String dateFormatted, String photo, ArrayList<Property> properties) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.category = category;
        this.modelName = modelName;
        this.price = price;
        this.priceFormatted = priceFormatted;
        this.date = date;
        this.dateFormatted = dateFormatted;
        this.photo = photo;
        this.properties = properties;
    }

    // Getter Methods

    public Location getLocationObject() {
        return location;
    }

    public void setLocationObject(Location locationObject) {
        this.location = locationObject;
    }

    public Category getCategoryObject() {
        return category;
    }

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Location getLocation() {
        return location;
    }

    public Category getCategory() {
        return category;
    }

    public String getModelName() {
        return modelName;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public String getDate() {
        return date;
    }

    public String getDateFormatted() {
        return dateFormatted;
    }

    public String getPhoto() {
        return photo;
    }

    // Setter Methods

    public void setCategoryObject(Category categoryObject) {
        this.category = categoryObject;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(Location locationObject) {
        this.location = locationObject;
    }

    public void setCategory(Category categoryObject) {
        this.category = categoryObject;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateFormatted(String dateFormatted) {
        this.dateFormatted = dateFormatted;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}