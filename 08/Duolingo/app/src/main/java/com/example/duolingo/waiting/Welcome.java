package com.example.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.duolingo.ui.Start;

import pl.droidsonroids.gif.GifImageView;

public class Welcome extends AppCompatActivity {


    private static  int SPLASH_SCREEN = 5000;
    // Var
    Animation topAnim ;
    GifImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        // Assign
        topAnim = AnimationUtils.loadAnimation(this,R.anim.animation);
        image = findViewById(R.id.linhvat);


        // Animation

        image.setAnimation(topAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this , Start.class);
                startActivity(intent);
                finish();
            }
        },5200);


    }
}