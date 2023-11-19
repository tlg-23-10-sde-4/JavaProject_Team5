package io.trivia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Question {
    private final String body;
    private final String answer;
    private final String wrongChoice1;
    private final String wrongChoice2;
    private final String wrongChoice3;
    private final String id;

    public Question(ArrayList<String> question) {
        this.body = question.get(0);
        this.answer = question.get(1).toUpperCase(Locale.ROOT).trim();
        this.wrongChoice1 = question.get(2).toUpperCase(Locale.ROOT).trim();
        this.wrongChoice2 = question.get(3).toUpperCase(Locale.ROOT).trim();
        this.wrongChoice3 = question.get(4).toUpperCase(Locale.ROOT).trim();
        this.id = question.get(5);
    }

    // returns arraylist of all randomized choices
    public ArrayList<String> allChoicesRandom() {
        ArrayList<String> randomizedChoices = new ArrayList<>();
        randomizedChoices.add(getAnswer());
        randomizedChoices.add(getWrongChoice1());
        randomizedChoices.add(getWrongChoice2());
        randomizedChoices.add(getWrongChoice3());
        Collections.shuffle(randomizedChoices);
        return randomizedChoices;
    }

    public ArrayList<String> wrongChoices() {
        ArrayList<String> wrongChoicesArray = new ArrayList<>();
        wrongChoicesArray.add(getWrongChoice1());
        wrongChoicesArray.add(getWrongChoice2());
        wrongChoicesArray.add(getWrongChoice3());
        return wrongChoicesArray;
    }

    public String getBody() {
        return body;
    }

    public String getAnswer() {
        return answer;
    }

    public String getWrongChoice1() {
        return wrongChoice1;
    }

    public String getWrongChoice2() {
        return wrongChoice2;
    }

    public String getWrongChoice3() {
        return wrongChoice3;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "body='" + getBody() + '\'' +
                ", answer='" + getAnswer() + '\'' +
                '}';
    }
}