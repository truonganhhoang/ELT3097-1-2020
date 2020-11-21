package com.example.duolingo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.duolingo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RankActivity extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rank);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.rank);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.infor:
                        startActivity(new Intent(getApplicationContext(),InforActivity.class));
                        overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                        return true;
                    case R.id.rank:
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext(),ShopActivity.class));
                        overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                        return true;
                }
                return false;
            }
        });
        actionBar = getSupportActionBar();
        actionBar.hide();
    }
}