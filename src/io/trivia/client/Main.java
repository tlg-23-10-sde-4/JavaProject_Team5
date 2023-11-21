package io.trivia.client;

import com.apps.util.Console;
import com.apps.util.Prompter;
import io.trivia.AsciiArt;

import io.trivia.app.GameHost;


import java.io.Reader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Prompter prompter = new Prompter(new Scanner(System.in));
		AsciiArt ascii = new AsciiArt();
		ascii.loadingBar();
		ascii.run();
		
		String runAgain = "y";
		while(runAgain.equals("y")) {
			GameHost a = new GameHost();
			a.startGame();
			runAgain = prompter.prompt("Press 'y' to play again, any other character to exit. ");
			
		}
	}
=======
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AsciiArt ascii = new AsciiArt();
        ascii.loadAscii();
        GameHost a = new GameHost();
        a.startGame();
    }

}
/*
todo: console.clear();
maybe: number categories and have user type in number for category
 */