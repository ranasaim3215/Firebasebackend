package com.example.firebasebacked;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupActivity extends AppCompatActivity {
    EditText email, password;
    Button signupBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        signupBtn = findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)) {
                    Toast.makeText(signupActivity.this, "Enter values", Toast.LENGTH_SHORT).show();
                } else {
                    signup(emailText, passwordText);
                }
            }
        });


    }

    private void signup(String emailText, String passwordText) {
        auth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(signupActivity.this, "Succes", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signupActivity.this,LoginActivity.class));

                }else {
                    Toast.makeText(signupActivity.this, "Unsuccess", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}