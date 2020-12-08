package com.example.duolingo.ui.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duolingo.R;
import com.example.duolingo.ui.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LevelList extends AppCompatActivity {
    @BindView(R.id.back)
    Button Back;

    @BindView(R.id.casual)
    RelativeLayout Casual;

    @BindView(R.id.cas)
    TextView Cas;

    @BindView(R.id.fiv)
    TextView Fiv;

    @BindView(R.id.medium)
    RelativeLayout Medium;

    @BindView(R.id.med)
    TextView Med;

    @BindView(R.id.ten)
    TextView Ten;

    @BindView(R.id.serious)
    RelativeLayout Serious;

    @BindView(R.id.ser)
    TextView Ser;

    @BindView(R.id.fif)
    TextView Fif;

    @BindView(R.id.veryserious)
    RelativeLayout VerySerious;

    @BindView(R.id.veryser)
    TextView VerySer;

    @BindView(R.id.twen)
    TextView Twen;

    @BindView(R.id.continue_button)
    Button continueButton;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_list);
        ButterKnife.bind(this);
        progressBar.setProgress(80);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LevelList.this, Join4.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LevelList.this, Join2.class));
            }
        });

    }

    public void Casual(View view) {
        Casual.setSelected(true);   Medium.setSelected(false);  Serious.setSelected(false); VerySerious.setSelected(false);
    }

    public void Medium(View view) {
        Casual.setSelected(false);   Medium.setSelected(true);  Serious.setSelected(false); VerySerious.setSelected(false);
    }


    public void Serious(View view) {
        Casual.setSelected(false);   Medium.setSelected(false);  Serious.setSelected(true); VerySerious.setSelected(false);
    }

    public void VerySerious(View view) {
        Casual.setSelected(false);   Medium.setSelected(false);  Serious.setSelected(false); VerySerious.setSelected(true);
    }
}