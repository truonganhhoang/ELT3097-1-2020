package com.example.TED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.podcasts);
    }
    public void batdau(View view) {
        Intent i = new Intent(this,Worklife.class);
        startActivity(i);
    }
}

