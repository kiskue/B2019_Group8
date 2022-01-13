package com.example.subdivisionemergencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button confirm_button;

    CheckBox fire,chemicalSpills,damFailure,earthquake,floods,covidRelated,thunderstorms,robbery,lossChild,rabies,extremeHeat,needAmbulance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        confirm_button = findViewById(R.id.confirm_button);
        fire = findViewById(R.id.fire);
        chemicalSpills = findViewById(R.id.chemicalSpills);
        damFailure = findViewById(R.id.damFailure);
        earthquake = findViewById(R.id.earthquake);
        floods = findViewById(R.id.floods);
        covidRelated = findViewById(R.id.covidRelated);
        thunderstorms = findViewById(R.id.thunderStorms);
        robbery = findViewById(R.id.robbery);
        lossChild = findViewById(R.id.lossChild);
        rabies = findViewById(R.id.rabies);
        extremeHeat = findViewById(R.id.extremeHeat);
        needAmbulance = findViewById(R.id.needAmbulance);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fire.isChecked()){
                    Toast.makeText(getApplicationContext(), "Fire checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (chemicalSpills.isChecked()){
                    Toast.makeText(getApplicationContext(), "Chemical Spills checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (damFailure.isChecked()){
                    Toast.makeText(getApplicationContext(), "Dam Failure checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (earthquake.isChecked()){
                    Toast.makeText(getApplicationContext(), "Earthquake checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (floods.isChecked()){
                    Toast.makeText(getApplicationContext(), "Flood checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (covidRelated.isChecked()){
                    Toast.makeText(getApplicationContext(), "Covid checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (thunderstorms.isChecked()){
                    Toast.makeText(getApplicationContext(), "Thunderstorms checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (robbery.isChecked()){
                    Toast.makeText(getApplicationContext(), "Robbery checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (lossChild.isChecked()){
                    Toast.makeText(getApplicationContext(), "Loss child checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (rabies.isChecked()){
                    Toast.makeText(getApplicationContext(), "Rabies checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (extremeHeat.isChecked()){
                    Toast.makeText(getApplicationContext(), "Extreme Heat checked", Toast.LENGTH_SHORT).show();
                }else {

                }
                if (needAmbulance.isChecked()){
                    Toast.makeText(getApplicationContext(), "Need Ambulance checked", Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });
    }
}