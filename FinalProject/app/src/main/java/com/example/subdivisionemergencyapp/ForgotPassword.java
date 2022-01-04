package com.example.subdivisionemergencyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText editEmail;
    private Button btnResetPwd;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editEmail= (EditText) findViewById(R.id.edtRecEmail);
        btnResetPwd= (Button) findViewById(R.id.btnReset);
        progressBar= (ProgressBar) findViewById(R.id.progressBar3);

        auth = FirebaseAuth.getInstance();

        btnResetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword(){
        String email = editEmail.getText().toString().trim();

        if(email.isEmpty()){
            editEmail.setError("Email required!");
            editEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Invalid email!");
            editEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check email to reset pasword!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ForgotPassword.this, "Something wen wrong! Please try again!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}