package com.minhduc.android.trieuphumobile.object;

import java.util.ArrayList;

public class Questions {
    private String Content, CorrectAnswer;
    private ArrayList<String> arrWrongAnser;

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

    public ArrayList<String> getArrWrongAnser() {
        return arrWrongAnser;
    }

    public void setArrWrongAnser(ArrayList<String> arrWrongAnser) {
        this.arrWrongAnser = arrWrongAnser;
    }
}
