package com.example.duolingo.question;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.duolingo.R;

import java.util.Locale;

public class QuestionThree extends AppCompatActivity {
    // initialize Variable

    EditText etInput;
    Button  btConvert , back ,continous;
    Button check;
    TextToSpeech textToSpeech;
    ProgressBar bar;
    RelativeLayout layout1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        // Assign Variable

        Assign();

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
                String s = "i drink water";

                // text convert to speech
                int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = etInput.getText().toString();
                String ans = "i drink water";
                if( a.equals(ans)){
                    check.setBackgroundResource(R.drawable.custom_check);
                    check.setText("Tuyệt Vời");
                    check.setTextColor(Color.WHITE);
                    layout1.setVisibility(layout1.VISIBLE);
                    check.setVisibility(View.INVISIBLE);
                }
                else {
                    layout1.setVisibility(layout1.VISIBLE);
                    layout1.setBackgroundResource(R.drawable.nextquestion_false);
                    continous.setTextColor(Color.WHITE);
                    continous.setBackgroundResource(R.drawable.custom_check);
                    check.setVisibility(View.INVISIBLE);
                    check.setText("Trả lời đúng: i drink water ");
                    check.setTextColor(Color.RED);
                }
            }
        });


    }

    public void Assign(){
        etInput = findViewById(R.id.et_input);
        btConvert = findViewById(R.id.bt_convert);
        back = findViewById(R.id.back);
        continous = findViewById(R.id.tieptuc);
        bar = findViewById(R.id.progressBar);
        layout1 = findViewById(R.id.layout1);
        check = findViewById(R.id.kiemtra);
    }

}