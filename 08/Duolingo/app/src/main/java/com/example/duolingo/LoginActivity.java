package com.example.duolingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duolingo.R;
import com.example.duolingo.RegistrationActivity;
import com.example.duolingo.question.QuestionOne;
import com.example.duolingo.question.QuestionThree;
import com.example.duolingo.question.QuestionTwo;
import com.example.duolingo.ui.HomeActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {



    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 0;
    private EditText account;
    private EditText password;
    private Button login;
    private int counter = 5;
    private TextView userRegistration;
    private SignInButton signInBtn;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        actionBar = getSupportActionBar();
        actionBar.hide();
        account = (EditText) findViewById(R.id.Account);
        password = (EditText) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.Confirm);
        userRegistration = (TextView) findViewById(R.id.Register);
        signInBtn = findViewById(R.id.signInButton);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(account.getText().toString(), password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this , gso);
        // firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("admin")) && (userPassword.equals("admin"))) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else {
            counter--;
            if (counter == 0) {
                login.setEnabled(false);
            }
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            if(task.isSuccessful()){
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                    firebaseAuthWithGoogle(account.getIdToken());
                    startActivity(new Intent(LoginActivity.this , QuestionOne.class));
                } catch (ApiException e) {
                    // Google Sign In failed, update UI appropriatelyadmin
                    Log.d(TAG, "Google sign in failed", e);
                    // ...
                }
            }else{
                Log.d(TAG, "Google sign in failed", task.getException());
            }

        }
    }


    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            FirebaseUser user = mAuth.getCurrentUser();
                        }

                        // ...
                    }
                });
    }

}