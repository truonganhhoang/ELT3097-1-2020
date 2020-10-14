package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class thanh1 extends AppCompatActivity {
    ImageButton buttonluilai;
    ImageButton buttondung;
    ImageButton buttonsai;
    ImageButton buttonsai1;
    ImageButton buttonsai2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanh1);


    buttonsai = findViewById(R.id.buttondung1);
    buttonsai1 = findViewById(R.id.buttondung3);
    buttonsai2 = findViewById(R.id.buttondung4);

        buttonsai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanh1.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });

        buttonsai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanh1.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });

        buttonsai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(thanh1.this);
                builder.setMessage("Bạn đã trả lời sai !");
                builder.show();
            }
        });
    }
}
