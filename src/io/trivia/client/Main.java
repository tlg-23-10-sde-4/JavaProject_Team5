package io.trivia.client;
import com.apps.util.Prompter;
import io.trivia.AsciiArt;
import io.trivia.app.GameHost;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		Prompter prompter = new Prompter(new Scanner(System.in));
		AsciiArt asciiArt = new AsciiArt();
		AsciiArt.loadTitle();

		String runAgain = "y";
		while(runAgain.equals("y")) {
			GameHost a = new GameHost();
			a.startGame();
			runAgain = prompter.prompt("Press 'y' to play again, any other character to exit. ");
		}

	}

}