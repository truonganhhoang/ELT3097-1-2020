package com.example.npbi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreActivity extends AppCompatActivity {
    ActionBar actionBar;
    Button khoahoccoban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre);
        khoahoccoban = findViewById(R.id.khoahoc);
        actionBar = getSupportActionBar();
        actionBar.hide();
        khoahoccoban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PreActivity.this, MainActivity.class));
            }
        });
    }
}