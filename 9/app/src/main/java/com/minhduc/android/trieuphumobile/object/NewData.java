package com.minhduc.android.trieuphumobile.object;

import java.util.ArrayList;
import java.util.Random;

public class NewData {
    public Questions MakeQuestions(int Level){
        Random r = new Random();
        int num1 = r.nextInt( 100);
        int num2 = r.nextInt( 100);
        int sum = num1+num2;
        String QuestionContent = num1+" + "+num2+" = ? "+"("+Level+")";
        Questions questions = new Questions();
        questions.setContent(QuestionContent);
        questions.setCorrectAnswer(""+sum);
        ArrayList<String> arrWrongAnswer = new ArrayList<>();
        do{
            int sum2 = r.nextInt(200);
            if(sum2 != sum){
                arrWrongAnswer.add(""+sum2);
            }
        }while (arrWrongAnswer.size()!=3);
        questions.setArrWrongAnser(arrWrongAnswer);
        return questions;
    }
}
