package com.example.android.quizapp;

public class QuestionsAndroid {
    public String[] mQuestions = {
            "Which company developed android?",
            "Android is based on which kernel?",
            "Android provides a few standard themes, listed in__________",
            "ADB stands for?",
            "To insert data into a content provider, you need to use______\n\n1)insert() \n2)bulkInsert() \n3)getContentProvider() \n4)update()",
            "Which of the following(s) is/are component of APK file?",
            "In ___________, sender specifies type of receiver.",
            "Which of the following don’t have any UI component and run as a background process?",
            "If you want to increase the whitespace between widgets, you will need to use the ____________ property",
            "To update contents of content provider using curser and commit you need to call________"
    };

    private String[][] mOptions = {
            {"Apple", "Google", "Android Inc.", "Nokia",},
            {"Linux kernel", "Windows kernel", "MAC kernel", "Hybrid Kernel",},
            {"X.style", "R.style", "menifeest.XML", "application",},
            {"Application data bridge", "Android data bridge", "Android Debug Bridge", "Application Debug Bridge",},
            {"1 and 2", "3 and 4", "all of the above", "none of these",},
            {"Resources", "Delvik Executable", "both a and b", "none of above",},
            {"Explicit intent", "Implicit intent", "a and b", "none of these"},
            {"services", "simulator", "Emulator", "none of these",},
            {"Android:margin", "Android:autoText", "Android:padding", "Android:digits",},
            {"updates()", "commitUpdates()", "commit()", "none of these",},
    };

    private String[] mCorrectAnswers = {"Android Inc.", "Linux kernel", "R.style", "Android Debug Bridge", "1 and 2", "both a and b",
            "Implicit intent", "services", "Android:padding", "commitUpdates()"};

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
