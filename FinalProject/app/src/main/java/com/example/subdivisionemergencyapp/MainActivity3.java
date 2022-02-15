package com.example.subdivisionemergencyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {
    EditText txtemail,boxfire,boxearthquake,boxfloods,boxrobbery,boxlosschild,boxrabies,boxneedambulance, boxbomb_threat,boxpersonal_threat;
    Button confirm_button;
    ProgressDialog mProgressDialog;
    private static final String INSERTDATA_URL = "https://b2019cc107group8.000webhostapp.com/emergency.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        confirm_button = findViewById(R.id.confirm_button);
        boxfire = findViewById(R.id.fire);
        boxearthquake = findViewById(R.id.earthquake);
        boxfloods = findViewById(R.id.floods);
        boxrobbery = findViewById(R.id.robbery);
        boxlosschild = findViewById(R.id.lossChild);
        boxbomb_threat = findViewById(R.id.bombtreat);
        boxpersonal_threat = findViewById(R.id.personalthreat);
        boxneedambulance = findViewById(R.id.needAmbulance);
        txtemail = (EditText) findViewById(R.id.txtEmail);


        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtemail.getText().toString().trim().toLowerCase();
                String fire = boxfire.getText().toString().trim().toLowerCase();
                String floods = boxfloods.getText().toString().trim().toLowerCase();
                String robbery = boxrobbery.getText().toString().trim().toLowerCase();
                String earthquake = boxearthquake.getText().toString().trim().toLowerCase();
                String bomb_threat = boxbomb_threat.getText().toString().trim().toLowerCase();
                String need_ambulance = boxneedambulance.getText().toString().trim().toLowerCase();
                String lost_family = boxlosschild.getText().toString().trim().toLowerCase();
                String personal_threat = boxpersonal_threat.getText().toString().trim().toLowerCase();

                if (email.equals("")) {
                    Toast.makeText(MainActivity3.this, "Enter Email!!", Toast.LENGTH_SHORT).show();}
                 else if( fire.equals("") && floods.equals("") && robbery.equals("") && earthquake.equals("") && bomb_threat.equals("") && need_ambulance.equals("") && lost_family.equals("") && personal_threat.equals("")) {
                    Toast.makeText(MainActivity3.this,"Please fill emergency!!", Toast.LENGTH_SHORT).show();
                }
                InsertData();

            }
        });

    }
    private void InsertData() {
        String email = txtemail.getText().toString().trim().toLowerCase();
        String fire = boxfire.getText().toString().trim().toLowerCase();
        String floods = boxfloods.getText().toString().trim().toLowerCase();
        String robbery = boxrobbery.getText().toString().trim().toLowerCase();
        String earthquake = boxearthquake.getText().toString().trim().toLowerCase();
        String bomb_threat = boxbomb_threat.getText().toString().trim().toLowerCase();
        String need_ambulance = boxneedambulance.getText().toString().trim().toLowerCase();
        String lost_family = boxlosschild.getText().toString().trim().toLowerCase();
        String personal_threat = boxpersonal_threat.getText().toString().trim().toLowerCase();
        if (email.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter Email!!", Toast.LENGTH_SHORT).show();}
        else if(fire.equals("") && floods.equals("") && robbery.equals("") && earthquake.equals("") && bomb_threat.equals("") && need_ambulance.equals("") && lost_family.equals("") && personal_threat.equals(""))  {
            Toast.makeText(MainActivity3.this,"Please fill emergency!!", Toast.LENGTH_SHORT).show();
       }
       else {


            register(email,fire,floods,robbery,earthquake,bomb_threat,need_ambulance,lost_family,personal_threat);
     }
    }

    private void register(String email, String fire, String floods, String robbery, String earthquake,String bomb_threat, String need_ambulance, String lost_family, String personal_threat ) {
        class RegisterUsers  extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            Register ruc = new Register();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(MainActivity3.this);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setMessage(getString(R.string.progress_detail));
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setCancelable(false);
                mProgressDialog.setProgress(0);
                mProgressDialog.setProgressNumberFormat(null);
                mProgressDialog.setProgressPercentFormat(null);
                mProgressDialog.show();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                mProgressDialog.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this,MainActivity1.class);
                startActivity(intent);
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();


                data.put("email",params[0]);
                data.put("fire", params[1]);
                data.put("floods", params[2]);
                data.put("robbery", params[3]);
                data.put("earthquake", params[4]);
                data.put("bomb_threat", params[5]);
                data.put("need_ambulance", params[6]);
                data.put("lost_family", params[7]);
                data.put("personal_threat", params[8]);


                String result = ruc.sendPostRequest(INSERTDATA_URL, data);

                return result;
            }
        }

        RegisterUsers ru = new RegisterUsers();
        ru.execute(email,fire,floods,robbery,earthquake,bomb_threat,need_ambulance,lost_family,personal_threat);
    }
}
