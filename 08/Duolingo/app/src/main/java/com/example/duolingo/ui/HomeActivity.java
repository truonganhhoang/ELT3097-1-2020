package com.example.duolingo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.duolingo.R;
import com.example.duolingo.question.QuestionOne;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    Button coban1;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.infor:
                        startActivity(new Intent(getApplicationContext(),InforActivity.class));
                        overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                        return true;
                    case R.id.rank:
                        startActivity(new Intent(getApplicationContext(),RankActivity.class));
                        overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(),ShopActivity.class));
                        overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                        return true;
                    case R.id.home:
                        return true;
                }
                return false;
            }
        });
        coban1 = findViewById(R.id.coban1);
        coban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (HomeActivity.this, QuestionOne.class));
            }
        });
        actionBar = getSupportActionBar();
        actionBar.hide();
    }
}