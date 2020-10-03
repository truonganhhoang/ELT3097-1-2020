package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnFirst;
    ImageButton btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFirst = (ImageButton) findViewById(R.id.imageButton_edu);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, layout2.class);
                startActivity(intent);
            }
        });


        btnSecond = (ImageButton) findViewById(R.id.imageButton_des);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, layout3.class);
                startActivity(intent);
            }
        });
    }
    public void batdau(View view) {
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }


}

