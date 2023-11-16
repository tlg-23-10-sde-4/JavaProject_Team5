package io.trivia.client;


import io.trivia.Category;
import io.trivia.GameArt;
import io.trivia.QuestionService;
import io.trivia.app.GameHost;
import static java.lang.Thread.*;

import java.util.ArrayList;

import static io.trivia.Category.*;


public class Main {
	public static void main(String[] args) throws InterruptedException {


		GameArt art = new GameArt();
		art.loadTitle();
		art.run();

		GameHost a = new GameHost();
		a.welcomePrompt();




//		GameHost gameHost = new GameHost();
//		GameArt gameArt = new GameArt();
//		GameArt thread = new GameArt();
//		thread.gameName();
//		GameHost game = new GameHost();
	}
}