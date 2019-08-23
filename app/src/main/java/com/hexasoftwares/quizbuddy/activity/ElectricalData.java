package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 23-03-2018
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

public class ElectricalData extends AppCompatActivity {
    ActivityQuestionBinding binding;
    ArrayList<DataModel> quizData;

    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question);

        quizData = new ArrayList<>();

        quizData.add(new DataModel("Which of the following are the applications of D.C. system ?", "Battery charging work", "Arc welding", "Electrolytic and electro-chemical processes", "All of the above", 0));
        quizData.add(new DataModel("In a single phase rotary converter the number of slip rings will be?", "Two", "Three", "Four", "Five", 4));
        quizData.add(new DataModel("A synchronous converter can be started", "By means of a small auxiliary motor", "From AC. side as induction motor", "From D.C. side as D.C. motor", "Any of the above", 10));
        quizData.add(new DataModel("A rotary converter is a single machine with?", "One armature and one field", "Two armatures and one field", "One armature and two fields", "none of the above", 4));
        quizData.add(new DataModel("Which of the following is reversible in action ?", "Motor generator set", "Motor converter", "Rotary converter", "none of the above", 3));
        quizData.add(new DataModel("Which of the following metals is generally manufactured by electrolysis process ?", "Load", "Aluminium", "Copper", "Zinc", 2));
        quizData.add(new DataModel("With a motor converter it is possible to obtain D.C. voltage only upto", "200-100 V", "600—800 V", "1000—1200 V", "1700—2000 V", 4));
        quizData.add(new DataModel("Normally, which of the following is used, when a large-scale conversion from AC. to D.C. power is required ?", "Motor-generator set", "Motor converter", "Rotary converter", "Mercury arc rectifier", 4));
        quizData.add(new DataModel("A rotary converter in general construction and design, is more or less like", "a transformer", "an induction motor", "an alternator", "any D.C. machine", 4));
        quizData.add(new DataModel("A rotary converter operates at a", "low power factor", "high power factor", "zero power factor", "none of the above", 2));

        binding.lifeView.setText("X" + Constants.life);
        binding.scoreView.setText(" " + Constants.score);


        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.underwater);
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
        if (option != 0) {
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
