package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class I_thought_you_called_the_next extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_thought_you_called_the_next);
        btn = (Button) findViewById(R.id.truyenngan1_str1_vn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(I_thought_you_called_the_next.this, emnghilacogoitenhocsinhkhac.class);
                startActivity(intent);
            }
        });
    }
}