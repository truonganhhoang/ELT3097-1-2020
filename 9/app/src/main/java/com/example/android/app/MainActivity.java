package com.example.android.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Button btt_thisathach;
    private Button btt_hoclythuyet;
    private Button btt_bienbao;
    private Button btt_meothi;
    private Button btt_tracuuluat;
    private Button btt_cauhoihaysai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new LearningFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_learn);
        }

        btt_thisathach = findViewById(R.id.btt_thisathach);
        btt_hoclythuyet = findViewById(R.id.btt_hoclythuyet);
        btt_bienbao = findViewById(R.id.btt_bienbao);
        btt_meothi = findViewById(R.id.btt_meothi);
        btt_tracuuluat = findViewById(R.id.btt_tracuuluat);
        btt_cauhoihaysai = findViewById(R.id.btt_cauhoihaysai);

        btt_thisathach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),)
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_learn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LearningFragment()).commit();
                break;
            case R.id.mav_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InfoFragment()).commit();
                break;
            case R.id.nav_email:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EmailFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Đã chia sẻ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Đã gửi tin nhắn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_rate:
                Toast.makeText(this, "Đã đánh giá ứng dụng 5 sao. Cảm ơn bạn!", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public void button1(View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}