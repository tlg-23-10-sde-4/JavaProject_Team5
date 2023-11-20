package io.trivia.client;
import com.apps.util.Prompter;
import io.trivia.AsciiArt;
import io.trivia.app.GameHost;
import io.trivia.app.GameHost2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Prompter prompter = new Prompter(new Scanner(System.in));
		AsciiArt asciiArt = new AsciiArt();
		AsciiArt.loadTitle();

		String runAgain = "y";
		while(runAgain.equals("y")) {
			GameHost2 a = new GameHost2();
			a.startGame();
			runAgain = prompter.prompt("Press 'y' to play again, any other character to exit. ");
		}
	}
}
/*
todo: have "buttons" to select instead of typing answers in.
todo: refactor code to be more OO based.
todo: TEST
todo: incorporate ascii art when its finished.
todo: console.clear();
maybe: number categories and have user type in number for category
 */