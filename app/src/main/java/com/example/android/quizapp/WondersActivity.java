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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class WondersActivity extends AppCompatActivity {
    // Creating variables
    private ScrollView scrollView;
    private ProgressBar progressBar;
    private TextView question;
    private ImageView image_wonders;
    private TextView score;
    private RadioGroup radioGroupAnswers;
    private RadioButton answerSelected;
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private RadioButton answer4;
    private Button btnNext;
    private QuestionsWonders mQuestions = new QuestionsWonders();
    private QuestionsWonders mImages = new QuestionsWonders();
    private String mAnswer;
    private int mscore;
    private int mQuestionsLength = mQuestions.mQuestions.length;
    private int progress;
    private int nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);
        scrollView = (ScrollView) findViewById(R.id.scrollview);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        question = (TextView) findViewById(R.id.question);
        image_wonders = (ImageView) findViewById(R.id.image_wonders);
        score = (TextView) findViewById(R.id.score);
        radioGroupAnswers = (RadioGroup) findViewById(R.id.radio);
        answer1 = (RadioButton) findViewById(R.id.answer_1);
        answer2 = (RadioButton) findViewById(R.id.answer_2);
        answer3 = (RadioButton) findViewById(R.id.answer_3);
        answer4 = (RadioButton) findViewById(R.id.answer_4);
        btnNext = (Button) findViewById(R.id.next);
        //Initializing variables
        mscore = 0;
        progress = 0;
        nextQuestion = 0;
        //Calling method to update the question
        updateQuestion(nextQuestion);
        //Updating the score
        score.setText(getString(R.string.score, mscore));
        //On next button click this onClickListener method will check the answer and show the toast message
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupAnswers.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast toast = Toast.makeText(WondersActivity.this, R.string.error_message, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    answerSelected = (RadioButton) findViewById(selectedId);
                    if (answerSelected.getText() == mAnswer) {
                        Toast.makeText(WondersActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
                        mscore++;
                        score.setText(getString(R.string.score, mscore));
                    } else {
                        Toast.makeText(WondersActivity.this, R.string.toast_wrong, Toast.LENGTH_SHORT).show();
                    }
                    progress += 10;
                    progressBar.setProgress(progress);
                    updateQuestion(nextQuestion);
                    radioGroupAnswers.clearCheck();
                    scrollView.setScrollY(0);
                }
            }
        });
    }

    private void updateQuestion(int n) {
        if (nextQuestion < mQuestionsLength) {
            nextQuestion++;
            question.setText(mQuestions.getQuestion(n));
            image_wonders.setImageResource(mImages.getImage(n));
            answer1.setText(mQuestions.getOption1(n));
            answer2.setText(mQuestions.getOption2(n));
            answer3.setText(mQuestions.getOption3(n));
            answer4.setText(mQuestions.getOption4(n));
            mAnswer = mQuestions.getCorrectAnswer(n);
        } else {
            gamecompleted();
        }
    }

    //This method will get called on quiz complition and show toast tosubmit the score
    private void gamecompleted() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(WondersActivity.this);
        alertDialogBuilder.setMessage(R.string.submit_score)
                .setCancelable(false)
                .setPositiveButton(R.string.btn_submit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Creating toast message to show the result of the quiz
                                Toast toast = Toast.makeText(WondersActivity.this, getString(R.string.quiz_result, mQuestionsLength, mscore), Toast.LENGTH_LONG);
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
        outState.putInt("ANSWER_SELECTED", radioGroupAnswers.getCheckedRadioButtonId());
        outState.putString("QUESTION", (String) question.getText());
        outState.putString("ANSWER_1", (String) answer1.getText());
        outState.putString("ANSWER_2", (String) answer2.getText());
        outState.putString("ANSWER_3", (String) answer3.getText());
        outState.putString("ANSWER_4", (String) answer4.getText());
        outState.putString("CORRECT_ANSWER", mAnswer);
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
        if (savedInstanceState.getInt("ANSWER_SELECTED") != -1) {
            answerSelected = (RadioButton) findViewById(savedInstanceState.getInt("ANSWER_SELECTED"));
            answerSelected.setChecked(true);
        }
        mscore = savedInstanceState.getInt("SCORE");
        score.setText(getString(R.string.score, mscore));
        question.setText(savedInstanceState.getString("QUESTION"));
        image_wonders.setImageResource(mImages.getImage(nextQuestion - 1));
        answer1.setText(savedInstanceState.getString("ANSWER_1"));
        answer2.setText(savedInstanceState.getString("ANSWER_2"));
        answer3.setText(savedInstanceState.getString("ANSWER_3"));
        answer4.setText(savedInstanceState.getString("ANSWER_4"));
        mAnswer = savedInstanceState.getString("CORRECT_ANSWER");
    }
}
