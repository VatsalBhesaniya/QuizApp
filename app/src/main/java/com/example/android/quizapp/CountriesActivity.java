package com.example.android.quizapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class CountriesActivity extends AppCompatActivity {
    // Creating variables
    private ScrollView scrollView;
    private ProgressBar progressBar;
    private TextView question;
    private TextView score;
    private ImageView image_countries;
    private EditText userAnswer;
    private QuestionsCountries mQuestions = new QuestionsCountries();
    private QuestionsCountries mImages = new QuestionsCountries();
    private String mAnswer;
    private int mscore;
    private int mQuestionsLength = mQuestions.mImages.length;
    private int progress;
    private int nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        //Prevent appear keyboard when activity start
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        scrollView = (ScrollView) findViewById(R.id.scrollview);
        userAnswer = (EditText) findViewById(R.id.user_answer);
        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        image_countries = (ImageView) findViewById(R.id.image_countries);
        //Initializing variables
        mscore = 0;
        progress = 0;
        nextQuestion = 0;
        //Calling method to update the question
        updateQuestion(nextQuestion);
        //Updating the score
        score.setText(getString(R.string.score, mscore));
    }

    private void updateQuestion(int n) {
        if (nextQuestion < mQuestionsLength) {
            nextQuestion++;
            question.setText(R.string.question_countries);
            image_countries.setImageResource(mImages.getImage(n));
            mAnswer = mQuestions.getCorrectAnswer(n);
        } else {
            gamecompleted();
        }
    }

    public void checkAnswer(View view) {
        //Hiding keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        // Storing user's answer in variable
        String answer = userAnswer.getText().toString();
        if (answer.isEmpty()) {
            Toast toast = Toast.makeText(CountriesActivity.this, R.string.error_message_countries, Toast.LENGTH_LONG);
            toast.show();
        } else {
            if (answer.equalsIgnoreCase(mAnswer)) {
                mscore++;
                score.setText("Score: " + mscore);
                Toast.makeText(CountriesActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CountriesActivity.this, R.string.toast_wrong, Toast.LENGTH_SHORT).show();
            }
            userAnswer.setText("");
            progress += 10;
            progressBar.setProgress(progress);
            updateQuestion(nextQuestion);
            scrollView.setScrollY(0);
            userAnswer.clearFocus();
        }
    }

    //This method will get called on quiz complition and show toast tosubmit the score
    private void gamecompleted() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CountriesActivity.this);
        alertDialogBuilder.setMessage(R.string.submit_score)
                .setCancelable(false)
                .setPositiveButton(R.string.btn_submit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Creating toast message to show the result of the quiz
                                Toast toast = Toast.makeText(CountriesActivity.this, getString(R.string.quiz_result, mQuestionsLength, mscore), Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                ViewGroup group = (ViewGroup) toast.getView();
                                TextView messageTextView = (TextView) group.getChildAt(0);
                                messageTextView.setTextSize(24);
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                v.setGravity(Gravity.CENTER);
                                toast.show();
                                //Starting the main activity
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    //This method will get called on quit button click and start the main activity.
    public void quitGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Invoked when the activity may be temporarily destroyed, saving the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("PROGRESS_BAR", progress);
        outState.putInt("QUESTION_NUMBER", mQuestionsLength);
        outState.putInt("NEXT_QUESTION", nextQuestion);
        outState.putInt("SCORE", mscore);
        outState.putString("CORRECT_ANSWER", mAnswer);
        outState.putString("ANSWER_TEXT", userAnswer.getText().toString());
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    // This callback is called only when there is a saved instance that is previously saved by using onSaveInstanceState().
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        progress = savedInstanceState.getInt("PROGRESS_BAR");
        progressBar.setProgress(progress);
        mQuestionsLength = savedInstanceState.getInt("QUESTION_NUMBER");
        nextQuestion = savedInstanceState.getInt("NEXT_QUESTION");
        mscore = savedInstanceState.getInt("SCORE");
        score.setText(getString(R.string.score, mscore));
        image_countries.setImageResource(mImages.getImage(nextQuestion - 1));
        mAnswer = savedInstanceState.getString("CORRECT_ANSWER");
        userAnswer.setText(savedInstanceState.getString("ANSWER_TEXT"));
    }
}
