package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 23-03-2018
 */

import android.content.Intent;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hexasoftwares.quizbuddy.R;
import com.hexasoftwares.quizbuddy.databinding.ActivityQuestionBinding;
import com.hexasoftwares.quizbuddy.utils.Constants;

public class ElectricalData extends AppCompatActivity {
    ActivityQuestionBinding binding;

    int option = 0;

    String que[] = {
            /*(1)*/"", "Which of the following are the applications of D.C. system ?",
            /*(2)*/"In a single phase rotary converter the number of slip rings will be?",
            /*(3)*/"A synchronous converter can be started",
            /*(4)*/"A rotary converter is a single machine with?",
            /*(5)*/"Which of the following is reversible in action ?",
            /*(6)*/"Which of the following metals is generally manufactured by electrolysis process ?",
            /*(7)*/"With a motor converter it is possible to obtain D.C. voltage only upto",
            /*(8)*/"Normally, which of the following is used, when a large-scale conversion from AC. to D.C. power is required ?",
            /*(9)*/"A rotary converter in general construction and design, is more or less like",
            /*(10)*/"A rotary converter operates at a"};

    String opta[] = {
            /*(1)*/"", "Battery charging work",
            /*(2)*/"Two",
            /*(3)*/"By means of a small auxiliary motor",
            /*(4)*/"One armature and one field",
            /*(5)*/"Motor generator set",
            /*(6)*/"Load",
            /*(7)*/"200-100 V",
            /*(8)*/"Motor-generator set",
            /*(9)*/"a transformer",
            /*(10)*/"low power factor"};
    int flagA[] = {0, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2};


    String optb[] = {
            /*(1)*/"", "Arc welding",
            /*(2)*/"Three",
            /*(3)*/"From AC. side as induction motor",
            /*(4)*/"Two armatures and one field",
            /*(5)*/"Motor converter",
            /*(6)*/"Aluminium",
            /*(7)*/"600—800 V",
            /*(8)*/"Motor converter",
            /*(9)*/"an induction motor",
            /*(10)*/"high power factor"};
    int flagB[] = {0, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1};


    String optc[] = {
            /*(1)*/"", "Electrolytic and electro-chemical processes",
            /*(2)*/"Four",
            /*(3)*/"From D.C. side as D.C. motor",
            /*(4)*/"One armature and two fields",
            /*(5)*/"Rotary converter",
            /*(6)*/"Copper",
            /*(7)*/"1000—1200 V",
            /*(8)*/"Rotary converter",
            /*(9)*/"an alternator",
            /*(10)*/"zero power factor"};
    int flagC[] = {0, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2};


    String optd[] = {
            /*(1)*/"", "All of the above",
            /*(2)*/"Five",
            /*(3)*/"Any of the above",
            /*(4)*/"none of the above",
            /*(5)*/"none of the above",
            /*(6)*/"Zinc",
            /*(7)*/"1700—2000 V",
            /*(8)*/"Mercury arc rectifier",
            /*(9)*/"any D.C. machine",
            /*(10)*/"none of the above"};
    int flagD[] = {0, 1, 2, 1, 2, 2, 2, 1, 1, 1, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_question);

        binding.lifeView.setText("X" + Constants.life);
        binding.scoreView.setText(" " + Constants.score);
        binding.queView.setText(que[Constants.qno]);
        binding.optaView.setText(opta[Constants.qno]);
        binding.optbView.setText(optb[Constants.qno]);
        binding.optcView.setText(optc[Constants.qno]);
        binding.optdView.setText(optd[Constants.qno]);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.underwater);
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
            Intent i = new Intent(ElectricalData.this, AboutActivity.class);
            startActivity(i);
        }
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(ElectricalData.this, HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.optaView:
                if (checked)
                    option = flagA[Constants.qno];
                sound();
                break;
            case R.id.optbView:
                if (checked)
                    option = flagB[Constants.qno];
                sound();
                break;
            case R.id.optcView:
                if (checked)
                    option = flagC[Constants.qno];
                sound();
                break;
            case R.id.optdView:
                if (checked)
                    option = flagD[Constants.qno];
                sound();
                break;
        }
    }

    public void sound() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.option_selection);
        mp.start();
    }

    public void intentact(View view) {
        switch (option) {
            case 0: {
                Toast.makeText(getApplicationContext(), "Please select any one Option!", Toast.LENGTH_SHORT).show();
            }
            case 1: {
                Intent i = new Intent(this, CorrectActivity.class);
                startActivity(i);
                finish();
                break;
            }
            case 2: {
                Intent i = new Intent(this, WrongActivity.class);
                startActivity(i);
                finish();
                break;
            }
        }
    }
}
