package com.ballthe.speedquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText ET_Joueur1;
    private EditText ET_Joueur2;
    private Button BT_AjouterJoueur;
    private Button BT_Start;
    private TextInputLayout TIL_Joueur1;
    private TextInputLayout TIL_Joueur2;
    private LinearLayout LayoutAbout;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolBar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolBar);

        ET_Joueur1 = findViewById(R.id.main_edittext_player1);
        ET_Joueur2 = findViewById(R.id.main_edittext_player2);
        BT_AjouterJoueur = findViewById(R.id.main_newPlayer_button);
        BT_Start = findViewById(R.id.main_start_button);
        TIL_Joueur1 = findViewById(R.id.main_textInputLayout_player1);
        TIL_Joueur2 = findViewById(R.id.main_textInputLayout_player2);
        LayoutAbout = findViewById(R.id.main_layout_about);

        ET_Joueur1.setVisibility(View.INVISIBLE);
        ET_Joueur2.setVisibility(View.INVISIBLE);
        TIL_Joueur1.setVisibility(View.INVISIBLE);
        TIL_Joueur2.setVisibility(View.INVISIBLE);

        BT_Start.setEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:

                break;
            case R.id.action_about:
                LayoutAbout.setVisibility(View.VISIBLE);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onStart(){
        super.onStart();

        BT_AjouterJoueur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ET_Joueur1.setVisibility(View.VISIBLE);
                TIL_Joueur1.setVisibility(View.VISIBLE);
            }
        });


        BT_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityJeu = new Intent(MainActivity.this, ActivityJeu.class);
                ActivityJeu.putExtra("Joueur1", ET_Joueur1.getText().toString());
                ActivityJeu.putExtra("Joueur2", ET_Joueur2.getText().toString());
                startActivity(ActivityJeu);
            }
        });

        ET_Joueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ET_Joueur1.getText().toString().isEmpty() || ET_Joueur2.getText().toString().isEmpty()){
                    ET_Joueur2.setVisibility(View.VISIBLE);
                    TIL_Joueur2.setVisibility(View.VISIBLE);
                    BT_Start.setEnabled(false);
                }else{
                    BT_Start.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        ET_Joueur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ET_Joueur1.getText().toString().isEmpty() || ET_Joueur2.getText().toString().isEmpty()){
                    BT_Start.setEnabled(false);
                }else{
                    BT_Start.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void clickActivity(View view) {
        LayoutAbout.setVisibility(View.INVISIBLE);
    }

}

