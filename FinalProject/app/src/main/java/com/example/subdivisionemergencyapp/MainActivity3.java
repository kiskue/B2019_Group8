package com.example.subdivisionemergencyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {

    Button confirm_button;

    CheckBox fire,chemicalSpills,damFailure,earthquake,floods,covidRelated,thunderstorms,robbery,lossChild,rabies,extremeHeat,needAmbulance;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member member;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        reference = database.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());


        member = new Member();
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

        String e1 = "Fire";
        String e2 = "Chemical Spills";
        String e3 = "Dam Failure";
        String e4 = "Earthquake";
        String e5 = "Floods";
        String e6 = "Covid Related";
        String e7 = "Thunderstorms";
        String e8 = "Robbery";
        String e9 = "Loss Child";
        String e10 = "Rabies";
        String e11 = "Extreme Heat";
        String e12 = "Need Ambulance";
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
///
            }
        });

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fire.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Fire checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency1(e1);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (chemicalSpills.isChecked()){
                //    Toast.makeText(getApplicationContext(), "Chemical Spills checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency2(e2);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (damFailure.isChecked()){
                //    Toast.makeText(getApplicationContext(), "Dam Failure checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency3(e3);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (earthquake.isChecked()){
                //    Toast.makeText(getApplicationContext(), "Earthquake checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency4(e4);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (floods.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Flood checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency5(e5);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (covidRelated.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Covid checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency6(e6);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (thunderstorms.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Thunderstorms checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency7(e7);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (robbery.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Robbery checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency8(e8);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (lossChild.isChecked()){
                //    Toast.makeText(getApplicationContext(), "Loss child checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency9(e9);
                    reference.child(String.valueOf(i+1)).setValue(member);



                }else {

                }
                if (rabies.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Rabies checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency10(e10);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (extremeHeat.isChecked()){
                 //   Toast.makeText(getApplicationContext(), "Extreme Heat checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency11(e11);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (needAmbulance.isChecked()){
                  //  Toast.makeText(getApplicationContext(), "Need Ambulance checked", Toast.LENGTH_SHORT).show();

                    member.setEmergency12(e12);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }

            }
        });
    }
}