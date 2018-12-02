package com.example.android.quizapp;

public class QuestionsActors {
    public int[] mImagesLeft = {
            R.drawable.amitabhbachchan,
            R.drawable.abhishekbachchan,
            R.drawable.dwaynejohnson,
            R.drawable.hrithikroshan,
            R.drawable.akshaykumar,
            R.drawable.johnnydepp,
            R.drawable.priyankachopra,
            R.drawable.leonardo,
            R.drawable.mattdamon,
            R.drawable.amirkhan,
    };

    public int[] mImagesRight = {
            R.drawable.anupamkher,
            R.drawable.aishwaryarai,
            R.drawable.willsmith,
            R.drawable.katrinakaif,
            R.drawable.kareenakapoor,
            R.drawable.penelopecruz,
            R.drawable.deepikapadukon,
            R.drawable.natalieportman,
            R.drawable.charlizetheron,
            R.drawable.ranimukerji,
    };

    private String[][] mOptions = {
            {"Amitabh Bachchan", "Anupam Kher", "George Clooney", "Gerard Butler"},
            {"Akshay Kumar", "Abhishek Bachchan", "Rani Mukerji", "Aishwarya Rai"},
            {"Will Smith", "Tom Cruise", "Dwayne Johnson", "Leonardo DiCaprio"},
            {"Hrithik Roshan", "Mark Wahlberg", "Megan Fox", "Katrina Kaif"},
            {"John Abraham", "Kareena Kapoor", "Akshay Kumar", "Karisma Kapoor"},
            {"Penelope Cruz", "Mila Kunis", "Johnny Depp", "Brad Pitt"},
            {"Deepika Padukone", "Priyanka Chopra", "Jacqueline Fernandez", "Rani Mukerji"},
            {"Mila Kunis", "Mark Wahlberg", "Leonardo DiCaprio", "Natalie Portman"},
            {"Katrina Kaif", "Charlize Theron", "Matt Damon", "Hrithik Roshan"},
            {"Preity Zinta", "Salman Khan", "Aamir Khan", "Rani Mukerji"},
    };

    private String[][] mCorrectAnswers = {{"Amitabh Bachchan", "Anupam Kher"}, {"Abhishek Bachchan", "Aishwarya Rai"},
            {"Dwayne Johnson", "Will Smith"}, {"Hrithik Roshan", "Katrina Kaif"}, {"Akshay Kumar", "Kareena Kapoor"},
            {"Johnny Depp", "Penelope Cruz"}, {"Priyanka Chopra", "Deepika Padukone"}, {"Leonardo DiCaprio", "Natalie Portman"},
            {"Matt Damon", "Charlize Theron"}, {"Aamir Khan", "Rani Mukerji"}};

    public int getImageLeft(int i) {
        int image = mImagesLeft[i];
        return image;
    }

    public int getImageRight(int i) {
        int image = mImagesRight[i];
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

    public String getCorrectAnswer1(int i) {
        String answer = mCorrectAnswers[i][0];
        return answer;
    }

    public String getCorrectAnswer2(int i) {
        String answer = mCorrectAnswers[i][1];
        return answer;
    }
}
