package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class An_ignorant_husband extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_ignorant_husband);
        btn = (Button) findViewById(R.id.truyenngan1_str1_vn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(An_ignorant_husband.this, ongchongdotnat.class);
                startActivity(intent);
            }
        });
    }
}