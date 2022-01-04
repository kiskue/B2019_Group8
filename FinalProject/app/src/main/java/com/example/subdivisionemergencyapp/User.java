package com.example.subdivisionemergencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class User {

    public String fullName, email, age, address, phone;


    public User(String fullName, String email, String Age, String Address, String phone){
        this.fullName = fullName;
        this.email= email;
        this.age = Age;
        this.address = Address;
        this.phone = phone;
    }
}
