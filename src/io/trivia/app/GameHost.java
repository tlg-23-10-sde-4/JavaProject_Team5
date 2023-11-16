package io.trivia.app;


import com.apps.util.Prompter; // Jays Prompter Class

import java.util.*;

public class GameHost {


	List<String> cats = Arrays.asList("ENTERTAINMENT", "SPORTS", "SCIENCE", "ANIMALS", "POLITICS", "GEOGRAPHY", "HISTORY");


	public void startGame() {
		String name = namePrompt();
		String category = categoryPrompt();
	}

	public String namePrompt () {
		Prompter prompter = new Prompter(new Scanner(System.in));
		String name = prompter.prompt("Please enter your name: ");
		return name;

	public void welcomePrompt () {
		Prompter prompter = new Prompter(new Scanner(System.in));
		String name = prompter.prompt("Please enter your name: ");
		System.out.println("The game categories are: " );
	}

	public String categoryPrompt() {
		Prompter prompter = new Prompter(new Scanner(System.in));
		String category;
		while (true) {
			System.out.println(cats);
			category = prompter.prompt("Please choose a category: ");
			category = category.trim().toUpperCase(Locale.ROOT);
			if (cats.contains(category)) {
				//System.out.println(category); // test
				return category;
			}
		}
	}


//	Prompter prompter = new Prompter(new Scanner(System.in));
//
//	// place into methods
//	public String name = prompter.prompt("Hello, to load the game please enter your name: ");
//
//	public final String loadScreen =(String.format(	"Hello %s! Are you ready to play Big Tech? or Small Package?" +
//													" Enter (Y) to begin or (Q) to exit the game.", getName()));
//
//	public String play = prompter.prompt	("(Y) to play"); // plan on making a boolean variable for (Y)
//	public String exit = prompter.prompt	("(Q) to exit"); // plan on making a boolean variable for (Q)
//	public String choice = prompter.prompt	("True or False: ");
//	/* thinking about adding a button for true or false because everything in the console
//	 * is returned as text and maybe clicking a button we can attach a boolean expression
//	 * to it with listener */ // button idea
//
//	public GameHost(){
//		// variables automatically called
//	}
//
//	public String getPlay() {
//		return play;
//	}
//
//	public String getExit()  {
//		return exit;
//	}
//
//	public String getChoice() {
//		return choice;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public String getLoadScreen() {
//		return loadScreen;
//	}

}


/*
 * game host logic:
 * prompt user for name and category
 * starts game, user name and their score is always displayed like a "scoreboard"
 * ask user question, they answer with true or false.
 * message saying if they were right or not.
 * score is increased (or not)
 * another question is asked
 * after the final (10?) question is asked, show message displaying their score.
 *
 */
