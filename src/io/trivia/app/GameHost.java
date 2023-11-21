package io.trivia.app;

import com.apps.util.Console;
import com.apps.util.Prompter;
import io.trivia.AsciiArt;
import io.trivia.Player;
import io.trivia.Question;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class GameHost {
	Console console;
	public void startGame() {
		Prompter prompter = new Prompter(new Scanner(System.in));
		String runAgain = "Y";
		while(runAgain.equals("Y")) {
			String name = namePromptPlayer1();
			String name2 = namePromptPlayer2();
			String category = Question.getCategoryFromUserInput();
			Player player = new Player(name);
			Player player2 = new Player(name2);
			playGame(category, player, player2);
			endGameMessage(player, player2);
			String runAgainInput = prompter.prompt("Press 'Y' to play again, any other character to exit. ");
			runAgain = runAgainInput.toUpperCase(Locale.ROOT);
		}
	}
	
	private void playGame(String category, Player player, Player player2) {
		Set <String> askedQuestions = new HashSet <>();
		Question.askQuestionOps(askedQuestions, player, player2, category);
	}
	
	public String namePromptPlayer1() {
		Prompter prompter = new Prompter(new Scanner(System.in));
		Console.blankLines(1);
		return prompter.prompt("️ ░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓  PLAYER 1 Enter your name: ");
	}
	
	public String namePromptPlayer2() {
		Prompter prompter = new Prompter(new Scanner(System.in));
		Console.blankLines(1);
		return prompter.prompt("️ ░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓  PLAYER 2 Enter your name: ");
	}
	
	public void endGameMessage(Player player, Player player2) {
		System.out.println(player.getName() + "'s score: " + player.getScore());
		System.out.println(player2.getName() + "'s score: " + player2.getScore());
		if(player.getScore() == player2.getScore()) {
			System.out.println("Tie game!!!");
		}
		else if(player.getScore() > player2.getScore()) {
			System.out.println(player.getName() + " Is the winner!");
		}
		else {
			System.out.println(player2.getName() + " Is the winner!");
		}
	}
}