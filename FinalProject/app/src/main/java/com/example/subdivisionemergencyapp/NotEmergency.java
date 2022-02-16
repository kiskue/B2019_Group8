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

public class NotEmergency extends AppCompatActivity {

    EditText txtname,txtConcern ,txtaddress, txtNeedforcencern ;
    Button insertdata;
    ProgressDialog mProgressDialog;
    private static final String INSERTDATA_URL = "https://b2019cc107group8.000webhostapp.com/concern.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notemergency);

        txtname = (EditText)findViewById(R.id.editTextname);
        txtaddress = (EditText)findViewById(R.id.editTextcity);
        txtConcern = (EditText)findViewById(R.id.editTextstate);
        txtNeedforcencern = (EditText)findViewById(R.id.editTextcountry);

        insertdata = (Button)findViewById(R.id.buttoninsertdata);
        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = txtname.getText().toString().trim().toLowerCase();
                String address = txtaddress.getText().toString().trim().toLowerCase();
                String Concern = txtConcern.getText().toString().trim().toLowerCase();
                String Needforconcern = txtNeedforcencern.getText().toString().trim().toLowerCase();
                if(Name.equals("")){
                    Toast.makeText(NotEmergency.this, "Please Enter Fullname!!", Toast.LENGTH_SHORT).show();
                }
                else if(address.equals("")){
                    Toast.makeText(NotEmergency.this, "Please Enter Address!!", Toast.LENGTH_SHORT).show();
                }
                else if (Concern.equals("")||Needforconcern.equals("")){
                    Toast.makeText(NotEmergency.this, "Please Enter Your Concern!!", Toast.LENGTH_SHORT).show();
                }
                InsertData();
            }
        });

    }
    private void InsertData() {
        String Name = txtname.getText().toString().trim().toLowerCase();
        String address = txtaddress.getText().toString().trim().toLowerCase();
        String Concern = txtConcern.getText().toString().trim().toLowerCase();
        String Needforconcern = txtNeedforcencern.getText().toString().trim().toLowerCase();

        if(Name.equals("")){
            Toast.makeText(NotEmergency.this, "Please Enter Fullname!!", Toast.LENGTH_SHORT).show();
        }
        else if(address.equals("")){
            Toast.makeText(NotEmergency.this, "Please Enter Address!!", Toast.LENGTH_SHORT).show();
        }
        else if (Concern.equals("")||Needforconcern.equals("")){
            Toast.makeText(NotEmergency.this, "Please Enter Your Concern!!", Toast.LENGTH_SHORT).show();
        } else {
            register(Name, address, Concern, Needforconcern);
        }
    }
    private void register(String Name, String address , String Concern, String Needforconcern ) {
        class RegisterUsers  extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            Register ruc = new Register();
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(NotEmergency.this);
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
                Intent intent = new Intent(NotEmergency.this,MainActivity1.class);
                startActivity(intent);
            }
            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String, String>();

                data.put("Name",params[0]);
                data.put("address", params[1]);
                data.put("Concern", params[2]);
                data.put("Needforconcern", params[3]);

                String result = ruc.sendPostRequest(INSERTDATA_URL, data);
                return result;
            }
        }
        RegisterUsers ru = new RegisterUsers();
        ru.execute(Name, address,Concern,Needforconcern);
    }
}