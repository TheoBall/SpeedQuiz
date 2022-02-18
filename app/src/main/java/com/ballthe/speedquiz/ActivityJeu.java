package com.ballthe.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityJeu extends AppCompatActivity {

    private TextView TV_nomJoueur1;
    private TextView TV_nomJoueur2;
    private Button BT_menu;
    private Button BT_rejouer;
    private TextView TV_Phrase1;
    private TextView TV_Phrase2;
    private ArrayList<String> ListeQuestion = new ArrayList<>();
    private Button BT_Joueur1;
    private Button BT_Joueur2;

    private void getId(){
        TV_nomJoueur1 = findViewById(R.id.nomJoueur1);
        TV_nomJoueur2 = findViewById(R.id.nomJoueur2);
        BT_menu = findViewById(R.id.buttonMenu);
        BT_rejouer = findViewById(R.id.buttonRejouer);
        TV_Phrase1 = findViewById(R.id.gagnantJoueur1);
        TV_Phrase2 = findViewById(R.id.gagnantJoueur2);
        BT_Joueur1 = findViewById(R.id.boutonJ1);
        BT_Joueur2 = findViewById(R.id.boutonJ2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        getId();

        Intent GameActivity = getIntent();
        String Joueur1 = GameActivity.getStringExtra("Joueur1");
        String Joueur2 = GameActivity.getStringExtra("Joueur2");

        TV_nomJoueur1.setText(Joueur1);
        TV_nomJoueur2.setText(Joueur2);

        BT_menu.setVisibility(View.INVISIBLE);
        BT_rejouer.setVisibility(View.INVISIBLE);

        ListeQuestion.add("Les poules ont des dents");
        ListeQuestion.add("Elden Ring sera le jeu de l'année 2022");

    }



}
