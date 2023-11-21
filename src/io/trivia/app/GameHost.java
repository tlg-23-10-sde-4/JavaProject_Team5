package io.trivia.app;

import com.apps.util.Prompter;
import io.trivia.Category;
import io.trivia.Player;
import io.trivia.Question;
import org.apache.commons.lang3.EnumUtils;

import java.util.*;

public class GameHost {

    public void startGame() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        String runAgain = "y";
        while (runAgain.equals("y")) {
            String name = namePromptPlayer1();
            String name2 = namePromptPlayer2();
            String category = Question.getCategoryFromUserInput();
            Player player = new Player(name);
            Player player2 = new Player(name2);
            playGame(category, player, player2);
            endGameMessage(player, player2);
            runAgain = prompter.prompt("Press 'y' to play again, any other character to exit. ");
        }
    }

    private void playGame(String category, Player player, Player player2) {
        Set<String> askedQuestions = new HashSet<>();
        Question.askQuestionOps(askedQuestions, player, player2, category);
    }

    public String namePromptPlayer1() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        return prompter.prompt("Player 1 please enter your name: ");
    }

    public String namePromptPlayer2() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        return prompter.prompt("Player 2 please enter your name: ");
    }

//    public String categoryPrompt() {
//        Prompter prompter = new Prompter(new Scanner(System.in));
//        String category;
//        while (true) {
//            for (Category cat : Category.values()) {
//                System.out.println(cat);
//            }
//            category = prompter.prompt("Please choose a category: ");
//            category = category.trim().toUpperCase(Locale.ROOT);
//            if (EnumUtils.isValidEnum(Category.class, category)) {
//                System.out.println("To play, type in your answer.");
//                return category;
//            }
//        }
//    }

    public void endGameMessage(Player player, Player player2) {
        System.out.println(player.getName() + "'s score: " + player.getScore());
        System.out.println(player2.getName() + "'s score: " + player2.getScore());
        if (player.getScore() == player2.getScore()) {
            System.out.println("Tie game!!!");
        } else if (player.getScore() > player2.getScore()) {
            System.out.println(player.getName() + " wins!!!");
        } else {
            System.out.println(player2.getName() + " wins!!!");
        }
    }
}