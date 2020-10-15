package com.example.hocbanglaixemay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button dapan1;
    Button dapan2;
    Button dapan3;
    Button check;
    TextView cauhoi;
    TextView right;
    TextView wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dapan1 = (Button) findViewById(R.id.dapan1);
        dapan2 = (Button) findViewById(R.id.dapan2);
        dapan3 = (Button) findViewById(R.id.dapan3);
        check = (Button) findViewById(R.id.check);
        cauhoi = (TextView) findViewById(R.id.cauhoi);
        right = (TextView) findViewById(R.id.right);
        wrong = (TextView) findViewById(R.id.wrong);
        right.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);
        dapan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dapan1.setSelected(true);
                dapan2.setSelected(false);
                dapan3.setSelected(false);
                right.setVisibility(View.VISIBLE);
                wrong.setVisibility(View.INVISIBLE);
            }
        });
        dapan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dapan2.setSelected(true);
                dapan1.setSelected(false);
                dapan3.setSelected(false);
                right.setVisibility(View.INVISIBLE);
                wrong.setVisibility(View.VISIBLE);
            }
        });
        dapan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dapan3.setSelected(true);
                dapan1.setSelected(false);
                dapan2.setSelected(false);
                right.setVisibility(View.INVISIBLE);
                wrong.setVisibility(View.VISIBLE);
            }
        });

    }
}

