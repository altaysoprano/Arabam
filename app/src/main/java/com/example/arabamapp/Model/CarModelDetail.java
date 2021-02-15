package com.example.arabamapp.Model;

import java.util.ArrayList;

public class CarModelDetail {
    private float id;
    private String title;
    private Location location;
    private Category category;
    private String modelName;
    private float price;
    private String priceFormatted;
    private String date;
    private String dateFormatted;
    ArrayList< String > photos;
    ArrayList < Property > properties;
    private String text;
    private UserInfo userInfo;

    public CarModelDetail(float id, String title, Location location, Category category,
                          String modelName, float price, String priceFormatted, String date,
                          String dateFormatted, ArrayList<String> photos, ArrayList<Property> properties,
                          String text, UserInfo userInfo) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.category = category;
        this.modelName = modelName;
        this.price = price;
        this.priceFormatted = priceFormatted;
        this.date = date;
        this.dateFormatted = dateFormatted;
        this.photos = photos;
        this.properties = properties;
        this.text = text;
        this.userInfo = userInfo;
    }
// Getter Methods

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

    public String getText() {
        return text;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    // Setter Methods

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

    public void setText(String text) {
        this.text = text;
    }

    public void setUserInfo(UserInfo userInfoObject) {
        this.userInfo = userInfoObject;
    }

    public Location getLocationObject() {
        return location;
    }

    public void setLocationObject(Location locationObject) {
        location = locationObject;
    }

    public Category getCategoryObject() {
        return category;
    }

    public void setCategoryObject(Category categoryObject) {
        category = categoryObject;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public UserInfo getUserInfoObject() {
        return userInfo;
    }

    public void setUserInfoObject(UserInfo userInfoObject) {
        userInfo = userInfoObject;
    }

}
