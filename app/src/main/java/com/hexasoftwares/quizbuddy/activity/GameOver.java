package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 22-02-2016
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hexasoftwares.quizbuddy.R;
import com.hexasoftwares.quizbuddy.databinding.ActivityGameOverBinding;
import com.hexasoftwares.quizbuddy.services.MusicService;
import com.hexasoftwares.quizbuddy.utils.Constants;


public class GameOver extends AppCompatActivity {
    ActivityGameOverBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_over);
        binding.finalScore.setText("Dear " + Constants.name + ",\n Your final score is " + Constants.score);

        Constants.qno = 1;
        Constants.score = 0;
        Constants.life = 3;

        MediaPlayer gov = MediaPlayer.create(getApplicationContext(), R.raw.gameover);
        gov.start();

        stopService(new Intent(this, MusicService.class));
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
            startActivity(i);
        }
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(GameOver.this, HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void intentact(View view) {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        finish();
    }
}