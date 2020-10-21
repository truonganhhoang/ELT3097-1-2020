package com.hoangthang.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnKiemtra;
    Button button2;
    Button button3;
    Button button4;
    ProgressBar pbChay;
    int choose =0;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKiemtra = (Button) findViewById(R.id.buttonKiemtra);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        pbChay = (ProgressBar) findViewById(R.id.progressBar);


        btnKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = pbChay.getProgress();
                pbChay.setProgress(current = 40);
            }
        });
        button2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                //button2.setBackgroundColor(Color.parseColor("gray"));
                button3.setBackgroundResource(R.drawable.duongvien_goctron);
                button4.setBackgroundResource(R.drawable.duongvien_goctron);
                choose=2;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button2.setBackgroundResource(R.drawable.xanh);
            }
        }));

        button3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                button3.setBackgroundResource(R.drawable.xanh);
                button2.setBackgroundResource(R.drawable.duongvien_goctron);
                button4.setBackgroundResource(R.drawable.duongvien_goctron);
                choose=3;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);

            }
        }));

        button4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                button4.setBackgroundResource(R.drawable.xanh);
                button3.setBackgroundResource(R.drawable.duongvien_goctron);
                button2.setBackgroundResource(R.drawable.duongvien_goctron);
                choose=4;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
            }
        }));

        btnKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                if (choose==4){
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                    pbChay.setProgress(pbChay.getProgress() + 10);
                }
                else {
                    textView3.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}