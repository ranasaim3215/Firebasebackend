package com.example.firebasebacked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WelcomeActivity extends AppCompatActivity {
EditText name,age,phoneNo,gender;

Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        name=findViewById(R.id.editTextTextPersonName);

        phoneNo=findViewById(R.id.editTextTextPersonName2);
        age=findViewById(R.id.editTextTextPersonName3);
        gender=findViewById(R.id.editTextTextPersonName4);
        button=findViewById(R.id.textButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText=name.getText().toString();
                String phoneNoText=phoneNo.getText().toString();
                String genderText=gender.getText().toString();
                String ageText=age.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();

                DatabaseReference myRef = database.getReference("Data");
                HelperClass data=new HelperClass(nameText,phoneNoText,genderText,ageText);
                myRef.setValue(data);


            }

        });



//        FirebaseDatabase.getInstance().getReference().child("Parent").child("Child").setValue("abc");


    }
}