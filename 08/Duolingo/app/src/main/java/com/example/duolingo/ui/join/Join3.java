package com.example.duolingo.ui.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.duolingo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Join3 extends AppCompatActivity {
    @BindView(R.id.back)
    Button Back;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.continue_button)
    Button Continuous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join3);
        ButterKnife.bind(this);
        progressBar.setProgress(80);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Join3.this, LevelList.class));
            }
        });
        Continuous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Join3.this, Join4.class));
            }
        });
    }
}