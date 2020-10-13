package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivityDauCongKiemTra extends AppCompatActivity {
    ImageButton buttonBack;
    ImageButton buttonDapAnDung;
    ImageButton buttonDapAnSai;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phepcong_kiemtra);
        buttonBack = findViewById(R.id.buttonBackLayoutKiemTra);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDauCongKiemTra.this, Activity2.class);
                startActivity(intent);
            }
        });
        buttonDapAnDung = findViewById(R.id.buttonDapAnDungLayoutDauCongKiemTra);
        buttonDapAnSai = findViewById(R.id.buttonDapAnSaiLayoutDauCongKiemTra);
        buttonDapAnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDauCongKiemTra.this);
                builder.setMessage("Bạn đã trả lời đúng !");
                builder.show();
            }
        });
        buttonDapAnSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDauCongKiemTra.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });

    }

}
