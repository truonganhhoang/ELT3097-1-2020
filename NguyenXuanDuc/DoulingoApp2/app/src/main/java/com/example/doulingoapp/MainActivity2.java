package com.example.doulingoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button18 = findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Nghe giọng nói", Toast.LENGTH_SHORT).show();
            }
        });
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);



        button10.setOnClickListener(mLintener);
        button11.setOnClickListener(mLintener);
        button12.setOnClickListener(mLintener);
        button13.setOnClickListener(mLintener);
        button14.setOnClickListener(mLintener);
        button15.setOnClickListener(mLintener);
        button16.setOnClickListener(mLintener);

    }

    View.OnClickListener mLintener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.button10:
                    boolean e = button10.isEnabled();
                    button10.setEnabled(!e);

                    break;
                case R.id.button11:
                    boolean a = button11.isEnabled();
                    button11.setEnabled(!a);

                    break;
                case R.id.button12:
                    boolean b = button12.isEnabled();
                    button12.setEnabled(!b);

                    break;
                case R.id.button13:
                    boolean c = button13.isEnabled();
                    button13.setEnabled(!c);

                    break;
                case R.id.button14:
                    boolean d = button14.isEnabled();
                    button14.setEnabled(!d);

                    break;
                case R.id.button15:
                    boolean f = button15.isEnabled();
                    button15.setEnabled(!f);

                    break;
                case R.id.button16:
                    boolean g = button16.isEnabled();
                    button16.setEnabled(!g);

                    break;

                default:
                    break;
            }

        }
    };
}