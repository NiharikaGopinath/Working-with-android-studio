package com.example.studentloginreg;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Email;
    EditText Pwd;
    Button Login;
    //Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link to registration page

        TextView register = (TextView)findViewById(R.id.lnkRegister2);
        register.setMovementMethod(LinkMovementMethod.getInstance());
       register.setOnClickListener(new OnClickListener() {
          @Override
           public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
          }
       });

        //reg= findViewById(R.id.btnReg);
        //reg.setMovementMethod(LinkMovementMethod.getInstance());
       // reg.setOnClickListener(new OnClickListener() {
         //   @Override
           // public void onClick(View view) {
                //Intent i= new Intent(MainActivity.this, Registration.class);
                //startActivity(i);
           // }
       // });

        // link to reset page

        TextView reset = (TextView)findViewById(R.id.lnkreset);
        reset.setMovementMethod((LinkMovementMethod.getInstance()));
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, ResetActivity.class);
                startActivity(intent1);
            }
        });
        Email = (EditText) findViewById(R.id.txtEmail);
        Pwd   =(EditText) findViewById(R.id.txtPwd);
        Login = findViewById((R.id.btnLogin));
        Login.setMovementMethod(LinkMovementMethod.getInstance());
        Login.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {
                String mail = Email.getText().toString().trim();
                String pass = Pwd.getText().toString().trim();

                if (TextUtils.isEmpty(mail) && TextUtils.isEmpty(pass)) {
                    //Email.setError("Email is Required");
                    Toast.makeText(getApplicationContext(), "Enter email address and password!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(mail)) {
                    //Email.setError("Email is Required");
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(pass)) {
                    //Pwd.setError("Password is required");
                    Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;


                }


            /* mFirebaseAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        } else {
                            Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/


            //Ok to go to home page after successful login

                Intent intent2 = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent2);
        }
        });



    }
}