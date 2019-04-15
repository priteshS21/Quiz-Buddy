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

public class WrongActivity extends AppCompatActivity {

    private Boolean exit = false;
    HomeActivity dc=new HomeActivity();
    int score=dc.score-5;
    int life=dc.life-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dc.life=life;
        dc.score=score;
        setContentView(R.layout.activity_wrong);
        int life=dc.life;
        String st=String.valueOf(score), lv=String.valueOf(life);
        final TextView textview=(TextView) findViewById(R.id.scoreView);
        final TextView lifeview=(TextView) findViewById(R.id.lifeView);
        final TextView ansview=(TextView) findViewById(R.id.ansView);
        lifeview.setText("X"+lv);
        textview.setText(" "+st);

        int qno=dc.qno;

        if(dc.topic==1){
        String ans[]={"","4 Layers","Transmission capacity of a communication channels","to connect LANs","CREATE VIEW","INSERT","Graphite","Operating System","Hydrogen Sulphide","Condensation","Corona","Silicon dioxide","Powder type",
                "Cheetah","Decreases slightly","Cryogenics","Sulphonates","Natural rubber","Insects","Biro Brothers","Telescope"};
        ansview.setText(ans[qno]);}

        else if(dc.topic==2){
            String ans[]={"","All of the above","Two","Any of the above","one armature and one field","Rotary converter","Aluminium","1700—2000 V","Mercury arc rectifier","any D.C. machine","none of the above"};
            ansview.setText(ans[qno]);}

        else if(dc.topic==3){
            String ans[]={"","kinematics", "(a) and (b) above", "higher pair", "all of the above","rolling pair","ball bearing and roller bearing","ellipse", "all of the above","lower pair", "slider crank"};
            ansview.setText(ans[qno]);}

        dc.qno++;

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.result);
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
            Intent i = new Intent(WrongActivity.this, AboutActivity.class);
            startActivity(i);}
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(WrongActivity.this, HomeActivity.class);
            startActivity(i);}
        return super.onOptionsItemSelected(item);
    }


    public void intentact(View view)
    {
        if(life==0) {
            Intent in = new Intent(this, GameOver.class);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(in);
        }
        else {
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
