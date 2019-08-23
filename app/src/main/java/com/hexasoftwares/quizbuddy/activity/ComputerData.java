package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 07-04-2015
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.hexasoftwares.quizbuddy.R;
import com.hexasoftwares.quizbuddy.databinding.ActivityQuestionBinding;
import com.hexasoftwares.quizbuddy.model.DataModel;
import com.hexasoftwares.quizbuddy.utils.Constants;

import java.util.ArrayList;

public class ComputerData extends AppCompatActivity {
    ActivityQuestionBinding binding;
    ArrayList<DataModel> quizData;
    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question);

        quizData = new ArrayList<>();

        quizData.add(new DataModel("How many layers are in the TCP/IP model?","4 Layers", "5 Layers","7 Layers","6 Layers", 1));
        quizData.add(new DataModel("What is the meaning of Bandwidth in Network?", "Transmission capacity of a communication channels", "None of Above", "Connected Computers in the Network", "Class of IP used in Network",1));
        quizData.add(new DataModel("What is the use of Bridge in Network?", "to separate LANs", "to connect LANs", "To control Network Speed", "All of the above",2));
        quizData.add(new DataModel("The SQL statement to create a view is?", "SELECT VIEW.", "MAKE VIEW.", "CREATE VIEW.", "INSERT VIEW.", 2));
        quizData.add(new DataModel("You can add a row using SQL in a database with which of the following?", "ADD", "MAKE", "CREATE", "INSERT",3));

        binding.lifeView.setText("X" + Constants.life);
        binding.scoreView.setText(" " + Constants.score);
        binding.queView.setText(quizData.get(Constants.qno).getQue());
        binding.optaView.setText(quizData.get(Constants.qno).getOptA());
        binding.optbView.setText(quizData.get(Constants.qno).getOptB());
        binding.optcView.setText(quizData.get(Constants.qno).getOptC());
        binding.optdView.setText(quizData.get(Constants.qno).getOptD());

        MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.underwater);
        player.start();
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
            Intent i = new Intent(ComputerData.this, AboutActivity.class);
            startActivity(i);
        }
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(ComputerData.this, HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.optaView:
                if (checked)
                    option = 1;
                sound();
                break;
            case R.id.optbView:
                if (checked)
                    option = 2;
                sound();
                break;
            case R.id.optcView:
                if (checked)
                    option = 3;
                sound();
                break;
            case R.id.optdView:
                if (checked)
                    option = 4;
                sound();
                break;
        }
    }

    public void sound() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.option_selection);
        mp.start();
    }

    public void intentact(View view) {
        if (option!=0){
            if (option == quizData.get(Constants.qno).getCorrectAnswer()) {
                Intent i = new Intent(this, CorrectActivity.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(this, WrongActivity.class);
                startActivity(i);
                finish();
            }
        } else {
            Toast.makeText(this, "Please choose any option", Toast.LENGTH_SHORT).show();
        }
    }
}