package com.example.doulingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button4;
    Button button;
    Button button1;
    Button button2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button4 = findViewById(R.id.button4);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView3 = findViewById(R.id.textView3);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Button4Text = button4.getText().toString();
                textView3.setText("Chính xác!");
                textView3.setBackgroundColor(Color.parseColor("#0DDC12"));
                button4.setText("Tiếp tục");
                if(Button4Text.equals("Tiếp tục")){
                    openActivity2();
                }

            }

        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundColor(Color.parseColor("#0DDC12"));
                button4.setBackgroundColor(Color.parseColor("#0DDC12"));

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundColor(Color.parseColor("#0DDC12"));
                button4.setBackgroundColor(Color.parseColor("#0DDC12"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setBackgroundColor(Color.parseColor("#0DDC12"));
                button4.setBackgroundColor(Color.parseColor("#0DDC12"));
            }
        });
    }
    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
