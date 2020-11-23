package com.example.duolingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText userName, userPassword , userEmail;
    private Button regButton;
    private TextView userLogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Assign();

        mAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){

                     String user_email = userEmail.getText().toString();
                     String user_password = userPassword.getText().toString();

                    mAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistrationActivity.this, "Registration UnSuccessfull" , Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                            }else{
                                Toast.makeText(RegistrationActivity.this,"Registration Successfull", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });

    }

    private void Assign(){
        userName = (EditText) findViewById(R.id.etuserName);
        userPassword = (EditText) findViewById(R.id.etuserPassword);
        userEmail = (EditText) findViewById(R.id.etuserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.textInfo);
    }

    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){

            Toast.makeText(this, "please enter all the details" , Toast.LENGTH_LONG).show();
        }else{
            result = true;
        }
        return result;
    }
}