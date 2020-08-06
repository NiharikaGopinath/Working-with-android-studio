package com.example.studentloginreg;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import android.text.TextUtils;
import android.widget.Button;

import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText phone;
    EditText password;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //This is necessary for "Already Registered ? Login Here" link

        TextView login = (TextView)findViewById(R.id.lnkLogin); //This is necessary for "Already Registered ? Login Here" link
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Registration.this, MainActivity.class);
                startActivity(intent2);
            }
        });

       name= (EditText) findViewById(R.id.txtName);
        email= (EditText)findViewById(R.id.txtEmail);
        phone=(EditText)findViewById(R.id.txtPhone);
        password=(EditText)findViewById(R.id.txtPwd);
        reg=findViewById(R.id.btnSubmit);
        reg.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {
                String User = name.getText().toString().trim();
                String Mail = email.getText().toString().trim();
                String Phone = phone.getText().toString().trim();
                String pass = password.getText().toString().trim();


               if (TextUtils.isEmpty(User) || TextUtils.isEmpty(Mail) || TextUtils.isEmpty(Phone) || TextUtils.isEmpty(pass)) {
               email.setError("Incomplete Details");
               name.setError("Incomplete Details");
                   phone.setError("Incomplete Details");
                   password.setError("Incomplete Details");
                   Toast.makeText(getApplicationContext(), "Enter all details", Toast.LENGTH_SHORT).show();
                  //Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                   return;

                }
               if (pass.length() < 6) {
              Toast.makeText(getApplicationContext(), "Password should be more than 6 characters", Toast.LENGTH_SHORT).show();
              return;
               }

                Toast.makeText(getApplicationContext(), "Login with your email id and password", Toast.LENGTH_SHORT).show();



                Intent intent3 = new Intent(Registration.this, MainActivity.class);
                startActivity(intent3);
            }
            });

        }

}

