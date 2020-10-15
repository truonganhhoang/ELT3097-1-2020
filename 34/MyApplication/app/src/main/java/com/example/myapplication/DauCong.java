package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DauCong extends AppCompatActivity {
    ImageButton buttonBack;
    ImageButton buttonPractice;
    ImageButton buttonTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dau_cong);
        buttonPractice = findViewById(R.id.imageButtonPractice);
        buttonPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DauCong.this, thanh.class);
                startActivity(intent);
            }
        });

        buttonBack = findViewById(R.id.imageButtonBackDauCong);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DauCong.this, ManHinhChinh.class);
                startActivity(intent);
            }
        });
        buttonTest = findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DauCong.this, DauCongKiemTra.class);
                startActivity(intent);
            }
        });


    }

}
