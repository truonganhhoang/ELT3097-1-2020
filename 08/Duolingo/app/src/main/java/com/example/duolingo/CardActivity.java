package com.example.duolingo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {

    Button btnBack;
    Button Ans1;
    Button Ans2;
    Button Ans3;
    Button submit;
    Button Continuous;
    RelativeLayout layoutCheck;
    TextView check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        btnBack = findViewById(R.id.buttonback);
        Ans1 = findViewById(R.id.dapan1);
        Ans2 = findViewById(R.id.dapan2);
        Ans3 = findViewById(R.id.dapan3);
        submit = findViewById(R.id.kiemtra);
        layoutCheck = findViewById(R.id.layout1);
        Continuous = findViewById(R.id.tieptuc);
        check = findViewById(R.id.check);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(CardActivity.this,MainActivity.class));
            }
        });

        Ans1.setOnClickListener(mListener);
        Ans2.setOnClickListener(mListener);
        Ans3.setOnClickListener(mListener);
        submit.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            boolean b;
            switch (Id) {
                case R.id.dapan1:
                    submit.setEnabled(true);
                    submit.setBackgroundResource(R.drawable.custom_submit);
                    Ans1.setSelected(true);
                    Ans2.setSelected(false);
                    Ans3.setSelected(false);
                    break;
                case R.id.dapan2:
                    submit.setEnabled(true);
                    Ans2.setSelectAllOnFocus(true);
                    submit.setBackgroundResource(R.drawable.custom_submit);
                    Ans2.setSelected(true);
                    Ans1.setSelected(false);
                    Ans3.setSelected(false);

                    break;
                case R.id.dapan3:
                    submit.setEnabled(true);
                    Ans3.setSelectAllOnFocus(true);
                    submit.setBackgroundResource(R.drawable.custom_submit);
                    Ans3.setSelected(true);
                    Ans1.setSelected(false);
                    Ans2.setSelected(false);
                    break;
                case R.id.kiemtra:
                    if(Ans2.isSelected()) {
                        submit.setBackgroundResource(R.drawable.custom_true);
                        check.setText("Tuyệt Vời!");
                        submit.setTextColor(Color.WHITE);
                        layoutCheck.setVisibility(layoutCheck.VISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                    }
                    else {
                        layoutCheck.setVisibility(layoutCheck.VISIBLE);
                        layoutCheck.setBackgroundResource(R.drawable.custom_false);
                        Continuous.setTextColor(Color.WHITE);
                        Continuous.setBackgroundResource(R.drawable.custom_btnfalse);
                        submit.setVisibility(View.INVISIBLE);
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