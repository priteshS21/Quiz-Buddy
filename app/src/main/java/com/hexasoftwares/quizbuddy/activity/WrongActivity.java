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
import com.hexasoftwares.quizbuddy.databinding.ActivityWrongBinding;
import com.hexasoftwares.quizbuddy.utils.Constants;

public class WrongActivity extends AppCompatActivity {

    private Boolean exit = false;
    ActivityWrongBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wrong);

        Constants.score = Constants.score - 5;
        Constants.life = Constants.life - 1;

        binding.lifeView.setText("X" + Constants.life);
        binding.scoreView.setText(" " + Constants.score);

        switch (Constants.topic) {
            case 1: {
                String ans[] = {"", "4 Layers", "Transmission capacity of a communication channels", "to connect LANs", "CREATE VIEW", "INSERT", "Graphite", "Operating System", "Hydrogen Sulphide", "Condensation", "Corona", "Silicon dioxide", "Powder type",
                        "Cheetah", "Decreases slightly", "Cryogenics", "Sulphonates", "Natural rubber", "Insects", "Biro Brothers", "Telescope"};
                binding.ansView.setText(ans[Constants.qno]);
                break;
            }
            case 2: {
                String ans[] = {"", "All of the above", "Two", "Any of the above", "one armature and one field", "Rotary converter", "Aluminium", "1700—2000 V", "Mercury arc rectifier", "any D.C. machine", "none of the above"};
                binding.ansView.setText(ans[Constants.qno]);
                break;
            }
            case 3: {
                String ans[] = {"", "kinematics", "(a) and (b) above", "higher pair", "all of the above", "rolling pair", "ball bearing and roller bearing", "ellipse", "all of the above", "lower pair", "slider crank"};
                binding.ansView.setText(ans[Constants.qno]);
                break;
            }

        }

        Constants.qno++;

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
            startActivity(i);
        }
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(WrongActivity.this, HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void intentact(View view) {
        if (Constants.life == 0) {
            Intent in = new Intent(this, GameOver.class);
            startActivity(in);
            finish();
        } else {
            switch (Constants.topic) {
                case 1: {
                    Intent in = new Intent(this, ComputerData.class);
                    startActivity(in);
                    finish();
                    break;
                }
                case 2: {
                    Intent in = new Intent(this, ElectricalData.class);
                    startActivity(in);
                    finish();
                    break;
                }
                case 3: {
                    Intent in = new Intent(this, MechanicalData.class);
                    startActivity(in);
                    finish();
                    break;
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
