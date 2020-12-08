package com.minhduc.android.trieuphumobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.minhduc.android.trieuphumobile.adapter.TienThuong;
import com.minhduc.android.trieuphumobile.object.NewData;
import com.minhduc.android.trieuphumobile.object.Questions;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
ListView lsvTienThuong;
TienThuong TienThuongAdapter;
ArrayList<String> arrTienThuong;
Questions questions;

int AnswerPosition ;
    View.OnClickListener listener;

TextView textQuestions,textAnswer1,textAnswer2,textAnswer3,textAnswer4,textGameover;
ArrayList<TextView> arrTextAnswers;
    String Answer;
    NewData newdata;
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

        arrTextAnswers = new ArrayList<>();

        newdata = new NewData();
    }

    public void AnhXa() {
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        textQuestions = findViewById(R.id.textQuestions);
        textAnswer1 = findViewById(R.id.textAnswer1);
        textAnswer2 = findViewById(R.id.textAnswer2);
        textAnswer3 = findViewById(R.id.textAnswer3);
        textAnswer4 = findViewById(R.id.textAnswer4);
        textGameover = findViewById(R.id.textGameover);

        arrTextAnswers.add(textAnswer1);
        arrTextAnswers.add(textAnswer2);
        arrTextAnswers.add(textAnswer3);
        arrTextAnswers.add(textAnswer4);

    }

    public void setUp() {
        textGameover.setVisibility(View.GONE);
        setQuestions();
        lsvTienThuong.setAdapter(TienThuongAdapter);

        ShowAnswer();
    }

    public void setClick() {
         listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnswer(((TextView)view));
            }
        };
        for (TextView t:arrTextAnswers){
            t.setOnClickListener(listener);
        }
    }
    public void CheckAnswer(final TextView text){
        Answer = text.getText().toString();
        text.setBackgroundResource(R.drawable.bg_choose);

        new CountDownTimer(2000,100){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                for(TextView t : arrTextAnswers) {
                    String s = t.getText().toString();
                    if (s.equals(questions.getCorrectAnswer())){
                        t.setBackgroundResource(R.drawable.bg_correct);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if(Answer.equals(questions.getCorrectAnswer())){
                            AnswerPosition++;
                            if (AnswerPosition > 15) {
                                AnswerPosition = 15;
                                textGameover.setVisibility(View.VISIBLE);
                                textGameover.setText("Congrats! You will get: \n" + arrTienThuong.get(0) + "$");
                                return;
                            }
                            ShowAnswer();
                        }else{
                            textGameover.setVisibility(View.VISIBLE);
                            int TienThuongPosition = (AnswerPosition/5)*5 ;
                            textGameover.setText("You will go home with: \n" + arrTienThuong.get(14-AnswerPosition) + "$");
                        }

                    }
                }.start();
            }
        }.start();


    }

    public void setQuestions(){
        questions = newdata.MakeQuestions(AnswerPosition);
    }
    public void ShowAnswer(){
        setQuestions();
        textQuestions.setText(questions.getContent());
        ArrayList<String> arrAnswer = new ArrayList<>(questions.getArrWrongAnswer());
        arrAnswer.add(questions.getCorrectAnswer());

        Random r = new Random();
        for(int i = 0; i < 5; i++){
            int pos1 = r.nextInt(arrAnswer.size());
            int pos2 = r.nextInt(arrAnswer.size());
            String x = arrAnswer.get(pos1);
            arrAnswer.set(pos1,arrAnswer.get(pos2));
            arrAnswer.set(pos2,x);
        }
        for(int i=0; i < arrTextAnswers.size();i++){
            arrTextAnswers.get(i).setOnClickListener(listener);
            arrTextAnswers.get(i).setVisibility(View.VISIBLE);
            arrTextAnswers.get(i).setBackgroundResource(R.drawable.bg_button);
            arrTextAnswers.get(i).setText(arrAnswer.get(i));
        }

        TienThuongAdapter.setAnswerPosition(AnswerPosition);
    }
    boolean trogiup5050 = true;
    public void trogiup5050(View view) {
            if(trogiup5050 == false ){
                return;
            }
            Random r = new Random();
            int QuestionsAndi =2;
            do{
                int Anpos = r.nextInt(4 );
                TextView t = arrTextAnswers.get(Anpos);

                if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(questions.getCorrectAnswer()) == false){
                    t.setVisibility(View.INVISIBLE);
                    t.setOnClickListener(null);
                    QuestionsAndi --;
                }
            }while(QuestionsAndi>0);
            trogiup5050 = false;
    }

    boolean trogiup_khangia = true;
    public void trogiup_khangia(View view) {
        if (trogiup_khangia = false) {
            return;
        }
        for (int i = 0; i < arrTextAnswers.size(); i++) {
            TextView t = arrTextAnswers.get(i);
            if (t.getText().toString().equals(questions.getCorrectAnswer())) {
                new KhanGiaTroGiup(this, i+1).show();
                break;
            }
        }
    }

    boolean trohiup_doicauhoi = true;
    public void trogiup_doicauhoi(View view) {
        if (trohiup_doicauhoi =  false) {
            return;
        }
        ShowAnswer();
        trohiup_doicauhoi = false;
    }
}