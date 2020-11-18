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

    public class    MainActivity extends AppCompatActivity {
        Button button;
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
            button = findViewById(R.id.button);
            button1 = findViewById(R.id.button1);
            button2 = findViewById(R.id.button2);
            button3 = findViewById(R.id.button3);
            button4 = findViewById(R.id.button4);
            button5 = findViewById(R.id.button5);
            button6 = findViewById(R.id.button6);
            layout1 = findViewById(R.id.layout1);
            textView3 = findViewById(R.id.textView3);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, PreActivity.class));
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, NextActivity.class));
                }
            });
            button1.setOnClickListener(mListener);
            button2.setOnClickListener(mListener);
            button3.setOnClickListener(mListener);
            button4.setOnClickListener(mListener);
            button5.setOnClickListener(mListener);
        }

        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Id = v.getId();
                boolean b;
                switch (Id) {
                    case R.id.button1:
                        button5.setEnabled(true);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
                        button1.setSelected(true);
                        button2.setSelected(false);
                        button3.setSelected(false);
                        button4.setSelected(false);
                        break;
                    case R.id.button2:
                        button5.setEnabled(true);
                        button2.setSelectAllOnFocus(true);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
                        button2.setSelected(true);
                        button1.setSelected(false);
                        button3.setSelected(false);
                        button4.setSelected(false);
                        break;
                    case R.id.button3:
                        button5.setEnabled(true);
                        button3.setSelectAllOnFocus(true);
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);
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
                        button5.setBackgroundResource(R.drawable.custom_kiemtra);

                        break;
                    case R.id.button5:
                        if(button4.isSelected()) {
                            button5.setBackgroundResource(R.drawable.custom_check);
                            button5.setText("Giỏi Lắm");
                            layout1.setVisibility(layout1.VISIBLE);
                            button5.setVisibility(View.INVISIBLE);
                        }
                        else {
                            layout1.setVisibility(layout1.VISIBLE);
                            layout1.setBackgroundResource(R.drawable.custom_tiep1);
                            button6.setBackgroundResource(R.drawable.custom_check);
                            button5.setVisibility(View.INVISIBLE);
                            textView3.setText("Trả lời đúng: Trà");
                        }
                        break;
                    default:
                        break;

                }
            };
        };

    }