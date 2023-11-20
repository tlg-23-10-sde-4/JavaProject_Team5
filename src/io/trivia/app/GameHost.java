package io.trivia.app;

import com.apps.util.Prompter;
import io.trivia.AsciiArt;
import io.trivia.Category;
import io.trivia.Player;
import io.trivia.QuestionService;
import jdk.dynalink.beans.StaticClass;


import java.io.Console;
import java.lang.ref.Cleaner;
import java.security.PrivateKey;
import java.util.*;

import static io.trivia.AsciiArt.*;


public class GameHost {
	static AsciiArt asciiArt = new AsciiArt();
	
	public static void startGame() throws InterruptedException {
		promptName();
		String category = categoryPrompt();
		System.out.println("To play, answer with either 'True', or 'False'. ");
		playGame(category, asciiArt.getName());
	}
	
	private static void playGame(String category, String name) {
		Prompter prompter = new Prompter(new Scanner(System.in));
		Player player = new Player(name);
		HashSet <String> askedQuestions = new HashSet <>();
		
		int i = 0;
		while(true) {
			ArrayList <String> newQ;
			String question;
			
			do {
				newQ = QuestionService.newQuestion(Category.valueOf(category));
				question = newQ.get(0);
			}
			while(askedQuestions.contains(question));
			askedQuestions.add(question);
			
			String rightAns = newQ.get(1);
			ArrayList <String> wrongChoices = new ArrayList <>();
			HashSet <String> choices = new HashSet <>();
			
			for(int j = 1; j < 5; j++) {
				String temp;
				temp = newQ.get(j).toUpperCase(Locale.ROOT).trim();
				choices.add(temp);
			}
			
			for(int j = 2; j < 5; j++) {
				String temp;
				temp = newQ.get(j).toUpperCase(Locale.ROOT).trim();
				wrongChoices.add(temp);
			}
			
			while(true) {
				System.out.println("Player: " + player.getName() + "   score: " + player.getScore());
				System.out.println();
				System.out.println(question);
				choices.stream().forEach(System.out :: println);
				String userAnswer = prompter.prompt("");
				userAnswer = userAnswer.trim().toUpperCase(Locale.ROOT);
				rightAns = rightAns.trim().toUpperCase(Locale.ROOT);
				//choices = choices().toUpperCase(Locale.ROOT);
				if(userAnswer.equals(rightAns)) {
					System.out.println("You got it right!");
					System.out.println();
					player.incrementScore();
					break;
				}
				else if(wrongChoices.contains(userAnswer)) {
					System.out.println("You got it wrong :(");
					System.out.println("The correct answer was " + rightAns);
					System.out.println("THROW NEW EXCEPTION!!!!");
					break;
				}
			}
			i++;
			if(i == 9) {
				System.out.println("You got " + player.getScore() + " points out of 10!");
				break;
			}
		}
	}
	
	//todo: i put this inside asciiArt
/*	public String namePrompt() throws InterruptedException {
		String name = null;
		final String askName = "Hey there, whats your name? ";
		Prompter prompter = new Prompter(new Scanner(System.in));
		asciiArt.loadAscii();
		prompter.prompt(askName);
		return name = askName;
	}*/
	
	public static String categoryPrompt() {
		List <String> cats = Arrays.asList("ENTERTAINMENT", "SPORTS", "SCIENCE", "ANIMALS", "POLITICS", "GEOGRAPHY", "HISTORY");
		Prompter prompter = new Prompter(new Scanner(System.in));
		String category;
		while(true) {
			System.out.println(cats);
			category = prompter.prompt("Please choose a category: ");
			category = category.trim().toUpperCase(Locale.ROOT);
			if(cats.contains(category)) {
				return category;
			}
		}
	}
import io.trivia.Question;
import org.apache.commons.lang3.EnumUtils;
import java.util.*;

public class GameHost {

    public void startGame() {
        String name = namePromptPlayer1();
        String name2 = namePromptPlayer2();
        String category = categoryPrompt();
        Player player = new Player(name);
        Player player2 = new Player(name2);
        playGame(category, player, player2);
        endGameMessage(player, player2);
    }

    private void playGame(String category, Player player, Player player2) {
        HashSet<String> askedQuestions = new HashSet<>();
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
                System.out.println("To play, type in your answer.");
                return category;
            }
        }
    }

    public void endGameMessage(Player player, Player player2) {
        System.out.println(player.getName() + "'s score: " + player.getScore());
        System.out.println(player2.getName() + "'s score: " + player2.getScore());
        if(player.getScore() == player2.getScore()) {
            System.out.println("Tie game!!!");
        } else if(player.getScore() > player2.getScore()) {
            System.out.println(player.getName() + " wins!!!");
        } else {
            System.out.println(player2.getName() + " wins!!!");
        }
    }

}