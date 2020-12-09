package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class truyen_ngan_audio extends AppCompatActivity {
    //khai bao

    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_ngan_audio);

        //anh xa
        btn = (Button) findViewById(R.id.button_truyen_ngan_audio_1);
        btn1 = (Button) findViewById(R.id.im_her_father);
        btn2 = (Button) findViewById(R.id.i_thought_you_called);
        btn3 = (Button) findViewById(R.id.turn_out);
        btn4 = (Button) findViewById(R.id.polite);
        btn5 = (Button) findViewById(R.id.clever);

        //code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio.this, truyen_ngan_audio_str1.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio.this, im_her_father.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio.this, I_thought_you_called_the_next.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio.this, turn_out.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio.this, polite.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(truyen_ngan_audio.this, CLEVER.class);
                startActivity(intent);
            }
        });
    }
}