package io.trivia.app;


import com.apps.util.Prompter;
import io.trivia.Category;
import io.trivia.Player;
import io.trivia.QuestionService;

import java.util.*;

public class GameHost {


    public void startGame() {
        String name = namePrompt();
        String category = categoryPrompt();
        System.out.println("To play, answer with either 'True', or 'False'. ");
        playGame(category, name);
    }

    private void playGame(String category, String name) {
        Prompter prompter = new Prompter(new Scanner(System.in));
        Player player = new Player(name);
        HashSet<String> askedQuestions = new HashSet<>();

        int i = 0;
        while (true) {
            ArrayList<String> newQ;
            String question;

            do {
                newQ = QuestionService.newQuestion(Category.valueOf(category));
                question = newQ.get(0);
            } while (askedQuestions.contains(question));
            askedQuestions.add(question);

            String rightAns = newQ.get(1);
            ArrayList<String> wrongChoices = new ArrayList<>();
            HashSet<String> choices = new HashSet<>();

            for (int j = 1; j < 5; j++) {
                String temp;
                temp = newQ.get(j).toUpperCase(Locale.ROOT).trim();
                choices.add(temp);
            }

            for (int j = 2; j < 5; j++) {
                String temp;
                temp = newQ.get(j).toUpperCase(Locale.ROOT).trim();
                wrongChoices.add(temp);
            }

            while (true) {
                System.out.println("Player: " + player.getName() + "   score: " + player.getScore());
                System.out.println();
                System.out.println(question);
                choices.stream().forEach(System.out::println);
                String userAnswer = prompter.prompt("");
                userAnswer = userAnswer.trim().toUpperCase(Locale.ROOT);
                rightAns = rightAns.trim().toUpperCase(Locale.ROOT);
                //choices = choices().toUpperCase(Locale.ROOT);
                if (userAnswer.equals(rightAns)) {
                    System.out.println("You got it right!");
                    System.out.println();
                    player.incrementScore();
                    break;
                } else if (wrongChoices.contains(userAnswer)) {
                    System.out.println("You got it wrong :(");
                    System.out.println("The correct answer was " + rightAns);
                    System.out.println("THROW NEW EXCEPTION!!!!");
                    break;
                }
            }
            i++;
            if (i == 9) {
                System.out.println("You got " + player.getScore() + " points out of 10!");
                break;
            }
        }
    }


    public String namePrompt() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        return prompter.prompt("Please enter your name: ");
    }

    public String categoryPrompt() {
        List<String> cats = Arrays.asList("ENTERTAINMENT", "SPORTS", "SCIENCE", "ANIMALS", "POLITICS", "GEOGRAPHY", "HISTORY");
        Prompter prompter = new Prompter(new Scanner(System.in));
        String category;
        while (true) {
            System.out.println(cats);
            category = prompter.prompt("Please choose a category: ");
            category = category.trim().toUpperCase(Locale.ROOT);
            if (cats.contains(category)) {
                return category;
            }
        }
    }
}




/*
 * game host logic:
 * prompt user for name and category
 * starts game, user name and their score is always displayed like a "scoreboard"
 * ask user question, they answer with true or false.
 * message saying if they were right or not.
 * score is increased (or not)
 * another question is asked
 * after the final (10?) question is asked, show message displaying their score.
 *
 */
