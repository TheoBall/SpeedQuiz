package com.ballthe.speedquiz;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ballthe.speedquiz.Controlers.QuestionManager;
import com.ballthe.speedquiz.Models.Question;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityJeu extends AppCompatActivity {

    Runnable questionRunnable=null;
    private TextView TV_NomJ1;
    private TextView TV_NomJ2;
    private Button BT_Menu;
    private Button BT_Rejouer;
    private TextView TV_Question1;
    private TextView TV_Question2;
    private Button BT_J1;
    private Button BT_J2;
    private TextView TV_ScoreJ1;
    private TextView TV_ScoreJ2;

    int ScoreJ1;
    int ScoreJ2;

    ArrayList<Question> listeQuestion = new ArrayList<>();

    Question questionEnCours;

    QuestionManager questionManager;

    /**
     * On instancie tout
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TV_NomJ1 = findViewById(R.id.nomJoueur1);
        TV_NomJ2 = findViewById(R.id.nomJoueur2);
        BT_Menu = findViewById(R.id.boutonMenu);
        BT_Rejouer = findViewById(R.id.boutonRejouer);
        TV_Question1 = findViewById(R.id.questionJoueur1);
        TV_Question2 = findViewById(R.id.questionJoueur2);
        BT_J1 = findViewById(R.id.boutonJ1);
        BT_J2 = findViewById(R.id.boutonJ2);
        TV_ScoreJ1 = findViewById(R.id.ScoreJ1);
        TV_ScoreJ2 = findViewById(R.id.ScoreJ2);

        Intent GameActivity = getIntent();
        String Joueur1 = GameActivity.getStringExtra("Joueur1");
        String Joueur2 = GameActivity.getStringExtra("Joueur2");

        TV_NomJ1.setText(Joueur1);
        TV_NomJ2.setText(Joueur2);

        BT_Menu.setVisibility(View.INVISIBLE);
        BT_Rejouer.setVisibility(View.INVISIBLE);

        questionManager = new QuestionManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        listeQuestion = questionManager.getQuestionList();

        Handler handler = new Handler();
        questionRunnable = new Runnable() {
            @Override
            public void run() {
                if(questionManager.listeVide(listeQuestion)){

                    /**
                     * On désactive les boutons, affiche le bouton de menu et le bouton rejouer
                     * puis on affiche le résultat de la partie dans les textview
                     */
                    BT_J1.setEnabled(false);
                    BT_J2.setEnabled(false);
                    BT_Menu.setVisibility(View.VISIBLE);
                    BT_Rejouer.setVisibility(View.VISIBLE);

                    if(ScoreJ1 > ScoreJ2) {
                        TV_Question1.setText(R.string.jeu_win);
                        TV_Question2.setText(R.string.jeu_lose);
                    } else if (ScoreJ2 > ScoreJ1) {
                        TV_Question1.setText(R.string.jeu_lose);
                        TV_Question2.setText(R.string.jeu_win);
                    } else {
                        TV_Question1.setText(R.string.jeu_equality);
                        TV_Question2.setText(R.string.jeu_equality);
                    }


                    handler.removeCallbacks(this);
                }else{
                    /**
                     * Quand on appuie sur un des deux boutons, on ajoute ou retire des points au
                     * joueur qui a appuyé suivant la réponse.
                     */
                    BT_J1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            BT_J1.setEnabled(false);
                            BT_J2.setEnabled(false);
                            if(questionEnCours.isReponse() == 1) {
                                ScoreJ1 ++;
                            } else if(ScoreJ1 != 0){
                                ScoreJ1 --;
                            }
                            TV_ScoreJ1.setText(Integer.toString(ScoreJ1));
                        }
                    });
                    BT_J2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            BT_J1.setEnabled(false);
                            BT_J2.setEnabled(false);
                            if(questionEnCours.isReponse() == 1) {
                                ScoreJ2 ++;
                            } else if(ScoreJ2 != 0){
                                ScoreJ2 --;
                            }
                            TV_ScoreJ2.setText(Integer.toString(ScoreJ2));
                        }
                    });
                    handler.postDelayed(this,3000);
                    BT_J1.setEnabled(true);
                    BT_J2.setEnabled(true);
                    questionEnCours = questionManager.getRandomQuestion(listeQuestion);
                    TV_Question1.setText(questionEnCours.getQuestion());
                    TV_Question2.setText(questionEnCours.getQuestion());
                }
            }
        };
        handler.postDelayed(questionRunnable,3000);

        BT_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(ActivityJeu.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
        BT_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(ActivityJeu.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
        BT_Rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityJeu = new Intent(ActivityJeu.this, ActivityJeu.class);
                startActivity(ActivityJeu);
            }
        });
    }
}