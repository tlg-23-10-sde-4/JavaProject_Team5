package io.trivia.client;

import io.trivia.AsciiArt;
import io.trivia.app.GameHost;

public class Main {
	public static void main(String[] args) {
		AsciiArt ascii = new AsciiArt();
		GameHost a = new GameHost();
		ascii.loadingBar();
		ascii.run();
		a.startGame();
	}
}