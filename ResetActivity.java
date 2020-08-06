package com.example.studentloginreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {
    EditText mail;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        mail = (EditText) findViewById(R.id.txtMail);
        reset=findViewById(R.id.btnReset);
        reset.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {
                String Mail = mail.getText().toString().trim();
                if (TextUtils.isEmpty(Mail)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();

                    return;
                }
                Intent intent = new Intent(ResetActivity.this, MainActivity.class);
                startActivity(intent);

            }

        });
    }
}