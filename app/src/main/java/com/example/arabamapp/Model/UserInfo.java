package com.example.arabamapp.Model;

public class UserInfo {

    private float id;
    private String nameSurname;
    private String phone;
    private String phoneFormatted;

    public UserInfo(float id, String nameSurname, String phone, String phoneFormatted) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phone = phone;
        this.phoneFormatted = phoneFormatted;
    }

// Getter Methods

    public float getId() {
        return id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhoneFormatted() {
        return phoneFormatted;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoneFormatted(String phoneFormatted) {
        this.phoneFormatted = phoneFormatted;
    }
}

