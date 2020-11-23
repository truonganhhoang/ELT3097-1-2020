package com.example.duolingo.question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.style.TtsSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.duolingo.R;
import com.example.duolingo.ui.HomeActivity;

import java.util.Locale;

public class QuestionThree extends AppCompatActivity {
    // initialize Variable

    EditText etInput;
    Button  btConvert , back ,continous, kiemtra;
    TextToSpeech textToSpeech;
    RelativeLayout layout1;
    TextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        // Assign Variable

        etInput = findViewById(R.id.et_input);
        btConvert = findViewById(R.id.bt_convert);
        back = findViewById(R.id.back);
        continous = findViewById(R.id.continuos);
        layout1 = findViewById(R.id.layout1);
        kiemtra = findViewById(R.id.kiemtra);
        check = findViewById(R.id.check);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuestionThree.this, HomeActivity.class));
            }
        });
        continous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionThree.this , HomeActivity.class);
                int current = 100;
                intent.putExtra("update", current);
                startActivity(intent);
            }
        });


        textToSpeech = new TextToSpeech(getApplicationContext()
                , new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    // select Language
                    int lang  = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get EditText value
                String s = "I drink water";

                // text convert to speech
                int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        kiemtra.setBackgroundResource(R.drawable.button_check);
        kiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = etInput.getText().toString();
                String ans = "I drink water";
                if( a.equals(ans)){
                    check.setText("Gút Chóp em!");
                    layout1.setVisibility(layout1.VISIBLE);
                    kiemtra.setVisibility(View.INVISIBLE);
                }
                else {
                    layout1.setVisibility(layout1.VISIBLE);
                    layout1.setBackgroundResource(R.drawable.nextquestion_false);
                    continous.setTextColor(Color.WHITE);
                    continous.setBackgroundResource(R.drawable.custom_check);
                    kiemtra.setVisibility(View.INVISIBLE);
                    check.setText("Trả lời đúng: i drink water ");
                    check.setTextColor(Color.RED);
                }
            }
        });


    }


}