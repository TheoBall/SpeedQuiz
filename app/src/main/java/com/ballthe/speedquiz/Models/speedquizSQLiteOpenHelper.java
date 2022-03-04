package com.ballthe.speedquiz.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class speedquizSQLiteOpenHelper extends SQLiteOpenHelper {


    static String DB_NAME="SpeedQuiz.db";
    static int DB_VERSION=1;
    public speedquizSQLiteOpenHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

    /**
     * On insert les questions à la base de données
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateDatatableQuiz = "CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY,question TEXT,reponse INTEGER);";
        db.execSQL(sqlCreateDatatableQuiz);
        db.execSQL("INSERT INTO quiz VALUES(1,\"Jules César est mort d'une dhiarrée\",0)");
        db.execSQL("INSERT INTO quiz VALUES(2,\"Elden Ring sera le jeu de l'année 2022\",1)");
        db.execSQL("INSERT INTO quiz VALUES(3,\"Sett est le personnage le plus stylé de LoL\",1)");
        db.execSQL("INSERT INTO quiz VALUES(4,\"Clash of Clans >>> Clash Royale\",1)");
        db.execSQL("INSERT INTO quiz VALUES(5,\"Squid Game est inspiré du jeu Roblox Squid Game mode\",1)");
        db.execSQL("INSERT INTO quiz VALUES(6,\"Le FORTNITE BATTLE PASS coûte 850 V-bucks\",0)");
        db.execSQL("INSERT INTO quiz VALUES(7,\"Amoguste est l'impostor\",0)");
        db.execSQL("INSERT INTO quiz VALUES(8,\"C'est toujours la faute du Jungler\",0)");
        db.execSQL("INSERT INTO quiz VALUES(9,\"Pythagore était un rappeur conscient\",0)");
        db.execSQL("INSERT INTO quiz VALUES(10,\"Houbbisoft est un crewmate\",0)");
        db.execSQL("INSERT INTO quiz VALUES(11,\"Bruno Mars est un skin Fortnite\",1)");
        db.execSQL("INSERT INTO quiz VALUES(12,\"La DIVTEC est dirigée par des Reptiliens\",1)");
        db.execSQL("INSERT INTO quiz VALUES(13,\"Le P.E.K.K.A. est la meilleure troupe de CoC\",1)");
        db.execSQL("INSERT INTO quiz VALUES(14,\"Kazuya GOAT de Smash Ultimate\",1)");
        db.execSQL("INSERT INTO quiz VALUES(15,\"Les jeux From Software devraient avoir un mode facile\",0)");
        db.execSQL("INSERT INTO quiz VALUES(16,\"Le skin Fortnite Spider-Man a eu un film à son nom\",1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}