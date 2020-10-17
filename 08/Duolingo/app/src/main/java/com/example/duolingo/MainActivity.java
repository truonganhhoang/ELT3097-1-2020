package com.example.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton Back;
    Button Ans1;
    Button Ans2;
    Button Ans3;
    Button Ans4;
    Button Submit;
    Button Continue;
    RelativeLayout layoutCheck;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();

    Back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    });
    Continue.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, CardActivity.class));
        }
    });

        Ans1.setOnClickListener(mListener);
        Ans2.setOnClickListener(mListener);
        Ans3.setOnClickListener(mListener);
        Ans4.setOnClickListener(mListener);
        Submit.setOnClickListener(mListener);

    }
    private void setupUIView(){
        Back = findViewById(R.id.back);
        Ans1 = findViewById(R.id.ans1);
        Ans2 = findViewById(R.id.ans2);
        Ans3 = findViewById(R.id.ans3);
        Ans4 = findViewById(R.id.ans4);
        Submit = findViewById(R.id.submit);
        Continue = findViewById(R.id.kiemtra);
        layoutCheck = findViewById(R.id.layout1);
        textView3 = findViewById(R.id.textView3);
    }
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            switch (Id) {
                case R.id.ans1:
                    Submit.setEnabled(true);
                    Submit.setBackgroundResource(R.drawable.custom_submit);
                    Ans1.setSelected(true);
                    Ans2.setSelected(false);
                    Ans3.setSelected(false);
                    Ans4.setSelected(false);
                    break;
                case R.id.ans2:
                    Submit.setEnabled(true);
                    Ans2.setSelectAllOnFocus(true);
                    Submit.setBackgroundResource(R.drawable.custom_submit);
                    Ans2.setSelected(true);
                    Ans1.setSelected(false);
                    Ans3.setSelected(false);
                    Ans4.setSelected(false);
                    break;
                case R.id.ans3:
                    Submit.setEnabled(true);
                    Ans3.setSelectAllOnFocus(true);
                    Submit.setBackgroundResource(R.drawable.custom_submit);
                    Ans3.setSelected(true);
                    Ans1.setSelected(false);
                    Ans4.setSelected(false);
                    Ans2.setSelected(false);
                    break;
                case R.id.ans4:
                    Submit.setEnabled(true);
                    Ans4.setSelected(true);
                    Ans1.setSelected(false);
                    Ans3.setSelected(false);
                    Ans2.setSelected(false);
                    Submit.setBackgroundResource(R.drawable.custom_submit);

                    break;
                case R.id.submit:
                    if(Ans4.isSelected()) {
                        Submit.setBackgroundResource(R.drawable.custom_true);
                        textView3.setText("Giỏi lắm!");
                        layoutCheck.setVisibility(layoutCheck.VISIBLE);
                        Submit.setVisibility(View.INVISIBLE);
                    }
                    else {
                        layoutCheck.setVisibility(layoutCheck.VISIBLE);
                        layoutCheck.setBackgroundResource(R.drawable.custom_false);
                        Continue.setBackgroundResource(R.drawable.custom_btnfalse);
                        Submit.setVisibility(View.INVISIBLE);
                        textView3.setText("Trả lời đúng: \ntea ");
                        textView3.setTextColor(getResources().getColor(R.color.Recolor));
                    }
                    break;
                default:
                    break;

            }
        };
    };
}