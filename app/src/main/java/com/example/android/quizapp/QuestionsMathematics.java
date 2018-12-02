package com.example.android.quizapp;

public class QuestionsMathematics {
    public String[] mQuestions = {
            "A whole number greater than 1 whose only factors are 1 and itself is called _____ \n" + "(A factor is a whole numbers that can be divided evenly into another number.)",
            "Which number is missing? 1, 9, 25, 49, (?)",
            "A clock strikes once at 1 o’clock, twice at 2 o’clock, thrice at 3 o’clock and so on. How many times will it strike in 24 hours?",
            "125 gallons of a mixture contains 20% water. What amount of additional water should be added such that water content be raised to 25%?",
            "The simplest form of 1.5 : 2.5 is …………… .",
            "What percentage should be added to 40 to make it 50?",
            "Which is the smallest fraction among the following?",
            "The number which is neither prime nor composite is ……",
            "A car can cover a distance of 522 km on 36 liters of petrol. How far can it travel on 14 liters of petrol?",
            "Two numbers are in ratio 4 : 5. If the sum of the numbers is 135, find the numbers."
    };

    private String[][] mOptions = {
            {"whole", "prime", "integer", "rational",},
            {"121", "81", "16", "169",},
            {"78", "136", "156", "196",},
            {"15/2 gallons", "17/2 gallons", "19/2 gallons", "81/3 gallons",},
            {"6 : 10", "15 : 25", "0.75 : 1.25", "3 : 5",},
            {"25", "15", "75", "80",},
            {"6/5", "2/3", "6/7", "3/4",},
            {"0", "1", "3", "2",},
            {"213 km.", "223 km.", "203 km.", "302 km.",},
            {"60 and 75", "70 and 65", "42 and 93", "55 and 80",},
    };

    private String[] mCorrectAnswers = {"prime", "81", "156", "81/3 gallons", "3 : 5", "25", "3/4", "1", "203 km.", "60 and 75"};

    public String getQuestion(int i) {
        String question = mQuestions[i];
        return question;
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
