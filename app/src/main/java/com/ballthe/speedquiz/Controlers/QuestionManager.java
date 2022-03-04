package com.ballthe.speedquiz.Controlers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;

import com.ballthe.speedquiz.Models.Question;
import com.ballthe.speedquiz.Models.speedquizSQLiteOpenHelper;

public class QuestionManager {

    private ArrayList<Question> questionList;

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public QuestionManager(Context context)
    {
        questionList = initQuestionList(context);
    }

    /**
     * Regarde si la liste est vide
     * @param listeQuestions
     * @return un booléen pour savoir si la liste est vide.
     */
    public boolean listeVide(ArrayList<Question> listeQuestions) {
        return listeQuestions.isEmpty();
    }

    private ArrayList<Question> initQuestionList(Context context){
        ArrayList<Question> listQuestion = new ArrayList<>();
        speedquizSQLiteOpenHelper helper = new speedquizSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true,"quiz",new String[]{"idQuiz","question","reponse"},null,null,null,null,"idquiz",null);
        while(cursor.moveToNext()){
            listQuestion.add(new Question(cursor));
        }
        cursor.close();
        db.close();
        return listQuestion;
    }

    /**
     * Donne une question au hasard parmis une liste de questions
     * @param listeQuestions
     * @return la question
     */
    public Question getRandomQuestion(ArrayList<Question> listeQuestions) {
        int randomIndex = getRandomIndex(listeQuestions);
        Question question = listeQuestions.get(randomIndex);
        listeQuestions.remove(randomIndex);
        return question;
    }

    /**
     * Donne un index au hasard dans une liste de question
     * @param listeQuestions
     * @return le numéro d'index
     */
    public int getRandomIndex(ArrayList<Question> listeQuestions) {
        Random rand = new Random();
        return rand.nextInt(listeQuestions.size());
    }

}
