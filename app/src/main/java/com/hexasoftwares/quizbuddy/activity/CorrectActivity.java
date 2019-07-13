package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 07-04-2015
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hexasoftwares.quizbuddy.R;
import com.hexasoftwares.quizbuddy.databinding.ActivityCorrectBinding;
import com.hexasoftwares.quizbuddy.utils.Constants;

public class CorrectActivity extends AppCompatActivity {
    ActivityCorrectBinding binding;

    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_correct);

        Constants.qno = Constants.qno + 1;
        Constants.score = Constants.score+10;

        binding.lifeView.setText("X"+ Constants.life);
        binding.scoreView.setText(" "+ Constants.score);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.correct_sound);
        mp.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        switch (Constants.topic){
            case 1:{
                Intent in = new Intent(this, ComputerData.class);
                startActivity(in);
                finish();
                break;
            }
            case 2:{
                Intent in = new Intent(this, ElectricalData.class);
                startActivity(in);
                finish();
                break;
            }
            case 3:{
                Intent in = new Intent(this, MechanicalData.class);
                startActivity(in);
                finish();
                break;
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
