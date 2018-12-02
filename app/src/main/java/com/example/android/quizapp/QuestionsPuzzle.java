package com.example.android.quizapp;

public class QuestionsPuzzle {
    public int[] mImages = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
    };

    private String[][] mOptions = {
            {"80", "32", "40", "22"},
            {"226", "452", "565", "339"},
            {"40", "30", "53", "60"},
            {"6", "4", "3", "5"},
            {"7", "9", "10", "8"}
    };

    private String[] mCorrectAnswers = {"32", "565", "40", "5", "9"};

    public int getImage(int i) {
        int image = mImages[i];
        return image;
    }

    public String getOption1(int i) {
        String Option = mOptions[i][0];
        return Option;
    }

    public String getOption2(int i) {
        String Option = mOptions[i][1];
        return Option;
    }

    public String getOption3(int i) {
        String Option = mOptions[i][2];
        return Option;
    }

    public String getOption4(int i) {
        String Option = mOptions[i][3];
        return Option;
    }

    public String getCorrectAnswer(int i) {
        String answer = mCorrectAnswers[i];
        return answer;
    }
}
