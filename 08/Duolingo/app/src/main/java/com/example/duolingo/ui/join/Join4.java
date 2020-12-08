package com.example.duolingo.ui.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.duolingo.R;
import com.example.duolingo.question.QuestionOne;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Join4 extends AppCompatActivity {
    @BindView(R.id.back)
    Button Back;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join4);
        ButterKnife.bind(this);
        progressBar.setProgress(100);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Join4.this, LevelList.class));
            }
        });
    }


    public void StartQues(View view) {
        startActivity(new Intent(Join4.this, QuestionOne.class));
    }
}