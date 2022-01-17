package com.example.subdivisionemergencyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Ref;

public class MainActivity4 extends AppCompatActivity {
    Button submit_n;
    FirebaseDatabase database;

    DatabaseReference reference;
    EditText edt_notEmergency,edt_Items;
    int i = 0;

    public MainActivity4() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        reference = database.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        submit_n=findViewById(R.id.submit_n);
        edt_notEmergency=(EditText) findViewById(R.id.edt_notEmergency);
        edt_Items=(EditText) findViewById(R.id.edt_Items);


    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
///
        }
    });
    View.OnClickListener



    }


    public void submit(View view) {
        View.OnClickListener
    }
}