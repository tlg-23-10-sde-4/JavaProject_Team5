package io.trivia.client;


import io.trivia.AsciiArt;
import io.trivia.app.GameHost;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		AsciiArt ascii = new AsciiArt();
		GameHost a = new GameHost();
		ascii.loadingBar();
		ascii.run();
		a.startGame();
	}
}
/*
todo: console.clear();
maybe: number categories and have user type in number for category
 */