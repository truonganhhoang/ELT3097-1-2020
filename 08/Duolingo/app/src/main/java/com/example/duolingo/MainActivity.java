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
    Button back;
    Button Ans1;
    Button Ans2;
    Button Ans3;
    Button Ans4;
    Button button5;
    Button button6;
    RelativeLayout layout1;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();

    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    });
    button6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, CardActivity.class));
        }
    });

        Ans1.setOnClickListener(mListener);
        Ans2.setOnClickListener(mListener);
        Ans3.setOnClickListener(mListener);
        Ans4.setOnClickListener(mListener);
        button5.setOnClickListener(mListener);

    }
    private void setupUIView(){
        back = findViewById(R.id.back);
        Ans1 = findViewById(R.id.ans1);
        Ans2 = findViewById(R.id.ans2);
        Ans3 = findViewById(R.id.ans3);
        Ans4 = findViewById(R.id.ans4);
        button5 = findViewById(R.id.submit);
        button6 = findViewById(R.id.kiemtra);
        layout1 = findViewById(R.id.layout1);
        textView3 = findViewById(R.id.textView2);
    }
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            switch (Id) {
                case R.id.ans1:
                    button5.setEnabled(true);
                    button5.setBackgroundResource(R.drawable.custom_submit);
                    Ans1.setSelected(true);
                    Ans2.setSelected(false);
                    Ans3.setSelected(false);
                    Ans4.setSelected(false);
                    break;
                case R.id.ans2:
                    button5.setEnabled(true);
                    Ans2.setSelectAllOnFocus(true);
                    button5.setBackgroundResource(R.drawable.custom_submit);
                    Ans2.setSelected(true);
                    Ans1.setSelected(false);
                    Ans3.setSelected(false);
                    Ans4.setSelected(false);
                    break;
                case R.id.ans3:
                    button5.setEnabled(true);
                    Ans3.setSelectAllOnFocus(true);
                    button5.setBackgroundResource(R.drawable.custom_submit);
                    Ans3.setSelected(true);
                    Ans1.setSelected(false);
                    Ans4.setSelected(false);
                    Ans2.setSelected(false);
                    break;
                case R.id.ans4:
                    button5.setEnabled(true);
                    Ans4.setSelected(true);
                    Ans1.setSelected(false);
                    Ans3.setSelected(false);
                    Ans2.setSelected(false);
                    button5.setBackgroundResource(R.drawable.custom_submit);

                    break;
                case R.id.submit:
                    if(Ans4.isSelected()) {
                        button5.setBackgroundResource(R.drawable.custom_true);
                        button5.setText("Giỏi lắm!");
                        layout1.setVisibility(layout1.VISIBLE);
                        button5.setVisibility(View.INVISIBLE);
                    }
                    else {
                        layout1.setVisibility(layout1.VISIBLE);
                        layout1.setBackgroundResource(R.drawable.custom_false);
                        button6.setBackgroundResource(R.drawable.custom_btnfalse);
                        button5.setVisibility(View.INVISIBLE);
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