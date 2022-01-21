package com.example.subdivisionemergencyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private TextView register, forgotPassword;
    private EditText editEmail, editPassword;
    private Button login;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register= (TextView) findViewById(R.id.txtRegister);
        register.setOnClickListener(this::onClick);

        forgotPassword=(TextView) findViewById(R.id.txtForgot);
        forgotPassword.setOnClickListener(this::onClick);

        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(this::onClick);

        editEmail=(EditText) findViewById(R.id.edtEmail);
        editPassword=(EditText) findViewById(R.id.edtPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
    }


    public void onClick(View v) {
        switch(v.getId()){
            case R.id.txtRegister:
                startActivity(new Intent(this, Register.class));
                break;
            case R.id.btnLogin:
                userLogin();
                break;
            case R.id.txtForgot:
                startActivity(new Intent(this, ForgotPassword.class));
                break;
        }
    }

    private void userLogin(){
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (email.isEmpty()){
            editEmail.setError("Email required!");
            editEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please enter valid email!");
            editEmail.requestFocus();
            return;
        }

        if(password.length()< 6){
            editPassword.setError("Password too short!");
            editPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()) {
                        updateUI(user);

                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this, "Verification email sent! Please check email!", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Failed to login! Check credentials!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void updateUI(FirebaseUser currentUser){
        Intent MainIntent = new Intent (this, MainActivity1.class);
        //MainIntent.putExtra("Email",currentUser.getEmail());
        startActivity(MainIntent);

    }
}