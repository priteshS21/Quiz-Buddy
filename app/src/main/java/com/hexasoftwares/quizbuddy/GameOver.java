package com.hexasoftwares.quizbuddy;

/**
 * Class created by Pritesh on 22-02-2016
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        HomeActivity dc = new HomeActivity();
        int score=dc.score;
        String st=String.valueOf(score);
        final TextView textview=(TextView) findViewById(R.id.scoreView);
        textview.setText("Dear "+ dc.name+ ",\n Your final score is "+st);

        dc.qno=1;
        dc.score=0;
        dc.life=3;

        MediaPlayer gov = MediaPlayer.create(getApplicationContext(), R.raw.gameover);
        gov.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about_app) {
            Intent i = new Intent(GameOver.this, AboutActivity.class);
            startActivity(i);}
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(GameOver.this, HomeActivity.class);
            startActivity(i);}
        return super.onOptionsItemSelected(item);
    }

    public void intentact(View view)
    {
        Intent i = new Intent(this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
    }
}