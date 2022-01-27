package com.example.subdivisionemergencyapp;

public class profile {
    public String fullName;
    public String email;
    public String age;
    public String address;
    public String phone;
    public long timestart;


    public profile() {


    }

    public profile (String fullName, String email, String Age, String Address, String phone, long timestart) {
        this.fullName = fullName;
        this.email = email;
        this.age = Age;
        this.address = Address;
        this.phone = phone;
        this.timestart = timestart;
    }

}