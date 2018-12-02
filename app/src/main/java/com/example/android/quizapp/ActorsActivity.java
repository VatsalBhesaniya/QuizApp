package com.example.android.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActorsActivity extends AppCompatActivity {
    // Creating variables
    private ScrollView scrollView;
    private ProgressBar progressBar;
    private TextView question;
    private TextView score;
    private ImageView image_actors_left;
    private ImageView image_actors_right;
    private CheckBox answer1;
    private CheckBox answer2;
    private CheckBox answer3;
    private CheckBox answer4;
    private Button btnNext;
    private QuestionsActors mQuestions = new QuestionsActors();
    private QuestionsActors mImages = new QuestionsActors();
    private String[] mAnswer;
    private ArrayList<String> mCorrectAnswer = new ArrayList<String>();
    private int mscore;
    private int mQuestionsLength = mQuestions.mImagesLeft.length;
    private int progress;
    private int nextQuestion;
    private int checkBoxClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        scrollView = (ScrollView) findViewById(R.id.scrollview);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);
        image_actors_left = (ImageView) findViewById(R.id.image_actors_left);
        image_actors_right = (ImageView) findViewById(R.id.image_actors_right);
        answer1 = (CheckBox) findViewById(R.id.answer_1);
        answer2 = (CheckBox) findViewById(R.id.answer_2);
        answer3 = (CheckBox) findViewById(R.id.answer_3);
        answer4 = (CheckBox) findViewById(R.id.answer_4);
        question = (TextView) findViewById(R.id.question);
        btnNext = (Button) findViewById(R.id.next);
        //Initializing variables
        mAnswer = new String[2];
        mscore = 0;
        progress = 0;
        checkBoxClicked = 0;
        nextQuestion = 0;
        //Calling method to update the question
        updateQuestion(nextQuestion);
        //Updating the score
        score.setText(getString(R.string.score, mscore));
        //On next button click this onClickListener method will check the answer and show the toast message
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.isChecked()) {
                    if (answer1.getText() == mAnswer[0] || answer1.getText() == mAnswer[1]) {
                        mCorrectAnswer.add(answer1.getText().toString());
                    }
                    checkBoxClicked++;
                }
                if (answer2.isChecked()) {
                    if (answer2.getText() == mAnswer[0] || answer2.getText() == mAnswer[1]) {
                        mCorrectAnswer.add(answer2.getText().toString());
                    }
                    checkBoxClicked++;
                }
                if (answer3.isChecked()) {
                    if (answer3.getText() == mAnswer[0] || answer3.getText() == mAnswer[1]) {
                        mCorrectAnswer.add(answer3.getText().toString());
                    }
                    checkBoxClicked++;
                }
                if (answer4.isChecked()) {
                    if (answer4.getText() == mAnswer[0] || answer4.getText() == mAnswer[1]) {
                        mCorrectAnswer.add(answer4.getText().toString());
                    }
                    checkBoxClicked++;
                }
                updateActivity();
            }
        });
    }

    private void updateQuestion(int n) {
        if (nextQuestion < mQuestionsLength) {
            nextQuestion++;
            question.setText(R.string.question_actors);
            image_actors_left.setImageResource(mImages.getImageLeft(n));
            image_actors_right.setImageResource(mImages.getImageRight(n));
            answer1.setText(mQuestions.getOption1(n));
            answer2.setText(mQuestions.getOption2(n));
            answer3.setText(mQuestions.getOption3(n));
            answer4.setText(mQuestions.getOption4(n));
            mAnswer[0] = mQuestions.getCorrectAnswer1(n);
            mAnswer[1] = mQuestions.getCorrectAnswer2(n);
        } else {
            gamecompleted();
        }
    }

    private void updateActivity() {
        if (checkBoxClicked == 2) {
            answer1.setChecked(false);
            answer2.setChecked(false);
            answer3.setChecked(false);
            answer4.setChecked(false);
            checkBoxClicked = 0;
            if (mCorrectAnswer.size() == 2) {
                mscore++;
                score.setText(getString(R.string.score, mscore));
                Toast.makeText(ActorsActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ActorsActivity.this, R.string.toast_wrong, Toast.LENGTH_SHORT).show();
            }
            mCorrectAnswer.clear();
            progress += 10;
            progressBar.setProgress(progress);
            updateQuestion(nextQuestion);
            scrollView.setScrollY(0);
        } else {
            checkBoxClicked = 0;
            mCorrectAnswer.clear();
            Toast toast = Toast.makeText(ActorsActivity.this, R.string.error_message_actors, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //This method will get called on quiz complition and show toast tosubmit the score
    private void gamecompleted() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ActorsActivity.this);
        alertDialogBuilder.setMessage(R.string.submit_score)
                .setCancelable(false)
                .setPositiveButton(R.string.btn_submit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Creating toast message to show the result of the quiz
                                Toast toast = Toast.makeText(ActorsActivity.this, getString(R.string.quiz_result, mQuestionsLength, mscore), Toast.LENGTH_LONG);
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
        outState.putBoolean("CHECKEDSTATE_ANSWER1", answer1.isChecked());
        outState.putBoolean("CHECKEDSTATE_ANSWER2", answer2.isChecked());
        outState.putBoolean("CHECKEDSTATE_ANSWER3", answer3.isChecked());
        outState.putBoolean("CHECKEDSTATE_ANSWER4", answer4.isChecked());
        outState.putString("ANSWER_1", (String) answer1.getText());
        outState.putString("ANSWER_2", (String) answer2.getText());
        outState.putString("ANSWER_3", (String) answer3.getText());
        outState.putString("ANSWER_4", (String) answer4.getText());
        outState.putStringArray("CORRECT_ANSWER", mAnswer);
        outState.putStringArrayList("CORRECT_ANSWER_LIST", mCorrectAnswer);
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
        answer1.setChecked(savedInstanceState.getBoolean("CHECKEDSTATE_ANSWER1"));
        answer2.setChecked(savedInstanceState.getBoolean("CHECKEDSTATE_ANSWER2"));
        answer3.setChecked(savedInstanceState.getBoolean("CHECKEDSTATE_ANSWER3"));
        answer4.setChecked(savedInstanceState.getBoolean("CHECKEDSTATE_ANSWER4"));
        image_actors_left.setImageResource(mImages.getImageLeft(nextQuestion - 1));
        image_actors_right.setImageResource(mImages.getImageRight(nextQuestion - 1));
        answer1.setText(savedInstanceState.getString("ANSWER_1"));
        answer2.setText(savedInstanceState.getString("ANSWER_2"));
        answer3.setText(savedInstanceState.getString("ANSWER_3"));
        answer4.setText(savedInstanceState.getString("ANSWER_4"));
        mAnswer = savedInstanceState.getStringArray("CORRECT_ANSWER");
        mCorrectAnswer = savedInstanceState.getStringArrayList("CORRECT_ANSWER_LIST");
    }
}
