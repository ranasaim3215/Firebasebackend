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

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button button;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        button = findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String passwordText = password.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(passwordText)) {
                    Toast.makeText(LoginActivity.this, "Enter values", Toast.LENGTH_SHORT).show();
                } else {
                    login(email, passwordText);
                }

            }
        });
    }

    private void login(String email, String passwordText) {
        auth.signInWithEmailAndPassword(email,passwordText).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Succefully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,WelcomeActivity.class));

                }
            }
        });
    }

}