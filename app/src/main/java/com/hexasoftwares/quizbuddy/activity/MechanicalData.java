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

public class MechanicalData extends AppCompatActivity {
    ActivityQuestionBinding binding;
    ArrayList<DataModel> quizData;

    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question);

        quizData = new ArrayList<>();
        quizData.add(new DataModel("Which of the following disciplines provides study of relative motion between the parts of a machine", "Theory of machines", "Applied mechanics", "mechanisms", "kinematics", 4));
        quizData.add(new DataModel("Which of the following is a lower pair", "ball and socket i", "piston and cylinder", "cam and follower", "(a) and (b) above", 4));
        quizData.add(new DataModel("If two moving elements have surface contact in motion, such pair is known as", "sliding pair", "rolling pair", "surface pair", "higher pair", 4));
        quizData.add(new DataModel("The example of lower pair is", "shaft revolving in a bearing", "straight line motion mechanisms", "automobile steering gear", "all of the above", 4));
        quizData.add(new DataModel("Pulley in a belt drive acts as", "cylindrical pair", "turning pair", "rolling pair", "sliding pair", 3));
        quizData.add(new DataModel("The example of rolling pair is", "bolt and nut", "lead screw of a lathe", "ball and socket joint", "ball bearing and roller bearing", 4));
        quizData.add(new DataModel("Any point on a link connecting double slider crank chain will trace a", "straight line", "circle", "ellipse", "parabola", 3));
        quizData.add(new DataModel("The purpose of a link is to", "transmit motion", "guide other links", "act as a support", "all of the above", 4));
        quizData.add(new DataModel("A universal joint is an example of", "higher pair", "lower pair", "rolling pair", "sliding pair", 2));
        quizData.add(new DataModel("Rectilinear motion of piston is converted into rotary by", "cross head", "slider crank", "connecting rod", "gudgeon pin", 2));

        binding.lifeView.setText("X" + Constants.life);
        binding.scoreView.setText(" " + Constants.score);
        binding.queView.setText(quizData.get(Constants.qno).getQue());
        binding.optaView.setText(quizData.get(Constants.qno).getOptA());
        binding.optbView.setText(quizData.get(Constants.qno).getOptB());
        binding.optcView.setText(quizData.get(Constants.qno).getOptC());
        binding.optdView.setText(quizData.get(Constants.qno).getOptD());

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
            Intent i = new Intent(MechanicalData.this, AboutActivity.class);
            startActivity(i);
        }
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(MechanicalData.this, HomeActivity.class);
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
