package com.example.duolingo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.duolingo.R;
import com.example.duolingo.question.QuestionOne;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    ProgressBar bar;
    Button listOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bar = findViewById(R.id.progress_bar);
        listOne = findViewById(R.id.list_one);

        int current = bar.getProgress();
        current += getIntent().getIntExtra("update",0);
        bar.setProgress(current);

        listOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, QuestionOne.class));
            }
        });

    }
}