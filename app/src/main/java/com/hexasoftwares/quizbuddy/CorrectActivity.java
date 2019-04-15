package com.hexasoftwares.quizbuddy;

/**
 * Class created by Pritesh on 07-04-2015
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CorrectActivity extends AppCompatActivity {

    private Boolean exit = false;
    HomeActivity dc = new HomeActivity();
    int score=dc.score+10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ComputerData qa = new ComputerData();
        qa.option=0;
        dc.score=score;
        dc.qno++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        int life=dc.life;
        String st=String.valueOf(score), lv=String.valueOf(life);
        final TextView textview=(TextView) findViewById(R.id.scoreView);
        final TextView lifeview=(TextView) findViewById(R.id.lifeView);
        lifeview.setText("X"+lv);
        textview.setText(" "+st);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.correct_sound);
        mp.start();
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
            Intent i = new Intent(CorrectActivity.this, AboutActivity.class);
            startActivity(i);}
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(CorrectActivity.this, HomeActivity.class);
            startActivity(i);}
        return super.onOptionsItemSelected(item);
    }

    public void intentact(View view)
    {
        switch (dc.topic){
            case 1:{
                Intent in = new Intent(this, ComputerData.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in); break;
            }
            case 2:{
                Intent in = new Intent(this, ElectricalData.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in); break;
            }
            case 3:{
                Intent in = new Intent(this, MechanicalData.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in); break;
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}
