package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class The_Eight_vn extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the__eight_vn);
        btn = (Button) findViewById(R.id.truyenngan1_str1_e);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(The_Eight_vn.this, truyen_ngan_audio_str1.class);
                startActivity(intent);
            }
        });
    }
}