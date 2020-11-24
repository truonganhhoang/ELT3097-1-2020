package com.example.duolingo.question;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duolingo.R;
import com.example.duolingo.ui.HomeActivity;
import com.example.duolingo.utils.CustomProgressbar;

public class QuestionTwo extends AppCompatActivity {
    Button buttonback;
    Button dapan1;
    Button dapan2;
    Button dapan3;
    Button kiemtra;
    Button continuos;
    RelativeLayout layout1;
    TextView check;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        bar = findViewById(R.id.progressBar);
        buttonback = findViewById(R.id.back);
        dapan1 = findViewById(R.id.dapan1);
        dapan2 = findViewById(R.id.dapan2);
        dapan3 = findViewById(R.id.dapan3);
        kiemtra = findViewById(R.id.kiemtra);
        layout1 = findViewById(R.id.layout1);
        continuos = findViewById(R.id.continuos);
        check = findViewById(R.id.check);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionTwo.this, HomeActivity.class));
            }
        });
        dapan1.setOnClickListener(mListener);
        dapan2.setOnClickListener(mListener);
        dapan3.setOnClickListener(mListener);
        kiemtra.setOnClickListener(mListener);



    // update progressBa

        int current = getIntent().getIntExtra("update",0);
        bar.setProgress(current);

        continuos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityChild(v);
            }
        });

    }
    public void openActivityChild(View v){
        Intent intent = new Intent(QuestionTwo.this , QuestionThree.class);
        int current = bar.getProgress();
        intent.putExtra("update", current);
        startActivity(intent);
    }


    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Id = v.getId();
            boolean b;
            switch (Id) {
                case R.id.dapan1:
                    kiemtra.setEnabled(true);
                    kiemtra.setBackgroundResource(R.drawable.button_check);
                    dapan1.setSelected(true);
                    dapan2.setSelected(false);
                    dapan3.setSelected(false);
                    break;
                case R.id.dapan2:
                    kiemtra.setEnabled(true);
                    dapan2.setSelectAllOnFocus(true);
                    kiemtra.setBackgroundResource(R.drawable.button_check);
                    dapan2.setSelected(true);
                    dapan1.setSelected(false);
                    dapan3.setSelected(false);

                    break;
                case R.id.dapan3:
                    kiemtra.setEnabled(true);
                    dapan3.setSelectAllOnFocus(true);
                    kiemtra.setBackgroundResource(R.drawable.button_check);
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


                       int  current = getIntent().getIntExtra("update",0);
                        bar.setProgress(current+20);

                    }
                    else {
                        layout1.setVisibility(layout1.VISIBLE);
                        layout1.setBackgroundResource(R.drawable.nextquestion_false);
                        continuos.setTextColor(Color.WHITE);
                        continuos.setBackgroundResource(R.drawable.custom_check);
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