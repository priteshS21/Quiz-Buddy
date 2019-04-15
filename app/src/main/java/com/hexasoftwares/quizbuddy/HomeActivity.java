package com.hexasoftwares.quizbuddy;

/**
 * Class created by Pritesh on 06-04-2015
 */

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static int qno;
    public static int score;
    public static int life;
    public static int topic;
    int index=0;
    public static String name;
    EditText nameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        musicstart();

        qno=1; score=0; life=3;

        nameEt = findViewById(R.id.nameEtV);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Please choose");
        categories.add("Computer Science");
        categories.add("Electrical Engineering");
        categories.add("Mechanical Engineering");
        categories.add("Chemical Engineering");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    public void musicstart(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.closer);

        if (mp.isPlaying()){
            mp.release();
        }   else    {
            mp.start();
        }

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
            Intent i = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(i);}
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(i);}
        return super.onOptionsItemSelected(item);
    }


    public void intentact(View view)
    {
        name = nameEt.getText().toString();

        if(name == null){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();
        }else if(name.isEmpty()){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();
        }else{ switch (index){
            case 0:{
                Toast.makeText(this, "Please choose your topic to start", Toast.LENGTH_LONG).show();
                break;
            }
            case 1:{
                Intent i = new Intent(this, ComputerData.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i); break;
            }
            case 2:{
                Intent i = new Intent(this, ElectricalData.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i); break;
            }
            case 3:{
                Intent i = new Intent(this, MechanicalData.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i); break;
            }
        }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        index = parent.getSelectedItemPosition();

        }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
};