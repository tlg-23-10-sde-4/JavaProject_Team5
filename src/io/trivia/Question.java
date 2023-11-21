package io.trivia;

import com.apps.util.Prompter;

import java.util.*;

public class Question {
	private final String body;
	private final String answer;
	private final String wrongChoice1;
	private final String wrongChoice2;
	private final String wrongChoice3;
	
	public Question(List <String> question) {
		this.body = question.get(0);
		this.answer = question.get(1).toUpperCase(Locale.ROOT).trim();
		this.wrongChoice1 = question.get(2).toUpperCase(Locale.ROOT).trim();
		this.wrongChoice2 = question.get(3).toUpperCase(Locale.ROOT).trim();
		this.wrongChoice3 = question.get(4).toUpperCase(Locale.ROOT).trim();
	}
	
	public List <String> allChoicesRandom() {
		List <String> randomizedChoices = new ArrayList <>(Arrays.asList(getAnswer(), getWrongChoice1(),
				getWrongChoice2(), getWrongChoice3()));
		Collections.shuffle(randomizedChoices);
		return randomizedChoices;
	}
	
	public List <String> wrongChoices() {
		List <String> wrong = new ArrayList <>(Arrays.asList(getWrongChoice1(),
				getWrongChoice2(), getWrongChoice3()));
		return wrong;
	}
	
	public void askQuestionDisplay(Player player) {
		Prompter prompter = new Prompter(new Scanner(System.in));
		while(true) {
			System.out.println("Player: " + player.getName() + "   score: " + player.getScore());
			System.out.println();
			System.out.println(this.getBody());
			
			List <String> choices = (this.allChoicesRandom());
			for(int i = 0; i < choices.size(); i++) {
				System.out.println((i + 1) + ". " + choices.get(i));
			}
			
			int userChoice;
			while(true) {
				try {
					userChoice = Integer.parseInt(prompter.prompt("Your Answer (1-4): "));
					if(userChoice < 1 || userChoice > 4) {
						System.out.println("Please enter a number between 1 and 4.");
					}
					else {
						break;
					}
				}
				catch(NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number between 1 and 4.");
				}
			}
			String selectedAnswer = choices.get(userChoice - 1);
			if(selectedAnswer.equals(this.getAnswer())) {
				System.out.println();
				System.out.println("You got it right!");
				System.out.println();
				player.incrementScore();
				break;
			}
			else {
				System.out.println();
				System.out.println("You got it wrong :(");
				System.out.println("The correct answer was " + this.getAnswer());
				System.out.println();
				System.out.println("THROW NEW EXCEPTION!!!!");
				System.out.println();
				break;
			}
		}
	}
	
	public static String getCategoryFromUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n┌────────────────────────────┐");
		System.out.print("  CHOOSE A CATEGORY: ⓵ 𛰈 ⓻ ");
		System.out.println("\n└────────────────────────────┘");
		for(int i = 0; i < Category.values().length; i++) {
			
			System.out.println((i + 1) + ". " + Category.values()[i]);
		}
		int choice = - 1;
		while(choice < 1 || choice > Category.values().length) {
			System.out.println("Enter your choice (1-" + Category.values().length + "):");
			try {
				choice = Integer.parseInt(scanner.nextLine());
				if(choice < 1 || choice > Category.values().length) {
					System.out.println("Please enter a number between 1 and " + Category.values().length + ".");
				}
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}
		return Category.values()[choice - 1].name();
	}
	
	public static void askQuestionOps(Set <String> askedQuestions, Player player, Player player2, String category) {
		boolean player1Turn = true;
		for(int i = 0; i < 10; i++) {
			if(player1Turn == true) {
				askedQuestions = nameAndQuestionDisplay(player, askedQuestions, category);
				player1Turn = false;
			}
			else {
				askedQuestions = nameAndQuestionDisplay(player2, askedQuestions, category);
				player1Turn = true;
			}
		}
	}
	
	public static Set <String> nameAndQuestionDisplay(Player player, Set <String> askedQuestions, String category) {
		System.out.println(player.getName() + "'s " + "turn");
		List <String> newQ;
		String body;
		do {
			newQ = QuestionService.newQuestion(Category.valueOf(category));
			body = newQ.get(0);
		}
		while(askedQuestions.contains(body));
		askedQuestions.add(body);
		Question question = new Question(newQ);
		question.askQuestionDisplay(player);
		return askedQuestions;
	}
	
	public String getBody() {
		return body;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public String getWrongChoice1() {
		return wrongChoice1;
	}
	
	public String getWrongChoice2() {
		return wrongChoice2;
	}
	
	public String getWrongChoice3() {
		return wrongChoice3;
	}
	
	@Override
	public String toString() {
		return "Question{" +
				"body='" + body + '\'' +
				", answer='" + answer + '\'' +
				", wrongChoice1='" + wrongChoice1 + '\'' +
				", wrongChoice2='" + wrongChoice2 + '\'' +
				", wrongChoice3='" + wrongChoice3 + '\'' +
				'}';
	}
}