package com.example.duolingochooseanswer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.CheckedInputStream;

import static com.example.duolingochooseanswer.R.*;

public class MainActivity extends AppCompatActivity {
    Button btn_check;
    Button btn_opt1;
    Button btn_opt2;
    Button btn_opt3;
    TextView message;
    int choose=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        btn_check =  findViewById(id.Check);
        btn_check.setEnabled(false);

        btn_opt1 = findViewById(id.option1);
        btn_opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(btn_opt1,btn_opt2,btn_opt3);
                choose=1;
            }
        });
        btn_opt2 = findViewById(id.option2);
        btn_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(btn_opt2,btn_opt1,btn_opt3);
                choose=2;
            }
        });
        btn_opt3 = findViewById(id.option3);
        btn_opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBtn(btn_opt3,btn_opt2,btn_opt1);
                choose=3;
            }
        });
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if(choose==3){
                    builder.setMessage("Congratulation! That's a correct answer");
                }else{
                    builder.setMessage("Wrong answer :((");
                }

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        message.setVisibility(View.VISIBLE);
                    }
                });
                builder.show();
            }
        });
    }

    protected void SetBtn(Button change, Button otr1, Button otr2) {
        change.setBackgroundColor(Color.parseColor("#92ebff"));
        otr1.setBackgroundColor(Color.parseColor("white"));
        otr2.setBackgroundColor(Color.parseColor("white"));
        btn_check.setEnabled(true);
        btn_check.setBackgroundColor(Color.parseColor("#31cb06"));
    }
}