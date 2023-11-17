package io.trivia.app;


import com.apps.util.Prompter; // Jays Prompter Class
import io.trivia.Category;
import io.trivia.Player;
import io.trivia.Question;
import io.trivia.QuestionService;

import java.util.*;

public class GameHost {
	List<String> cats = Arrays.asList("ENTERTAINMENT", "SPORTS", "SCIENCE", "ANIMALS", "POLITICS", "GEOGRAPHY", "HISTORY");


/*	public void startGame() {
		String name = namePrompt();
		String category = categoryPrompt();
	}

	public String namePrompt () {
		Prompter prompter = new Prompter(new Scanner(System.in));
		String name = prompter.prompt("Please enter your name: ");
		return name;

	public void welcomePrompt() {
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
	}*/
=======
    public void startGame() {
        String name = namePrompt();
        String category = categoryPrompt();
        System.out.println("To play, answer with either 'True', or 'False'. ");
        playGame(category, name);
    }

    private void playGame(String category, String name) {
        Prompter prompter = new Prompter(new Scanner(System.in));
        Player player = new Player(name);

        for (int i = 0; i < 10; i++) {
            ArrayList<String> newQ = new ArrayList<>();
            newQ = QuestionService.newQuestion(Category.valueOf(category));
            String question = newQ.get(0);
            String rightAns = newQ.get(1);
            String wrongAns = newQ.get(2);

            System.out.println("Player: " + player.getName() + "   score: " + player.getScore());
            System.out.println();
            System.out.println(question);
            String userAnswer = prompter.prompt("");
            userAnswer = userAnswer.trim().toUpperCase(Locale.ROOT);
            rightAns = rightAns.trim().toUpperCase(Locale.ROOT);
            wrongAns = wrongAns.trim().toUpperCase(Locale.ROOT);
            if (userAnswer.equals(rightAns)) {
                System.out.println("You got it right!");
                System.out.println();
                player.incrementScore();
            } else if (userAnswer.equals(wrongAns)) {
                System.out.println("You got it wrong :(");
                System.out.println();
            }
        }
        System.out.println("You got " + player.getScore() + " points out of 10!");
    }

    public String namePrompt() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        String name = prompter.prompt("Please enter your name: ");
        return name;
    }

    public String categoryPrompt() {
        List<String> cats = Arrays.asList("ENTERTAINMENT", "SPORTS", "SCIENCE", "ANIMALS", "POLITICS", "GEOGRAPHY", "HISTORY");
        Prompter prompter = new Prompter(new Scanner(System.in));
        String category;
        while (true) {
            System.out.println(cats);
            category = prompter.prompt("Please choose a category: ");
            category = category.trim().toUpperCase(Locale.ROOT);
            if (cats.contains(category)) {
                return category;
            }
        }
    }
}



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
