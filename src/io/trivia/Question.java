package io.trivia;

public class Question {
    private final String body;
    private final String answer;

    public Question(String body, String answer) {
        this.body = getBody();
        this.answer = getAnswer();
    }

    public String getBody() {
        return body;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "body='" + getBody() + '\'' +
                ", answer='" + getAnswer() + '\'' +
                '}';
    }
}

