package com.example.doulingoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Nghe giọng nói", Toast.LENGTH_SHORT).show();
            }
        });
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textView3 = findViewById(R.id.textView3);



        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Button9Text = button9.getText().toString();
                textView3.setText("Chính xác!");
                textView3.setBackgroundColor(Color.parseColor("#0DDC12"));
                button9.setText("Tiếp tục");
                if(Button9Text.equals("Tiếp tục")){
                    openMainActivity2();
                }
            }
        });

        button2.setOnClickListener(mLintener);
        button3.setOnClickListener(mLintener);
        button4.setOnClickListener(mLintener);
        button5.setOnClickListener(mLintener);
        button6.setOnClickListener(mLintener);
        button7.setOnClickListener(mLintener);
        button8.setOnClickListener(mLintener);

    }
    public void openMainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    View.OnClickListener mLintener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.button2:
                    boolean e = button2.isEnabled();
                    button2.setEnabled(!e);

                    break;
                case R.id.button3:
                    boolean a = button3.isEnabled();
                    button3.setEnabled(!a);

                    break;
                case R.id.button4:
                    boolean b = button4.isEnabled();
                    button4.setEnabled(!b);

                    break;
                case R.id.button5:
                    boolean c = button5.isEnabled();
                    button5.setEnabled(!c);

                    break;
                case R.id.button6:
                    boolean d = button6.isEnabled();
                    button6.setEnabled(!d);

                    break;
                case R.id.button7:
                    boolean f = button7.isEnabled();
                    button7.setEnabled(!f);

                    break;
                case R.id.button8:
                    boolean g = button8.isEnabled();
                    button8.setEnabled(!g);

                    break;

                default:
                    break;
            }

        }
    };
}