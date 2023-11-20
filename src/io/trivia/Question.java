package io.trivia;

import com.apps.util.Prompter;

import java.lang.reflect.Array;
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

            ArrayList<String> choices = (this.allChoicesRandom());
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ". " + choices.get(i));
            }

            int userChoice;
            while (true) {
                try {
                userChoice = Integer.parseInt(prompter.prompt("Your Answer (1-4): "));
                if (userChoice < 1 || userChoice > 4) {
                    System.out.println("Please enter a number between 1 and 4.");
                } else {
                    break;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        }
            String selectedAnswer = (String) choices.get(userChoice - 1);
            if (selectedAnswer.equals(this.getAnswer())) {
                System.out.println();
                System.out.println("You got it right!");
                System.out.println();
                player.incrementScore();
                break;
            } else {
                System.out.println();
                System.out.println("You got it wrong :(");
                System.out.println("The correct answer was " + this.getAnswer());
                System.out.println();
                System.out.println("THROW NEW EXCEPTION!!!!");
                System.out.println();
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