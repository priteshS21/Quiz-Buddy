package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 07-04-2015
 */

import android.content.Intent;

import androidx.databinding.DataBindingUtil;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.hexasoftwares.quizbuddy.R;
import com.hexasoftwares.quizbuddy.databinding.ActivityQuestionBinding;
import com.hexasoftwares.quizbuddy.utils.Constants;

public class ComputerData extends AppCompatActivity {
    ActivityQuestionBinding binding;
    int option = 0;

    String que[] = {
            /*(1)*/"", "How many layers are in the TCP/IP model?",
            /*(2)*/"What is the meaning of Bandwidth in Network?",
            /*(3)*/"What is the use of Bridge in Network?",
            /*(4)*/"The SQL statement to create a view is?",
            /*(5)*/"You can add a row using SQL in a database with which of the following?",
            /*(1)*/"Which of the following is used in pencils?",
            /*(2)*/"What is Android?",
            /*(3)*/"Brass gets discoloured in air because of the presence of which of the following gases in air?",
            /*(4)*/"When a gas is turned into a liquid the, process is called?",
            /*(5)*/"Which of the following of sun is easily visible only during a total solar eclipse?",
            /*(6)*/"Quartz crystals normally used in quartz clocks etc is chemically?",
            /*(7)*/"Which type of fire extinguisher is used for petroleum fire?",
            /*(8)*/"The fastest running terrestrial animal is?",
            /*(9)*/"As you go down into the well your weight?",
            /*(10)*/"The study of phenomena at very low temperature is called?",
            /*(11)*/"Detergents used for cleaning clothes and utensils contain?",
            /*(12)*/"Which of the following is a protein?",
            /*(13)*/"Entomology is a science that studies?",
            /*(14)*/"Who invented the bollpoint pen?",
            /*(15)*/"What galileo invented?",};

    String opta[] = {
            /*(1)*/"", "4 Layers",
            /*(2)*/"Transmission capacity of a communication channels",
            /*(3)*/"to separate LANs",
            /*(4)*/"SELECT VIEW.",
            /*(5)*/"ADD",
            /*(1)*/"Graphite",
            /*(2)*/"The Game",
            /*(3)*/"Oxygen",
            /*(4)*/"Evaporation",
            /*(5)*/"Core",
            /*(6)*/"Sodium silicate",
            /*(7)*/"Foam type",
            /*(8)*/"Cheetah",
            /*(9)*/"Increases slightly",
            /*(10)*/"Heat transfer",
            /*(11)*/"Bicarbonates",
            /*(12)*/"Natural rubber",
            /*(13)*/"Behaviour of the human beings",
            /*(14)*/"Biro Brothers",
            /*(15)*/"Thermometer",};
    int flagA[] = {0, 1, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 2};


    String optb[] = {
            /*(1)*/"", "5 Layers",
            /*(2)*/"None of Above",
            /*(3)*/"to connect LANs",
            /*(4)*/"MAKE VIEW.",
            /*(5)*/"MAKE",
            /*(1)*/"Silicon",
            /*(2)*/"Operating System",
            /*(3)*/"Carbon dioxide",
            /*(4)*/"Deposition",
            /*(5)*/"Phorosphere",
            /*(6)*/"Germanium oxide",
            /*(7)*/"Powder type",
            /*(8)*/"Lion",
            /*(9)*/"Decreases slightly",
            /*(10)*/"Morphology",
            /*(11)*/"Sulphonates",
            /*(12)*/"Starch",
            /*(13)*/"Insects",
            /*(14)*/"Waterman brothers",
            /*(15)*/"Barometer",};
    int flagB[] = {0, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 2};


    String optc[] = {
            /*(1)*/"", "7 Layers",
            /*(2)*/"Connected Computers in the Network",
            /*(3)*/"To control Network Speed",
            /*(4)*/"CREATE VIEW.",
            /*(5)*/"CREATE",
            /*(1)*/"Charcoal",
            /*(2)*/"Web browser",
            /*(3)*/"Nitrogen",
            /*(4)*/"Sublimation",
            /*(5)*/"Corona",
            /*(6)*/"A mixture of germanium oxide and silicon dioxide",
            /*(7)*/"Liquid type",
            /*(8)*/"Man",
            /*(9)*/"Remains exactly the same",
            /*(10)*/"Crystallography",
            /*(11)*/"Bismuthates",
            /*(12)*/"Cellulose",
            /*(13)*/"Origin and history of technical and specific terms",
            /*(14)*/"Bicc brothers",
            /*(15)*/"Telescope",};
    int flagC[] = {0, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1};


    String optd[] = {
            /*(1)*/"", "6 Layers",
            /*(2)*/"Class of IP used in Network",
            /*(3)*/"All of the above",
            /*(4)*/"INSERT VIEW.",
            /*(5)*/"INSERT",
            /*(1)*/"Phosphorous",
            /*(2)*/"None of These",
            /*(3)*/"Hydrogen Sulphide",
            /*(4)*/"Condensation",
            /*(5)*/"Sunspots",
            /*(6)*/"Silicon dioxide",
            /*(7)*/"Soda acid type",
            /*(8)*/"Cat",
            /*(9)*/"None of the above",
            /*(10)*/"Cryogenics",
            /*(11)*/"None of the above",
            /*(12)*/"None of the above",
            /*(13)*/"None of the above",
            /*(14)*/"Wright brothers",
            /*(15)*/"Microscope",};
    int flagD[] = {0, 2, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2};


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