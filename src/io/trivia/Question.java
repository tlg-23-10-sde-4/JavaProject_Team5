package io.trivia;

import com.apps.util.Prompter;

import java.util.*;

public class Question {
    private final String body;
    private final String answer;
    private final String wrongChoice1;
    private final String wrongChoice2;
    private final String wrongChoice3;

    public Question(ArrayList<String> question) {
        this.body = question.get(0);
        this.answer = question.get(1).toUpperCase(Locale.ROOT).trim();
        this.wrongChoice1 = question.get(2).toUpperCase(Locale.ROOT).trim();
        this.wrongChoice2 = question.get(3).toUpperCase(Locale.ROOT).trim();
        this.wrongChoice3 = question.get(4).toUpperCase(Locale.ROOT).trim();
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

    public void askQuestionDisplay(Player player) {
        Prompter prompter = new Prompter(new Scanner(System.in));
        while (true) {
            System.out.println("Player: " + player.getName() + "   score: " + player.getScore());
            System.out.println();
            System.out.println(this.getBody());
            System.out.println(this.allChoicesRandom());
            String userAnswer = prompter.prompt("");
            userAnswer = userAnswer.trim().toUpperCase(Locale.ROOT);
            if (userAnswer.equals(this.getAnswer())) {
                System.out.println("You got it right!");
                System.out.println();
                player.incrementScore();
                break;
            } else if (this.wrongChoices().contains(userAnswer)) {
                System.out.println("THROW NEW EXCEPTION!!!!");
                System.out.println("You got it wrong :(");
                System.out.println("The correct answer was " + this.getAnswer());
                break;
            }
        }
    }

    public static void askQuestionOps(HashSet<String> askedQuestions, Player player, Player player2, String category) {
        boolean player1Turn = true;
        for (int i = 0; i < 10; i++) {
            if (player1Turn == true) {
                System.out.println(player.getName() + "'s " + "turn");
                // asks question while making sure duplicate question isn't asked.
                ArrayList<String> newQ;
                String body;
                do {
                    newQ = QuestionService.newQuestion(Category.valueOf(category));
                    body = newQ.get(0);
                } while (askedQuestions.contains(body));
                askedQuestions.add(body);

                Question question = new Question(newQ);
                question.askQuestionDisplay(player);
                player1Turn = false;
            } else {
                System.out.println(player2.getName() + "'s " + "turn");
                // asks question while making sure duplicate question isn't asked.
                ArrayList<String> newQ;
                String body;
                do {
                    newQ = QuestionService.newQuestion(Category.valueOf(category));
                    body = newQ.get(0);
                } while (askedQuestions.contains(body));
                askedQuestions.add(body);

                Question question = new Question(newQ);
                question.askQuestionDisplay(player2);
                player1Turn = true;
            }
        }
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

    @Override
    public String toString() {
        return "Question{" +
                "body='" + body + '\'' +
                ", answer='" + answer + '\'' +
                ", wrongChoice1='" + wrongChoice1 + '\'' +
                ", wrongChoice2='" + wrongChoice2 + '\'' +
                ", wrongChoice3='" + wrongChoice3 + '\'' +
                '}';
    }
}