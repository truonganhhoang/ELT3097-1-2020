package com.example.duolingo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duolingo.LoginActivity;
import com.example.duolingo.R;
import com.example.duolingo.question.QuestionOne;
import com.example.duolingo.question.QuestionTwo;
import com.example.duolingo.ui.selectlanguage.SelectLanguage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Start extends AppCompatActivity {
    @BindView(R.id.login)
    Button logIn;
    @BindView(R.id.startbutton)
    Button Startques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        Startques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Start.this, SelectLanguage.class);
            startActivity(intent);
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, LoginActivity.class);
                startActivity(intent);
            }
        });
}
}