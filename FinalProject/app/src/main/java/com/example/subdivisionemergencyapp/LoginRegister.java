package com.example.subdivisionemergencyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class LoginRegister extends AppCompatActivity {


    ProgressDialog progressDialog;
    EditText editfullName, editemail, editpassword, editphone, editaddress, editage;
    Button btnSignIn, btnRegister;
    TextView txtheader;
    ImageView imageView;
    private  String URL= "https://b2019cc107group8.000webhostapp.com/index.php";



    JSONParser jsonParser=new JSONParser();

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        editfullName = (EditText) findViewById(R.id.edtFullName);
        editemail = (EditText) findViewById(R.id.edtRegEmail);
        editpassword = (EditText) findViewById(R.id.edtRegPassword);
        editphone = (EditText) findViewById(R.id.editTextPhone);
        editaddress = (EditText) findViewById(R.id.editTextTextPostalAddress);
        editage = (EditText) findViewById(R.id.editTextNumber);
        txtheader = (TextView) findViewById(R.id.text12);
        imageView = findViewById(R.id.logo);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    AttemptLogin attemptLogin = new AttemptLogin();
                    attemptLogin.execute(editemail.getText().toString(), editpassword.getText().toString(), "", "", "", "");
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i==0)
                {
                    i=1;
                    editfullName.setVisibility(View.VISIBLE);
                    editage.setVisibility(View.VISIBLE);
                    editaddress.setVisibility(View.VISIBLE);
                    editphone.setVisibility(View.VISIBLE);
                    btnSignIn.setVisibility(View.GONE);
                    txtheader.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    btnRegister.setText("CREATE ACCOUNT");
                }
                else {

                    btnRegister.setText("REGISTER");
                    editfullName.setVisibility(View.GONE);
                    editage.setVisibility(View.GONE);
                    editaddress.setVisibility(View.GONE);
                    editphone.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    txtheader.setVisibility(View.GONE);
                    btnSignIn.setVisibility(View.VISIBLE);

                    i = 0;

                        AttemptLogin attemptLogin = new AttemptLogin();
                        attemptLogin.execute(editemail.getText().toString(), editpassword.getText().toString(), editfullName.getText().toString(), editage.getText().toString(), editaddress.getText().toString(),
                                editphone.getText().toString());

                }
            }
        });


    }
    private class AttemptLogin extends AsyncTask<String,String , JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();
            progressDialog = new ProgressDialog(LoginRegister.this);
            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override

        protected JSONObject doInBackground(String... args) {
            String password = args[1];
            String email = args[0];
            String phone = args[5];
            String address = args[4];
            String age = args[3];
            String fullname = args[2];

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("password", password));
            params.add(new BasicNameValuePair("fullname", fullname));
            params.add(new BasicNameValuePair("age", age));
            params.add(new BasicNameValuePair("address", address));
            params.add(new BasicNameValuePair("phone", phone));

                JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


                return json;


        }
        protected void onPostExecute(JSONObject result) {

            progressDialog.dismiss();
            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                    if (result.getString("message").equals("Successfully logged in")) {
                        Toast.makeText(LoginRegister.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                        Intent intent_name = new Intent();
                        intent_name.setClass(getApplicationContext(), MainActivity1.class);
                        startActivity(intent_name);
                    } else {
                        Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Somrthing went wrong!!", Toast.LENGTH_LONG).show();

                }

            }catch (JSONException e) {
                e.printStackTrace();

            }

        }
    }
}