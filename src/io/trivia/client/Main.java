package io.trivia.client;


import io.trivia.Category;
import io.trivia.AsciiArt;
import io.trivia.QuestionService;
import io.trivia.app.GameHost;
import static java.lang.Thread.*;

import io.trivia.app.GameHost;
import java.util.ArrayList;

import static io.trivia.Category.*;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		AsciiArt asciiArt = new AsciiArt();
		asciiArt.loadTitle();

		GameHost a = new GameHost();
		a.startGame();


		/*
		GAME ART ASCII -> START <-
		This will be the beginning of the Ascii screen animations starting with loadTitle.
		Next will outline the first frame to give a retro arcade start up.
		*/








	}

}