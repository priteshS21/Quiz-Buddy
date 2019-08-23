package com.hexasoftwares.quizbuddy.activity;

/**
 * Class created by Pritesh on 06-04-2015
 */

import android.content.Intent;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hexasoftwares.quizbuddy.R;
import com.hexasoftwares.quizbuddy.databinding.ActivityHomeBinding;
import com.hexasoftwares.quizbuddy.services.MusicService;
import com.hexasoftwares.quizbuddy.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityHomeBinding binding;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        Constants.qno = 0;
        Constants.score = 0;
        Constants.life = 3;

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentact();
            }
        });
        binding.spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Please choose");
        categories.add("Computer Science");
        categories.add("Electrical Engineering");
        categories.add("Mechanical Engineering");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(dataAdapter);
    }

    public void onStart() {
        super.onStart();
        startService(new Intent(this, MusicService.class));
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
            startActivity(i);
        }
        if (id == R.id.restart_quiz) {
            Intent i = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void intentact() {
        Constants.name = binding.nameEtV.getText().toString();

        if (Constants.name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show();
        } else {
            switch (index) {
                case 0: {
                    Toast.makeText(this, "Please choose your topic to start", Toast.LENGTH_LONG).show();
                    break;
                }
                case 1: {
                    Constants.topic = 1;
                    Intent i = new Intent(this, ComputerData.class);
                    startActivity(i);
                    finish();
                    break;
                }
                case 2: {
                    Constants.topic = 2;
                    Intent i = new Intent(this, ElectricalData.class);
                    startActivity(i);
                    finish();
                    break;
                }
                case 3: {
                    Constants.topic = 3;
                    Intent i = new Intent(this, MechanicalData.class);
                    startActivity(i);
                    finish();
                    break;
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