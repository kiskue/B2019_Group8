package com.example.subdivisionemergencyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Ref;

public class MainActivity4 extends AppCompatActivity  {

    Button submit;
    EditText editconcern, edititems;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        editconcern = findViewById(R.id.edt_notEmergency);
        edititems = findViewById(R.id.edt_Items);
        submit = findViewById(R.id.submit_n);
        reference = FirebaseDatabase.getInstance().getReference("Users")
        .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
         submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 insertConcern();
             }
         });

    }

    private void insertConcern(){
        String concern = editconcern.getText().toString();
        String items = edititems.getText().toString();

        if(concern.isEmpty()){
            editconcern.setError("Please input your concern!");
            editconcern.requestFocus();
            return;
        }
        if(items.isEmpty()) {
            edititems.setError("Please Fill this area!");
            edititems.requestFocus();
            return;
        }
            Concern concern1 = new Concern(concern,items);

        reference.push().setValue(concern1);
        Toast.makeText(MainActivity4.this,"Concern Submitted!!", Toast.LENGTH_SHORT).show();
    }
}