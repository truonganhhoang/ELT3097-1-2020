package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    ImageButton buttonBack;
    ImageButton buttonSuaDoi;
    ImageButton buttonKiemTra;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        buttonSuaDoi = findViewById(R.id.imageButton12);
        buttonSuaDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, thanh.class);
                startActivity(intent);
            }
        });
        buttonBack = findViewById(R.id.imageButton);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonKiemTra = findViewById(R.id.buttonKiemTraLayout);
        buttonKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, ActivityDauCongKiemTra.class);
                startActivity(intent);
            }
        });


    }

}
