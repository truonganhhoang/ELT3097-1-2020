package com.example.duolingo.question;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duolingo.CardActivity;
import com.example.duolingo.R;

public class QuestionTwo extends AppCompatActivity {
    ActionBar actionBar;
    Button buttonback;
    Button dapan1;
    Button dapan2;
    Button dapan3;
    Button kiemtra;
    Button tieptuc;
    RelativeLayout layout1;
    TextView check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
        actionBar = getSupportActionBar();
        actionBar.hide();
        buttonback = findViewById(R.id.back);
        dapan1 = findViewById(R.id.dapan1);
        dapan2 = findViewById(R.id.dapan2);
        dapan3 = findViewById(R.id.dapan3);
        kiemtra = findViewById(R.id.kiemtra);
        layout1 = findViewById(R.id.layout1);
        tieptuc = findViewById(R.id.tieptuc);
        check = findViewById(R.id.check);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionTwo.this, CardActivity.class));
            }
        });
        dapan1.setOnClickListener(mListener);
        dapan2.setOnClickListener(mListener);
        dapan3.setOnClickListener(mListener);
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
                    break;
                case R.id.dapan2:
                    kiemtra.setEnabled(true);
                    dapan2.setSelectAllOnFocus(true);
                    kiemtra.setBackgroundResource(R.drawable.custom_kiemtra);
                    dapan2.setSelected(true);
                    dapan1.setSelected(false);
                    dapan3.setSelected(false);

                    break;
                case R.id.dapan3:
                    kiemtra.setEnabled(true);
                    dapan3.setSelectAllOnFocus(true);
                    kiemtra.setBackgroundResource(R.drawable.custom_kiemtra);
                    dapan3.setSelected(true);
                    dapan1.setSelected(false);
                    dapan2.setSelected(false);
                    break;
                case R.id.kiemtra:
                    if(dapan2.isSelected()) {
                        kiemtra.setBackgroundResource(R.drawable.custom_check);
                        check.setText("Tuyệt Vời!");
                        layout1.setVisibility(layout1.VISIBLE);
                        kiemtra.setVisibility(View.INVISIBLE);
                    }
                    else {
                        layout1.setVisibility(layout1.VISIBLE);
                        layout1.setBackgroundResource(R.drawable.custom_tiep1);
                        tieptuc.setTextColor(Color.WHITE);
                        tieptuc.setBackgroundResource(R.drawable.custom_check);
                        kiemtra.setVisibility(View.INVISIBLE);
                        check.setText("Trả lời đúng: I like you ");
                        check.setTextColor(Color.RED);
                    }
                    break;
                default:
                    break;

            }
        };
    };
}