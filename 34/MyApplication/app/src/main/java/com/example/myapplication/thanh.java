package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class thanh extends AppCompatActivity{

    ImageButton buttonback;
    ImageButton buttonsai;
    ImageButton buttonsai1;
    ImageButton buttonsai2;
    ImageButton buttondung;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanh);
        buttonback = findViewById(R.id.imageButton21);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thanh.this,Activity2.class);
                startActivity(intent);

            }
        });
     buttonsai = findViewById(R.id.imageButton29);
     buttonsai1 = findViewById(R.id.imageButton30);
     buttonsai2 = findViewById(R.id.imageButton31);
     buttondung = findViewById(R.id.imageButton28);

        buttondung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanh.this);
                builder.setMessage("Bạn đã trả lời dung !");
                builder.show();
            }
        });
     buttonsai.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             AlertDialog.Builder builder = new AlertDialog.Builder(thanh.this);
             builder.setMessage("Bạn đã trả lời sai !");
             builder.show();
         }
     });
        buttonsai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanh.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });
        buttonsai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanh.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });
    }



}
