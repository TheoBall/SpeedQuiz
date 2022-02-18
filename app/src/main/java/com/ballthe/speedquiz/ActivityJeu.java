package com.ballthe.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityJeu extends AppCompatActivity {

    private TextView TV_NomJ1;
    private TextView TV_NomJ2;
    private Button BT_Menu;
    private Button BT_Rejouer;
    private TextView TV_Question1;
    private TextView TV_Question2;
    private Button BT_J1;
    private Button BT_J2;
    private ArrayList<String> ListeQuestion = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TV_NomJ1 = findViewById(R.id.nomJoueur1);
        TV_NomJ2 = findViewById(R.id.nomJoueur2);
        BT_Menu = findViewById(R.id.buttonMenu);
        BT_Rejouer = findViewById(R.id.buttonRejouer);
        TV_Question1 = findViewById(R.id.gagnantJoueur1);
        TV_Question2 = findViewById(R.id.gagnantJoueur2);
        BT_J1 = findViewById(R.id.boutonJ1);
        BT_J2 = findViewById(R.id.boutonJ2);

        Intent GameActivity = getIntent();
        String Joueur1 = GameActivity.getStringExtra("Joueur1");
        String Joueur2 = GameActivity.getStringExtra("Joueur2");

        TV_NomJ1.setText(Joueur1);
        TV_NomJ2.setText(Joueur2);

        BT_Menu.setVisibility(View.INVISIBLE);
        BT_Rejouer.setVisibility(View.INVISIBLE);

        ListeQuestion.add("Les poules ont des dents");
        ListeQuestion.add("Elden Ring sera le jeu de l'année 2022");
        ListeQuestion.add("Sett est le personnage le plus stylé de LoL");
        ListeQuestion.add("Squid Game est inspiré du jeu Roblox Squid Game mode");
        ListeQuestion.add("Le FORTNITE BATTLE PASS coûte 850 V-bucks");
        ListeQuestion.add("Super Smash Bros Ultimate Ninja Storm 4 Tropical Freeze & Knuckles");
        ListeQuestion.add("Amoguste est l'impostor");
        ListeQuestion.add("Louis déteste les avions");

    }



}
