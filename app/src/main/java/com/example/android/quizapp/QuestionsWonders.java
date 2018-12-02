package com.example.android.quizapp;

public class QuestionsWonders {
    public String[] mQuestions = {
            "What is the name of this wonder of the world?",
            "How long is the Great Wall of China?",
            "In which country this wonder is located??",
            "What is the rank of this wonder of the world?",
            "How many steps are there in El Castillo pyramid?",
            "The mountain Machu Picchu, located about ______ above sea level?",
            "who constructed this wonder of the world?"
    };

    public int[] mImages = {
            R.drawable.pyramid,
            R.drawable.greatwallofchina,
            R.drawable.petra,
            R.drawable.thecolosseum,
            R.drawable.chichenitza,
            R.drawable.machupicchu,
            R.drawable.tajmahal,
    };
    public String[] mCorrectAnswers = {"Great Pyramid of Giza", "21.19618 million metres", "Jordan", "4", "91", "2,430 metres", "Shah Jahan"};
    private String[][] mOptions = {
            {"Great Pyramid of Giza", "Pyramid of Meidum", "Bent Pyramid", "Red Pyramid",},
            {"19.46283 million metres", "25.28712 million metres", "21.19618 million metres", "18.21434 million metres",},
            {"Lebanon", "Alexandria", "Turkey", "Jordan",},
            {"4", "2", "5", "7",},
            {"71", "87", "91", "113",},
            {"1,570 metres", "2,430 metres", "3,140 metres", "2,590 metres",},
            {"Chhatrapati Shivaji", "Aurangzeb", "Akbar", "Shah Jahan",}
    };

    public String getQuestion(int i) {
        String question = mQuestions[i];
        return question;
    }

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
        String answear = mCorrectAnswers[i];
        return answear;
    }
}
