package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TruyenNgan_Audio extends AppCompatActivity {
    //khai bao

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_ngan__audio);

        //anh xa
        btn = (Button) findViewById(R.id.button_truyen_ngan_audio_1);


        //code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TruyenNgan_Audio.this, truyen_ngan_audio_str1.class);
                startActivity(intent);
            }
        });

    }
}