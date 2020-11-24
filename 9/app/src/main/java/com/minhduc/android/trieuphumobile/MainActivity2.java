package com.minhduc.android.trieuphumobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.minhduc.android.trieuphumobile.adapter.TienThuong;
import com.minhduc.android.trieuphumobile.object.Questions;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
ListView lsvTienThuong;
TienThuong TienThuongAdapter;
ArrayList<String> arrTienThuong;
Questions questions;


int AnswerPosition = 1;

TextView textQuestions,textAnswer1,textAnswer2,textAnswer3,textAnswer4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        AnhXa();
        setUp();
        setClick();
    }

    public void init() {
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("150,000,000");
        arrTienThuong.add("85,000,000");
        arrTienThuong.add("60,000,000");
        arrTienThuong.add("40,000,000");
        arrTienThuong.add("30,000,000");
        arrTienThuong.add("22,000,000");
        arrTienThuong.add("14,000,000");
        arrTienThuong.add("10,000,000");
        arrTienThuong.add("6,000,000");
        arrTienThuong.add("3,000,000");
        arrTienThuong.add("2,000,000");
        arrTienThuong.add("1,000,000");
        arrTienThuong.add("600,000");
        arrTienThuong.add("400,000");
        arrTienThuong.add("200,000");

        TienThuongAdapter = new TienThuong(this, 0, arrTienThuong);

        questions = new Questions();
    }

    public void AnhXa() {
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        textQuestions = findViewById(R.id.textQuestions);
        textAnswer1 = findViewById(R.id.textAnswer1);
        textAnswer2 = findViewById(R.id.textAnswer2);
        textAnswer3 = findViewById(R.id.textAnswer3);
        textAnswer4 = findViewById(R.id.textAnswer4);

    }

    public void setUp() {
        setQuestions();
        lsvTienThuong.setAdapter(TienThuongAdapter);

        ShowAnswer();
    }

    public void setClick() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnswer(((TextView)view).getText().toString());
            }
        };
        textAnswer1.setOnClickListener(listener);
        textAnswer2.setOnClickListener(listener);
        textAnswer3.setOnClickListener(listener);
        textAnswer4.setOnClickListener(listener);
    }
    public void CheckAnswer(String Answer){
        if(Answer.equals(questions.getCorrectAnswer())){
            AnswerPosition++;
            if (AnswerPosition >= 15) {
                AnswerPosition = 15;
            }
            ShowAnswer();
        }else{
            Toast.makeText(this,"GAME OVER!!!",Toast.LENGTH_SHORT).show();
        }
    }

    public void setQuestions(){
        questions = new Questions();
        questions.setContent("1 + 1 = ? ");
        questions.setCorrectAnswer(" 2 ");
        ArrayList<String> arrWrongAnswer = new ArrayList<>();
        arrWrongAnswer.add(" 3 ");
        arrWrongAnswer.add(" 5 ");
        arrWrongAnswer.add(" 11 ");
        questions.setArrWrongAnser(arrWrongAnswer);
    }
    public void ShowAnswer(){
        textAnswer1.setText(questions.getContent());
        ArrayList<String> arrAnswer = new ArrayList<>(questions.getArrWrongAnser());
        arrAnswer.add(questions.getCorrectAnswer());

        Random r = new Random();
        for(int i = 0; i < 5; i++){
            int pos1 = r.nextInt(arrAnswer.size());
            int pos2 = r.nextInt(arrAnswer.size());
            String x = arrAnswer.get(pos1);
            arrAnswer.set(pos1,arrAnswer.get(pos2));
            arrAnswer.set(pos2,x);
        }

        textAnswer1.setText(arrAnswer.get(0));
        textAnswer2.setText(arrAnswer.get(1));
        textAnswer3.setText(arrAnswer.get(2));
        textAnswer4.setText(arrAnswer.get(3));

        TienThuongAdapter.setAnswerPosition(AnswerPosition);
    }
}