package com.example.duolingo_cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vocabulary extends AppCompatActivity {

    Button KiemTra;
    TextView DienVao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_vocab);
        KiemTra = findViewById(R.id.button);
        DienVao = findViewById(R.id.textview);

        KiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = DienVao.getText().toString();
                if(!str.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Vocabulary.this);
                    if(str.equalsIgnoreCase("hot")){
                        builder.setMessage("Congratulation! That's a correct answer");
                    }else{
                        builder.setMessage("Wrong answer :((");
                    }
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            startActivity(new Intent(Vocabulary.this, Choose_Correct.class));
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}