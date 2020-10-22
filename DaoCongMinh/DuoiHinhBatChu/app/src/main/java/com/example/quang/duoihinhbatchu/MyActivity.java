package com.example.quang.duoihinhbatchu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Quang on 5/31/2016.
 */
public class MyActivity extends Activity implements View.OnClickListener {
    private static final String RESULD = "RESULD ";
    /**
     * Called when the activity is first created.
     */
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;

    private Button btnNext, btnAnswer1, btnAnswer4, btnAnswer3, btnAnswer2,
            btnAnswer5, btnAnswer6, btnAnswer7, btnAnswer8,
            btnAnswer9, btnAnswer10, btnAnswer11, btnAnswer12,
            btnAnswer13, btnAnswer14, btnAnswer15, btnAnswer16;

    private ImageView ivPicture;
    private TextView tvResult, tvScore, tvHeart;

    private ArrayList<Button> btnMng = new ArrayList<Button>();
    private ArrayList<Button> btnAnsMng = new ArrayList<Button>();
    private ArrayList<Question> questionsMng = new ArrayList<Question>();

    private Random rd = new Random();
    private int count = 0;
    private int heart = 5;
    private int score;

    private String answer = "";
    private String question = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initButtons();
        initQuestions();
        ivPicture = (ImageView) findViewById(R.id.iv_picture);
        tvResult = (TextView) findViewById(R.id.tv_result);
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvHeart = (TextView) findViewById(R.id.tv_heart);
        starQuestion();
    }
// viet lai
    private void initButtons() {
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn10 = (Button) findViewById(R.id.btn_10);
        btn11 = (Button) findViewById(R.id.btn_11);
        btn12 = (Button) findViewById(R.id.btn_12);
        btn13 = (Button) findViewById(R.id.btn_13);
        btn14 = (Button) findViewById(R.id.btn_14);
        btn15 = (Button) findViewById(R.id.btn_15);
        btn16 = (Button) findViewById(R.id.btn_16);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        btnMng.add(btn1);
        btnMng.add(btn2);
        btnMng.add(btn3);
        btnMng.add(btn4);
        btnMng.add(btn5);
        btnMng.add(btn6);
        btnMng.add(btn7);
        btnMng.add(btn8);
        btnMng.add(btn9);
        btnMng.add(btn10);
        btnMng.add(btn11);
        btnMng.add(btn12);
        btnMng.add(btn13);
        btnMng.add(btn14);
        btnMng.add(btn15);
        btnMng.add(btn16);
        for (int i = 0; i < btnMng.size(); i++) {
            btnMng.get(i).setOnClickListener(this);
        }
        btnAnswer1 = (Button) findViewById(R.id.btn_Answer1);
        btnAnswer2 = (Button) findViewById(R.id.btn_Answer2);
        btnAnswer3 = (Button) findViewById(R.id.btn_Answer3);
        btnAnswer4 = (Button) findViewById(R.id.btn_Answer4);
        btnAnswer5 = (Button) findViewById(R.id.btn_Answer5);
        btnAnswer6 = (Button) findViewById(R.id.btn_Answer6);
        btnAnswer7 = (Button) findViewById(R.id.btn_Answer7);
        btnAnswer8 = (Button) findViewById(R.id.btn_Answer8);
        btnAnswer9 = (Button) findViewById(R.id.btn_Answer9);
        btnAnswer10 = (Button) findViewById(R.id.btn_Answer10);
        btnAnswer11 = (Button) findViewById(R.id.btn_Answer11);
        btnAnswer12 = (Button) findViewById(R.id.btn_Answer12);
        btnAnswer13 = (Button) findViewById(R.id.btn_Answer13);
        btnAnswer14 = (Button) findViewById(R.id.btn_Answer14);
        btnAnswer15 = (Button) findViewById(R.id.btn_Answer15);
        btnAnswer16 = (Button) findViewById(R.id.btn_Answer16);

        btnAnsMng.add(btnAnswer1);
        btnAnsMng.add(btnAnswer2);
        btnAnsMng.add(btnAnswer3);
        btnAnsMng.add(btnAnswer4);
        btnAnsMng.add(btnAnswer5);
        btnAnsMng.add(btnAnswer6);
        btnAnsMng.add(btnAnswer7);
        btnAnsMng.add(btnAnswer8);
        btnAnsMng.add(btnAnswer9);
        btnAnsMng.add(btnAnswer10);
        btnAnsMng.add(btnAnswer11);
        btnAnsMng.add(btnAnswer12);
        btnAnsMng.add(btnAnswer13);
        btnAnsMng.add(btnAnswer14);
        btnAnsMng.add(btnAnswer15);
        btnAnsMng.add(btnAnswer16);

        for (int i = 0; i < btnAnsMng.size(); i++) {
            btnAnsMng.get(i).setVisibility(View.INVISIBLE);
            btnAnsMng.get(i).setOnClickListener(this);
        }
    }

    public void initQuestions() {
        Question Q1 = new Question(R.drawable.aomua, "AOMUA");
        Question Q2 = new Question(R.drawable.baocao, "BAOCAO");
        Question Q3 = new Question(R.drawable.canthiep, "CANTHIEP");
        Question Q4 = new Question(R.drawable.cattuong, "CATTUONG");
        Question Q5 = new Question(R.drawable.chieutre, "CHIEUTRE");
        Question Q6 = new Question(R.drawable.danhlua, "DANHLUA");
        Question Q7 = new Question(R.drawable.danong, "DANONG");
        Question Q8 = new Question(R.drawable.giandiep, "GIANDIEP");
        Question Q9 = new Question(R.drawable.giangmai, "GIANGMAI");
        Question Q10 = new Question(R.drawable.hoidong, "HOIDONG");
        Question Q11 = new Question(R.drawable.baocao, "BAOCAO");
        Question Q12 = new Question(R.drawable.hongtam, "HONGTAM");
        Question Q13 = new Question(R.drawable.khoailang, "KHOAILANG");
        Question Q14 = new Question(R.drawable.kiemchuyen, "KIEMCHUYEN");
        Question Q15 = new Question(R.drawable.lancan, "LANCAN");
        Question Q16 = new Question(R.drawable.masat, "MASAT");
        Question Q17 = new Question(R.drawable.hoidong, "HOIDONG");
        Question Q18 = new Question(R.drawable.nambancau, "NAMBANCAU");
        Question Q19 = new Question(R.drawable.oto, "OTO");
        Question Q20 = new Question(R.drawable.quyhang, "QUYHANG");
        Question Q21 = new Question(R.drawable.xedapdien, "XEDAPDIEN");
        Question Q22 = new Question(R.drawable.xaphong, "XAPHONG");
        Question Q23 = new Question(R.drawable.xakep, "XAKEP");
        Question Q24 = new Question(R.drawable.vuonbachthu, "VUONBACHTHU");
        Question Q25 = new Question(R.drawable.vuaphaluoi, "VUAPHALUOI");
        Question Q26 = new Question(R.drawable.tranhthu, "TRANHTHU");
        Question Q27 = new Question(R.drawable.totien, "TOTIEN");
        Question Q28 = new Question(R.drawable.tohoai, "TOHOAI");
        Question Q29 = new Question(R.drawable.tichphan, "TICHPHAN");
        Question Q30 = new Question(R.drawable.thothe, "THOTHE");
        Question Q31 = new Question(R.drawable.songsong, "SONGSONG");
        Question Q32 = new Question(R.drawable.thattinh, "THATTINH");

        questionsMng.add(Q1);
        questionsMng.add(Q2);
        questionsMng.add(Q3);
        questionsMng.add(Q4);
        questionsMng.add(Q5);
        questionsMng.add(Q6);
        questionsMng.add(Q7);
        questionsMng.add(Q8);
        questionsMng.add(Q9);
        questionsMng.add(Q10);
        questionsMng.add(Q11);
        questionsMng.add(Q12);
        questionsMng.add(Q13);
        questionsMng.add(Q14);
        questionsMng.add(Q15);
        questionsMng.add(Q16);
        questionsMng.add(Q17);
        questionsMng.add(Q18);
        questionsMng.add(Q19);
        questionsMng.add(Q20);
        questionsMng.add(Q21);
        questionsMng.add(Q22);
        questionsMng.add(Q23);
        questionsMng.add(Q24);
        questionsMng.add(Q25);
        questionsMng.add(Q26);
        questionsMng.add(Q27);
        questionsMng.add(Q28);
        questionsMng.add(Q29);
        questionsMng.add(Q30);
        questionsMng.add(Q31);
        questionsMng.add(Q32);

    }


    public String makeAnswer(String str) {
        ArrayList<String> stringResult = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            stringResult.add(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < 16 - str.length(); i++) {
            String string = String.valueOf((char) (rd.nextInt(90 - 65) + 65));
            stringResult.add(string);
        }
        Collections.shuffle(stringResult);
        String result = "";
        for (int i = 0; i < stringResult.size(); i++) {
            result += stringResult.get(i);
        }
        return result;

    }

    public void starQuestion() {
        int temp = rd.nextInt(questionsMng.size());
        ivPicture.setImageResource(questionsMng.get(temp).getPicture());
        answer = questionsMng.get(temp).getAnswer();
        question = makeAnswer(answer);
        for (int i = 0; i < btnMng.size(); i++) {
            btnMng.get(i).setText(String.valueOf(question.charAt(i)));
        }
        for (int i = 0; i < answer.length(); i++) {
            btnAnsMng.get(i).setVisibility(View.VISIBLE);
        }
        tvResult.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
    }

    public void btnUser(Button btn) {
        String input = btn.getText().toString();
        btnAnsMng.get(count).setText(input);
        btn.setVisibility(View.INVISIBLE);
    }

    public void checkAnswer() {
        for (int i = 0; i < answer.length(); i++) {
            if (btnAnsMng.get(i).getText().toString().equals("")) {
                return;
            }
        }
        String answerUser = "";
        for (int i = 0; i < answer.length(); i++) {
            answerUser += btnAnsMng.get(i).getText().toString();
        }
        if (answerUser.equals(answer)) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < btnAnsMng.size(); i++) {
                btnAnsMng.get(i).setBackground(this.getResources().getDrawable(R.drawable.tile_true));
            }
            tvResult.setVisibility(View.VISIBLE);
            tvResult.setTextColor(Color.GREEN);
            tvResult.setText("Chuan Xac");
            btnNext.setVisibility(View.VISIBLE);
            score += 100;
            tvScore.setText(String.valueOf("\t" + score));
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < btnAnsMng.size(); i++) {
                btnAnsMng.get(i).setBackground(this.getResources().getDrawable(R.drawable.tile_false));
            }
            tvResult.setVisibility(View.VISIBLE);
            tvResult.setTextColor(Color.RED);
            tvResult.setText("Sai Roi");
            heart--;
            tvHeart.setText(String.valueOf(heart + "\t\t"));
            if (heart == 0) {
                Toast.makeText(this, "THUA CUOC", Toast.LENGTH_SHORT);
                finish();
            }
        }

    }

    public void dropButton(Button btn) {
        if (btn.getText().toString() == "") {
            return;
        }
        String temp = btn.getText().toString();
        btn.setText("");
        for (int i = 0; i < btnMng.size(); i++) {

            if (btnMng.get(i).getVisibility() == View.INVISIBLE) {
                btnMng.get(i).setText(temp);
                btnMng.get(i).setVisibility(View.VISIBLE);
                count--;
                break;
            }
        }
        Log.i(RESULD, temp);
    }

    public void resetButton() {
        for (int i = 0; i < btnAnsMng.size(); i++) {
            btnAnsMng.get(i).setText("");
            btnAnsMng.get(i).setVisibility(View.INVISIBLE);
            btnAnsMng.get(i).setBackground(this.getResources().getDrawable(R.drawable.tile_question));
        }
        for (int i = 0; i < btnMng.size(); i++) {
            btnMng.get(i).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                btnUser(btn1);
                count++;
                checkAnswer();
                break;

            case R.id.btn_2:
                btnUser(btn2);
                count++;
                checkAnswer();
                break;
            case R.id.btn_3:
                btnUser(btn3);
                count++;

                checkAnswer();
                break;
            case R.id.btn_4:
                btnUser(btn4);
                count++;
                checkAnswer();
                break;
            case R.id.btn_5:
                btnUser(btn5);
                count++;
                checkAnswer();
                break;
            case R.id.btn_6:
                btnUser(btn6);
                count++;
                checkAnswer();
                break;
            case R.id.btn_7:
                btnUser(btn7);
                count++;
                checkAnswer();
                break;
            case R.id.btn_8:
                btnUser(btn8);
                count++;
                checkAnswer();
                break;
            case R.id.btn_9:
                btnUser(btn9);
                count++;
                checkAnswer();
                break;
            case R.id.btn_10:
                btnUser(btn10);
                count++;
                checkAnswer();
                break;
            case R.id.btn_11:
                btnUser(btn11);
                count++;
                checkAnswer();
                break;
            case R.id.btn_12:
                btnUser(btn12);
                count++;
                checkAnswer();
                break;
            case R.id.btn_13:
                btnUser(btn13);
                count++;
                checkAnswer();
                break;
            case R.id.btn_14:
                btnUser(btn14);
                count++;
                checkAnswer();
                break;
            case R.id.btn_15:
                btnUser(btn15);
                count++;
                checkAnswer();
                break;
            case R.id.btn_16:
                btnUser(btn16);
                count++;
                checkAnswer();
                break;
            case R.id.btn_next:
                answer = "";
                resetButton();
                starQuestion();
                count = 0;
                break;
            case R.id.btn_Answer1:
                if(btnAnswer2.getText()==""){
                    dropButton(btnAnswer1);
                }
                break;
            case R.id.btn_Answer2:
                if(btnAnswer3.getText()==""){
                    dropButton(btnAnswer2);
                }
                break;
            case R.id.btn_Answer3:
                if(btnAnswer4.getText()==""){
                    dropButton(btnAnswer3);
                }
                break;
            case R.id.btn_Answer4:
                if(btnAnswer5.getText()==""){
                    dropButton(btnAnswer4);
                }
                break;
            case R.id.btn_Answer5:
                if(btnAnswer6.getText()==""){
                    dropButton(btnAnswer5);
                }
                break;
            case R.id.btn_Answer6:
                if(btnAnswer7.getText()==""){
                    dropButton(btnAnswer6);
                }
                break;
            case R.id.btn_Answer7:
                if(btnAnswer8.getText()==""){
                    dropButton(btnAnswer7);
                }
                break;
            case R.id.btn_Answer8:
                if(btnAnswer9.getText()==""){
                    dropButton(btnAnswer8);
                }
                break;
            case R.id.btn_Answer9:
                if(btnAnswer10.getText()==""){
                    dropButton(btnAnswer9);
                }
                break;
            case R.id.btn_Answer10:
                if(btnAnswer11.getText()==""){
                    dropButton(btnAnswer10);
                }
                break;
            case R.id.btn_Answer11:
                if(btnAnswer12.getText()==""){
                    dropButton(btnAnswer11);
                }
                break;
            case R.id.btn_Answer12:
                if(btnAnswer13.getText()==""){
                    dropButton(btnAnswer12);
                }
                break;
            case R.id.btn_Answer13:
                if(btnAnswer14.getText()==""){
                    dropButton(btnAnswer13);
                }
                break;
            case R.id.btn_Answer14:
                if(btnAnswer15.getText()==""){
                    dropButton(btnAnswer14);
                }
                break;
            case R.id.btn_Answer15:
                if(btnAnswer16.getText()==""){
                    dropButton(btnAnswer15);
                }
                break;
            case R.id.btn_Answer16:
                dropButton(btnAnswer16);
                break;

        }

    }
}
