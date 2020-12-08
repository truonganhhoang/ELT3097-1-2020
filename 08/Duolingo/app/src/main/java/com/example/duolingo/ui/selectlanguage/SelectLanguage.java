package com.example.duolingo.ui.selectlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.duolingo.R;
import com.example.duolingo.ui.HomeActivity;
import com.example.duolingo.ui.Start;
import com.example.duolingo.ui.join.Join1;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectLanguage extends AppCompatActivity {
    RecyclerView recyclerView;
    @BindView(R.id.back)
    Button Back;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    String s1[];
    int images[] = {R.drawable.english,R.drawable.brazil,R.drawable.spanish,R.drawable.russia,R.drawable.china,R.drawable.italia,R.drawable.japan,R.drawable.korea};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        ButterKnife.bind(this);
        progressBar.setProgress(20);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectLanguage.this, Start.class));
            }
        });
        recyclerView = findViewById(R.id.recyclerview);

        s1 = getResources().getStringArray(R.array.language_join);

        MyAdapter myAdapter = new MyAdapter(this, s1, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openActivityChild(View view) {
        startActivity(new Intent(SelectLanguage.this, Join1.class));
    }
}