package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class truyen_ngan_audio_str1 extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_ngan_audio_str1);
        btn = (Button) findViewById(R.id.truyenngan1_str1_vn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio_str1.this, The_Eight_vn.class);
                startActivity(intent);
            }
        });
    }
}