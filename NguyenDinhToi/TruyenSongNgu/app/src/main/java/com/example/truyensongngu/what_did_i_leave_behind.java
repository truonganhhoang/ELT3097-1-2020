package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class what_did_i_leave_behind extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_did_i_leave_behind);
        btn = (Button) findViewById(R.id.truyenngan1_str1_vn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(what_did_i_leave_behind.this, toiboquencaigiday.class);
                startActivity(intent);
            }
        });
    }
}