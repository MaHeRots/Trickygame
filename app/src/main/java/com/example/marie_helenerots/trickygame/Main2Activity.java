package com.example.marie_helenerots.trickygame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String SAUVEGARDE = "MyPrefsFile"; // création d'une chaîne de caractères nommé SAUVEGARGE et ayant pour valeur "MPrefsFile"


    private int current_level;
    private String[] question = {
            "Envoyez se coucher la chauve-souris",
            "Combien d'escargots y a-t-il ?",
            "Trouvez l'étoile",
            "Trouvez le vampire",
            "Sauvez Willi",
            "Trouvez une nouvelle idée de niveau",
            "",
    };
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences settings = getSharedPreferences(SAUVEGARDE, 0);
        int level = settings.getInt("Sauvegarde", 0);
        setLevel(level); //Le niveau de difficulté part de 0
    }

    public void onClick(View view){ //Lorsqu'on clique sur l'objet associé à cette fonction,
        setLevel(current_level+1); //Augmenter le niveau de difficulté de 1
    }


    private void setLevel(int level) { //Lorsqu'on change de niveau,

        TextView textView = (TextView) findViewById(R.id.textView); //La zone de texte passe au texte suivant
        textView.setText("Niveau "+level); //ce texte est null

        TextView textView2 = (TextView) findViewById(R.id.textView2); //La zone de texte passe au texte suivant
        if( level < question.length) textView2.setText(question[level]); //ce texte est null



        current_level = level; //le niveau correspond au niveau actuel enregistré précédemment

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(SAUVEGARDE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Sauvegarde", current_level);

        // Commit the edits!
        editor.commit();
    }
}

/*
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle state){
        super.onCreate(state);
        . . .

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("silentMode", false);
        setSilent(silent);
    }

    @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("silentMode", mSilentMode);

        // Commit the edits!
        editor.commit();
    }
*/