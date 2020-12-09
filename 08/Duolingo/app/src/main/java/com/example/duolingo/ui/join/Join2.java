package com.example.duolingo.ui.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.duolingo.R;
import com.example.duolingo.ui.HomeActivity;
import com.example.duolingo.ui.selectlanguage.SelectLanguage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Join2 extends AppCompatActivity {
    @BindView(R.id.back)
    Button Back;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        ButterKnife.bind(this);
        progressBar.setProgress(40);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Join2.this, Join1.class));
            }
        });
    }

    public void openActivityChild(View view) {
        startActivity(new Intent(Join2.this, LevelList.class));
    }
}