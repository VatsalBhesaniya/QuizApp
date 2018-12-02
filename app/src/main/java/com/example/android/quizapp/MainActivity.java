package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Creating variables
    TextView textView;
    Button btn_Mathematics;
    Button btn_Wonders;
    Button btn_Android;
    Button btn_Countries;
    Button btn_Actors;
    Button btn_Puzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt_heading);
        btn_Mathematics = (Button) findViewById(R.id.btn_Mathematics);
        btn_Wonders = (Button) findViewById(R.id.btn_Wonders);
        btn_Android = (Button) findViewById(R.id.btn_Android);
        btn_Countries = (Button) findViewById(R.id.btn_Countries);
        btn_Actors = (Button) findViewById(R.id.btn_Actors);
        btn_Puzzle = (Button) findViewById(R.id.btn_Puzzle);
        //Calling OnClickListner methods to start relevant activity
        btn_Mathematics.setOnClickListener(this);
        btn_Wonders.setOnClickListener(this);
        btn_Android.setOnClickListener(this);
        btn_Countries.setOnClickListener(this);
        btn_Actors.setOnClickListener(this);
        btn_Puzzle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Mathematics:
                Intent intentMathematics = new Intent(this, MathematicsActivity.class);
                startActivity(intentMathematics);
                break;
            case R.id.btn_Wonders:
                Intent intentWonders = new Intent(this, WondersActivity.class);
                startActivity(intentWonders);
                break;
            case R.id.btn_Android:
                Intent intentAndroid = new Intent(this, AndroidActivity.class);
                startActivity(intentAndroid);
                break;
            case R.id.btn_Countries:
                Intent intentCountries = new Intent(this, CountriesActivity.class);
                startActivity(intentCountries);
                break;
            case R.id.btn_Actors:
                Intent intentActors = new Intent(this, ActorsActivity.class);
                startActivity(intentActors);
                break;
            case R.id.btn_Puzzle:
                Intent intentPuzzle = new Intent(this, PuzzleActivity.class);
                startActivity(intentPuzzle);
                break;
        }
    }
}
