package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class They_wont_play_the_trick extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_they_wont_play_the_trick);
        btn = (Button) findViewById(R.id.truyenngan1_str1_vn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(They_wont_play_the_trick.this, hosekhongcontreugheochaunua.class);
                startActivity(intent);
            }
        });
    }
}