package com.example.marie_helenerots.trickygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.marie_helenerots.trickygame.Main2Activity.SAUVEGARDE;


public class MainActivity extends AppCompatActivity {


    public static final String RECOMMENCER = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); //Relie le fichier xml au fichier js
    }

    @Override
    protected void onResume() { //Lorsqu'on retourne sur la page
        super.onResume();

        SharedPreferences settings = getSharedPreferences(SAUVEGARDE, 0);
        int level = settings.getInt("Sauvegarde", 0);
        setLevel(level);
    }

    private void setLevel(int level) {
        TextView textView = (TextView) findViewById(R.id.textView4); //La zone de texte passe au texte suivant
        textView.setText("Niveau "+level+" Continuer"); //afficher se qui est entre parenthèse
    }

    public void onClick(View view ){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


    public void onClickRecommencer(View view){ //Lorsqu'on clique sur l'objet associé à cette fonction,

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(RECOMMENCER, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Sauvegarde", 0);
        setLevel(0);
        // Commit the edits!
        editor.commit();
    }
}


