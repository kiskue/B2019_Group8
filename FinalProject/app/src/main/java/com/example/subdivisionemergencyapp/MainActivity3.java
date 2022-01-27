package com.example.subdivisionemergencyapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity  {
    DatabaseReference mRef;
    SharedPreferences sp;
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
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Emergency");
        member = new Member();
        confirm_button = findViewById(R.id.confirm_button);
        fire = (CheckBox) findViewById(R.id.fire);
        chemicalSpills = (CheckBox) findViewById(R.id.chemicalSpills);
        damFailure = (CheckBox) findViewById(R.id.damFailure);
        earthquake = (CheckBox) findViewById(R.id.earthquake);
        floods = (CheckBox) findViewById(R.id.floods);
        covidRelated = (CheckBox) findViewById(R.id.covidRelated);
        thunderstorms = (CheckBox) findViewById(R.id.thunderStorms);
        robbery = (CheckBox) findViewById(R.id.robbery);
        lossChild = (CheckBox) findViewById(R.id.lossChild);
        rabies = (CheckBox) findViewById(R.id.rabies);
        extremeHeat = (CheckBox) findViewById(R.id.extremeHeat);
        needAmbulance = (CheckBox) findViewById(R.id.needAmbulance);


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
       fire.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (fire.isChecked())
                   Toast.makeText(MainActivity3.this, "Fire checked", Toast.LENGTH_SHORT).show();
           }
       });
       chemicalSpills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chemicalSpills.isChecked())
                    Toast.makeText(MainActivity3.this, "Chemicalspills checked", Toast.LENGTH_SHORT).show();
            }
        });
       damFailure.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (damFailure.isChecked())
                   Toast.makeText(MainActivity3.this, "Damfailure checked", Toast.LENGTH_SHORT).show();
           }
       });
       earthquake.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (earthquake.isChecked())
                   Toast.makeText(MainActivity3.this, "Earthquake checked", Toast.LENGTH_SHORT).show();
           }
       });
       floods.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(floods.isChecked())
                   Toast.makeText(MainActivity3.this, "Floods checked", Toast.LENGTH_SHORT).show();
           }
       });
        covidRelated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (covidRelated.isChecked())
                    Toast.makeText(MainActivity3.this, "Covidrelated checked", Toast.LENGTH_SHORT).show();
            }
        });
        thunderstorms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thunderstorms.isChecked())
                    Toast.makeText(MainActivity3.this, "Thunderstorm checked", Toast.LENGTH_SHORT).show();
            }
        });
        robbery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (robbery.isChecked())
                    Toast.makeText(MainActivity3.this, "Robbery checked", Toast.LENGTH_SHORT).show();
            }
        });
        lossChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lossChild.isChecked())
                    Toast.makeText(MainActivity3.this, "Lostchild checked", Toast.LENGTH_SHORT).show();
            }
        });
        rabies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rabies.isChecked())
                    Toast.makeText(MainActivity3.this, "Rabies checked", Toast.LENGTH_SHORT).show();
            }
        });
        extremeHeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extremeHeat.isChecked())
                    Toast.makeText(MainActivity3.this, "Extremeheat checked", Toast.LENGTH_SHORT).show();
            }
        });
        needAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (needAmbulance.isChecked())
                    Toast.makeText(MainActivity3.this, "Need Ambulance checked", Toast.LENGTH_SHORT).show();
            }
        });
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
                validation();
                if (fire.isChecked()){
                    member.setEmergency1(e1);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (chemicalSpills.isChecked()){
                    member.setEmergency2(e2);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (damFailure.isChecked()){
                    member.setEmergency3(e3);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (earthquake.isChecked()){
                    member.setEmergency4(e4);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (floods.isChecked()){
                    member.setEmergency5(e5);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (covidRelated.isChecked()){
                    member.setEmergency6(e6);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (thunderstorms.isChecked()){
                    member.setEmergency7(e7);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (robbery.isChecked()){
                    member.setEmergency8(e8);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (lossChild.isChecked()){
                    member.setEmergency9(e9);
                    reference.child(String.valueOf(i+1)).setValue(member);



                }else {

                }
                if (rabies.isChecked()){
                    member.setEmergency10(e10);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (extremeHeat.isChecked()){
                    member.setEmergency11(e11);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }
                if (needAmbulance.isChecked()){
                    member.setEmergency12(e12);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {

                }

            }
        });

    }
    public void validation(){
    if(!chemicalSpills.isChecked() && !damFailure.isChecked() && !covidRelated.isChecked() && !earthquake.isChecked() && !fire.isChecked()
        && !floods.isChecked() && !thunderstorms.isChecked() && !needAmbulance.isChecked() && !rabies.isChecked() && !extremeHeat.isChecked()
        && !robbery.isChecked() && !lossChild.isChecked()){
        Toast.makeText(MainActivity3.this,"Please choose any Emergency", Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(MainActivity3.this, "Emergency Confirm, Standby!!", Toast.LENGTH_SHORT).show();
    }
        sp = getSharedPreferences("My Application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        mRef = FirebaseDatabase.getInstance().getReference("Users")
          .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        sp = getSharedPreferences("My Application", Context.MODE_PRIVATE);



        mRef.child("timestart").setValue(ServerValue.TIMESTAMP);


        mRef.child("timestart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    SharedPreferences.Editor editor = sp.edit();
                    String timestampstring = dataSnapshot.getValue().toString();
                    editor.putString("currenttimestamp", timestampstring);
                    editor.apply();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                String currenttimestamp = sp.getString("currenttimestamp", "0");

                long currenttimestampinlongformat = Long.parseLong(currenttimestamp);


                String todisplaycurrenttimewithdate = getTimeDate(currenttimestampinlongformat);


                Toast.makeText(MainActivity3.this, todisplaycurrenttimewithdate, Toast.LENGTH_SHORT).show();

                TextView timedatetext = (TextView) findViewById(R.id.timedatetext);

                timedatetext.setText(todisplaycurrenttimewithdate);

            }
        }, 2000);

//end component of 'protected void onCreate(Bundle savedInstanceState) {'
    }

    //this one you already know from my previous video
    public static String getTimeDate(long timestamp){
        try{
            Date netDate = (new Date(timestamp));
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss", Locale.getDefault());
            return sfd.format(netDate);
        } catch(Exception e) {
            return "date";
        }
    }
}