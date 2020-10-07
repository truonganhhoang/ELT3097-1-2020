package com.example.npbi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button back;
    Button dapan1;
    Button dapan2;
    Button dapan3;
    Button dapan4;
    Button kiemtra;
    Button tieptuc;
    RelativeLayout layout1;
    TextView check;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.hide();
        back = findViewById(R.id.back);
        dapan1 = findViewById(R.id.dapan1);
        dapan2 = findViewById(R.id.dapan2);
        dapan3 = findViewById(R.id.dapan3);
        dapan4 = findViewById(R.id.dapan4);
        kiemtra = findViewById(R.id.kiemtra);
        tieptuc = findViewById(R.id.tieptuc);
        layout1 = findViewById(R.id.layout1);
        check = findViewById(R.id.check);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PreActivity.class));
            }
        });
        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NextActivity.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
        dapan1.setOnClickListener(mListener);
        dapan2.setOnClickListener(mListener);
        dapan3.setOnClickListener(mListener);
        dapan4.setOnClickListener(mListener);
        kiemtra.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            boolean b;
            switch (Id) {
                case R.id.dapan1:
                    kiemtra.setEnabled(true);
                    kiemtra.setBackgroundResource(R.drawable.custom_kiemtra);
                    dapan1.setSelected(true);
                    dapan2.setSelected(false);
                    dapan3.setSelected(false);
                    dapan4.setSelected(false);
                    break;
                case R.id.dapan2:
                    kiemtra.setEnabled(true);
                    dapan2.setSelectAllOnFocus(true);
                    kiemtra.setBackgroundResource(R.drawable.custom_kiemtra);
                    dapan2.setSelected(true);
                    dapan1.setSelected(false);
                    dapan3.setSelected(false);
                    dapan4.setSelected(false);
                    break;
                case R.id.dapan3:
                    kiemtra.setEnabled(true);
                    dapan3.setSelectAllOnFocus(true);
                    kiemtra.setBackgroundResource(R.drawable.custom_kiemtra);
                    dapan3.setSelected(true);
                    dapan4.setSelected(false);
                    dapan1.setSelected(false);
                    dapan2.setSelected(false);
                    break;
                case R.id.dapan4:
                    kiemtra.setEnabled(true);
                    dapan4.setSelected(true);
                    dapan1.setSelected(false);
                    dapan3.setSelected(false);
                    dapan2.setSelected(false);
                    kiemtra.setBackgroundResource(R.drawable.custom_kiemtra);

                    break;
                case R.id.kiemtra:
                    if(dapan1.isSelected()) {
                        kiemtra.setBackgroundResource(R.drawable.custom_check);
                        kiemtra.setText("Giỏi Lắm");
                        kiemtra.setTextColor(Color.WHITE);
                        layout1.setVisibility(layout1.VISIBLE);
                        kiemtra.setVisibility(View.INVISIBLE);
                    }
                    else {
                        layout1.setVisibility(layout1.VISIBLE);
                        layout1.setBackgroundResource(R.drawable.custom_tiep1);
                        tieptuc.setTextColor(Color.WHITE);
                        tieptuc.setBackgroundResource(R.drawable.custom_check);
                        kiemtra.setVisibility(View.INVISIBLE);
                        check.setText("Trả lời đúng: cake ");
                        check.setTextColor(Color.RED);
                    }
                    break;
                default:
                    break;

            }
        };
    };

}