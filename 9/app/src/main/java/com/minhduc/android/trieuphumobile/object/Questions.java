package com.minhduc.android.trieuphumobile.object;

import java.util.ArrayList;

public class Questions {
    private String Content, CorrectAnswer;
    private ArrayList<String> arrWrongAnswer;

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {

        this.Content = Content;
    }

    public String getCorrectAnswer() {

        return CorrectAnswer;
    }

    public void setCorrectAnswer(String CorrectAnswer) {

        this.CorrectAnswer = CorrectAnswer;
    }

    public ArrayList<String> getArrWrongAnswer() {
        return arrWrongAnswer;
    }

    public void setArrWrongAnswer(ArrayList<String> arrWrongAnswer) {
        this.arrWrongAnswer = arrWrongAnswer;
    }

    public void setArrWrongAnswer(String wrongAnswer) {
        String arrWr[] = wrongAnswer.split("&");
        this.arrWrongAnswer = new ArrayList<>();
        for (String s : arrWr) {
            arrWrongAnswer.add(s);
        }
    }
}
