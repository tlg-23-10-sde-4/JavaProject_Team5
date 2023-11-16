package io.trivia.app;

import com.apps.util.Prompter; // Jays Prompter Class

import java.util.Scanner;

public class GameApp {
	Prompter prompter = new Prompter(new Scanner(System.in));

	// place into methods
	public String name = prompter.prompt("Hello, to load the game please enter your name: ");

	public final String loadScreen =(String.format(	"Hello %s! Are you ready to play Big Tech? or Small Package?" +
													" Enter (Y) to begin or (Q) to exit the game.", getName()));

	public String play = prompter.prompt	("(Y) to play"); // plan on making a boolean variable for (Y)
	public String exit = prompter.prompt	("(Q) to exit"); // plan on making a boolean variable for (Q)
	public String choice = prompter.prompt	("True or False: ");
	/* thinking about adding a button for true or false because everything in the console
	 * is returned as text and maybe clicking a button we can attach a boolean expression
	 * to it with listener */ // button idea

	public GameApp(){
		// variables automatically called
	}

	public String getPlay() {
		return play;
	}

	public String getExit()  {
		return exit;
	}

	public String getChoice() {
		return choice;
	}

	public String getName() {
		return name;
	}

	public String getLoadScreen() {
		return loadScreen;
	}

}