package com.hexasoftwares.quizbuddy;

/**
 * Class created by Pritesh on 23-03-2018
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MechanicalData extends AppCompatActivity {

    HomeActivity dc = new HomeActivity();
    int qno=dc.qno;
    int life=dc.life,score=dc.score,option=0;

    String que[]={
    /*(1)*/ "","Which of the following disciplines provides study of relative motion between the parts of a machine",
    /*(2)*/ "Which of the following is a lower pair",
    /*(3)*/ "If two moving elements have surface contact in motion, such pair is known as",
    /*(4)*/ "The example of lower pair is",
    /*(5)*/ "Pulley in a belt drive acts as",
    /*(6)*/ "The example of rolling pair is",
    /*(7)*/ "Any point on a link connecting double slider crank chain will trace a",
    /*(8)*/ "The purpose of a link is to",
    /*(9)*/ "A universal joint is an example of",
    /*(10)*/ "Rectilinear motion of piston is converted into rotary by"};

    String opta[]={
        /*(1)*/"","Theory of machines",
            /*(2)*/"ball and socket i",
            /*(3)*/"sliding pair",
            /*(4)*/"shaft revolving in a bearing",
            /*(5)*/"cylindrical pair",
            /*(6)*/"bolt and nut",
            /*(7)*/"straight line",
            /*(8)*/"transmit motion",
            /*(9)*/"higher pair",
            /*(10)*/"cross head"};
    int flagA[]={0,2,2,2,2,2,2,2,2,2,2};


    String optb[]={
        /*(1)*/"","Applied mechanics",
            /*(2)*/"piston and cylinder",
            /*(3)*/"rolling pair","straight line motion mechanisms","turning pair", "lead screw of a lathe", "circle", "guide other links", "lower pair", "slider crank"};
    int flagB[]={0,2,2,2,2,2,2,2,2,1,1};


    String optc[]={
        /*(1)*/"","mechanisms", "cam and follower", "surface pair", "automobile steering gear", "rolling pair", "ball and socket joint", "ellipse", "act as a support", "rolling pair", "connecting rod"};
    int flagC[]={0,2,2,2,2,1,2,1,2,2,2};


    String optd[]={
        /*(1)*/"","kinematics", "(a) and (b) above", "higher pair", "all of the above", "sliding pair", "ball bearing and roller bearing", "parabola", "all of the above", "sliding pair", "gudgeon pin"};
    int flagD[]={0,1,1,1,1,2,1,2,1,2,2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        String st=String.valueOf(score), lv=String.valueOf(life);
        final TextView textview=(TextView) findViewById(R.id.scoreView);
        final TextView lifeview=(TextView) findViewById(R.id.lifeView);
        final TextView queview=(TextView) findViewById(R.id.queView);
        final TextView optaview=(TextView) findViewById(R.id.optaView);
        final TextView optbview=(TextView) findViewById(R.id.optbView);
        final TextView optcview=(TextView) findViewById(R.id.optcView);
        final TextView optdview=(TextView) findViewById(R.id.optdView);

        lifeview.setText("X"+lv);
        textview.setText(" "+st);
        queview.setText(que[qno]);
        optaview.setText(opta[qno]);
        optbview.setText(optb[qno]);
        optcview.setText(optc[qno]);
        optdview.setText(optd[qno]);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.underwater);
        mp.start();

        dc.topic=3;
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
            Intent i = new Intent(MechanicalData.this, AboutActivity.class);
            startActivity(i);}
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(MechanicalData.this, HomeActivity.class);
            startActivity(i);}
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.optaView:
                if (checked)
                    option=flagA[qno];
                sound();
                break;
            case R.id.optbView:
                if (checked)
                    option=flagB[qno];
                sound();
                break;
            case R.id.optcView:
                if (checked)
                    option=flagC[qno];
                sound();
                break;
            case R.id.optdView:
                if (checked)
                    option=flagD[qno];
                sound();
                break;
        }
    }

    public void sound(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.option_selection);
        mp.start();
    }

    public void intentact(View view) {
        if (option == 0) {
            Toast.makeText(getApplicationContext(), "Please select any one Option!", Toast.LENGTH_SHORT).show();
        }
        if (option == 1) {
            Intent i = new Intent(this, CorrectActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        if (option == 2) {
            Intent i = new Intent(this, WrongActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }

}
