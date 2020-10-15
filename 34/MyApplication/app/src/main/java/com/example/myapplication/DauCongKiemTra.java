package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DauCongKiemTra extends AppCompatActivity {
    ImageButton buttonBack;
    ImageButton buttonDapAnDung;
    ImageButton buttonDapAnSai;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dau_cong_test);
        buttonBack = findViewById(R.id.buttonBackLayoutKiemTra);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DauCongKiemTra.this, DauCong.class);
                startActivity(intent);
            }
        });
        buttonDapAnDung = findViewById(R.id.buttonDapAnDungLayoutDauCongKiemTra);
        buttonDapAnSai = findViewById(R.id.buttonDapAnSaiLayoutDauCongKiemTra);
        buttonDapAnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DauCongKiemTra.this);
                builder.setMessage("Bạn đã trả lời đúng !");
                builder.show();
            }
        });
        buttonDapAnSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DauCongKiemTra.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });


    }
}
