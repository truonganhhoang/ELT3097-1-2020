package com.example.duolingo.question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.duolingo.R;

import java.util.Locale;

public class QuestionThree extends AppCompatActivity {
    // initialize Variable

    EditText etInput;
    Button  btConvert;
    TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        // Assign Variable
        etInput = findViewById(R.id.et_input);
        btConvert = findViewById(R.id.bt_convert);

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
                String s = etInput.getText().toString();

                 // text convert to speech
                int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        

    }
}