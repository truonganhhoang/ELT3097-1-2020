package com.example.npbi;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.relative_layouts.RegistrationActivity;

public class PreActivity extends AppCompatActivity {


    private EditText account;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;
    private TextView userRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre);

        account = (EditText) findViewById(R.id.Account) ;
        password = (EditText) findViewById(R.id.Password);
        info = (TextView) findViewById(R.id.textInfo);
        login = (Button) findViewById(R.id.Confirm);
        userRegistration = (TextView) findViewById(R.id.Register);

        info.setText("Number of attemps remaining : 5");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validate(account.getText().toString() , password.getText().toString());
            }

        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PreActivity.this , RegistrationActivity.class));
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("admin"))){
            Intent intent = new Intent(PreActivity.this, com.example.npbi.MainAcitivity.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("Number of attemps remaining" + String.valueOf(counter));

            if(counter == 0){
                login.setEnabled(false);
            }
        }
    }

}