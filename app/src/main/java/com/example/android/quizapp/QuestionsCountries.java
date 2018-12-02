package com.example.android.quizapp;

public class QuestionsCountries {
    public int[] mImages = {
            R.drawable.india,
            R.drawable.unitedkingdom,
            R.drawable.mexico,
            R.drawable.russia,
            R.drawable.china,
            R.drawable.unitedstates,
            R.drawable.brazil,
            R.drawable.france,
            R.drawable.australia,
            R.drawable.canada,
    };

    private String[] mCorrectAnswers = {"India", "UK", "Mexico", "Russia", "China", "US", "Brazil", "France", "Australia", "Canada"};

    public int getImage(int i) {
        int image = mImages[i];
        return image;
    }

    public String getCorrectAnswer(int i) {
        String answer = mCorrectAnswers[i];
        return answer;
    }
}
