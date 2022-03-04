package com.ballthe.speedquiz.Models;

import  android.database.Cursor;
public class Question {

    private String question;
    private int reponse;

    public Question(String question,int reponse){
        this.question = question;
        this.reponse = reponse;
    }

    //Curseur = tableau dynamique
    public Question(Cursor cursor){
        question = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        reponse = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));
    }

    public String getQuestion() {
        return question;
    }

    public int isReponse() {
        return reponse;
    }

}
