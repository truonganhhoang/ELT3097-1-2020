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
    ImageButton imgButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    RelativeLayout layout1;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();

    imgButton.setOnClickListener(new View.OnClickListener() {
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

        button1.setOnClickListener(mListener);
        button2.setOnClickListener(mListener);
        button3.setOnClickListener(mListener);
        button4.setOnClickListener(mListener);
        button5.setOnClickListener(mListener);

    }
    private void setupUIView(){
        imgButton = findViewById(R.id.imageButton);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        layout1 = findViewById(R.id.layout1);
        textView3 = findViewById(R.id.textView3);
    }
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            switch (Id) {
                case R.id.button1:
                    button5.setEnabled(true);
                    button5.setBackgroundResource(R.drawable.custom_submit);
                    button1.setSelected(true);
                    button2.setSelected(false);
                    button3.setSelected(false);
                    button4.setSelected(false);
                    break;
                case R.id.button2:
                    button5.setEnabled(true);
                    button2.setSelectAllOnFocus(true);
                    button5.setBackgroundResource(R.drawable.custom_submit);
                    button2.setSelected(true);
                    button1.setSelected(false);
                    button3.setSelected(false);
                    button4.setSelected(false);
                    break;
                case R.id.button3:
                    button5.setEnabled(true);
                    button3.setSelectAllOnFocus(true);
                    button5.setBackgroundResource(R.drawable.custom_submit);
                    button3.setSelected(true);
                    button1.setSelected(false);
                    button4.setSelected(false);
                    button2.setSelected(false);
                    break;
                case R.id.button4:
                    button5.setEnabled(true);
                    button4.setSelected(true);
                    button1.setSelected(false);
                    button3.setSelected(false);
                    button2.setSelected(false);
                    button5.setBackgroundResource(R.drawable.custom_submit);

                    break;
                case R.id.button5:
                    if(button4.isSelected()) {
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