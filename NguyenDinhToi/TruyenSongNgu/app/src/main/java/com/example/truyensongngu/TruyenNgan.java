package com.example.truyensongngu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TruyenNgan extends AppCompatActivity {

    //khai bao
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_ngan);

        //anh xa
        btn = (Button) findViewById(R.id.button1);
        //code
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TruyenNgan.this, expand_list_view.class);
                startActivity(intent);
            }
        });
    }
}