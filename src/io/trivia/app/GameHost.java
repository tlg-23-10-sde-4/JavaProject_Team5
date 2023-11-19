package io.trivia.app;

import com.apps.util.Prompter;
import io.trivia.Category;
import io.trivia.Player;
import io.trivia.QuestionService;
import org.apache.commons.lang3.EnumUtils;

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
        HashSet<String> askedQuestions = new HashSet<>(); // used to make sure same question isn't asked twice in a game.

        int i = 0;
        while (true) {
            // asks question while making sure duplicate question isn't asked.
            ArrayList<String> newQ;
            String question;

            do {
                newQ = QuestionService.newQuestion(Category.valueOf(category));
                question = newQ.get(0);
            } while (askedQuestions.contains(question));
            askedQuestions.add(question);
            //

            // initializes answer choices (all, right, wrong)
            String rightAns = newQ.get(1);
            ArrayList<String> wrongChoices = new ArrayList<>();
            HashSet<String> choices = new HashSet<>();
            //

            // adds ALL choices to choices hashset
            for (int j = 1; j < 5; j++) {
                String temp;
                temp = newQ.get(j).toUpperCase(Locale.ROOT).trim();
                choices.add(temp);
            }
            //

            //  adds wrong choices to wrongChoices arraylist
            for (int j = 2; j < 5; j++) {
                String temp;
                temp = newQ.get(j).toUpperCase(Locale.ROOT).trim();
                wrongChoices.add(temp);
            }
            //

            while (true) {
                System.out.println("Player: " + player.getName() + "   score: " + player.getScore());
                System.out.println();
                System.out.println(question);
                choices.stream().forEach(System.out::println);
                String userAnswer = prompter.prompt("");
                userAnswer = userAnswer.trim().toUpperCase(Locale.ROOT);
                rightAns = rightAns.trim().toUpperCase(Locale.ROOT);
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
        Prompter prompter = new Prompter(new Scanner(System.in));
        String category;
        while (true) {
            for(Category cat: Category.values()) {
                System.out.println(cat);
            }
            category = prompter.prompt("Please choose a category: ");
            category = category.trim().toUpperCase(Locale.ROOT);
            if (EnumUtils.isValidEnum(Category.class, category)) {
                return category;
            }
        }
    }
}