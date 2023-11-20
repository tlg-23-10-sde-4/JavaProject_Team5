package io.trivia;

import com.apps.util.Prompter;
import io.trivia.app.GameHost;
import jdk.dynalink.beans.StaticClass;

import java.io.IOException;
import java.util.Scanner;

public class AsciiArt implements Runnable {
	// AsciiArt is instantiated in GameHost
	static String name = null;
	static final int TOTAL = 100;              // total progress steps
	static final int BAR_LENGTH = 95;           // length of the loading bar
	static final int TOTAL_TIME = 1000;         // total time to load the bar
	
	public static void sweep(int lines) {
		for(int i = 0; i < lines; i++) {
			System.out.flush();
			System.out.println("\n");
		}
	} // old clear method
	
	public static void ansiFlush() {
		System.out.print("\033[H\033[2J"); //ansiClear and flush escape sequence
		System.out.flush();
	}
	
	public static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if(os.contains("Windows")) {
				Runtime.getRuntime().exec("cls"); //windows
			}
			else {
				Runtime.getRuntime().exec("clear"); // macos
			}
		}
		catch(final Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ansiClear() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
	
	public void bigTechBanner() throws InterruptedException {
		String[] asciiHeading = {
				" ░░░░░░  ░░  ░░░░░░     ░░░░░░░░ ░░░░░░░  ░░░░░░ ░░   ░░      ░░░░░░░ ░░░    ░░░  ░░░░░  ░░      ░░           ░░░░░░   ░░░░░   ░░░░░░ ░░   ░░  ░░░░░   ░░░░░░  ░░░░░░░ ░░░░░░░  ",
				" ▒▒   ▒▒ ▒▒ ▒▒             ▒▒    ▒▒      ▒▒      ▒▒   ▒▒      ▒▒      ▒▒▒▒  ▒▒▒▒ ▒▒   ▒▒ ▒▒      ▒▒           ▒▒   ▒▒ ▒▒   ▒▒ ▒▒      ▒▒  ▒▒  ▒▒   ▒▒ ▒▒       ▒▒      ▒▒       ",
				" ▒▒▒▒▒▒  ▒▒ ▒▒   ▒▒▒       ▒▒    ▒▒▒▒▒   ▒▒      ▒▒▒▒▒▒▒      ▒▒▒▒▒▒▒ ▒▒ ▒▒▒▒ ▒▒ ▒▒▒▒▒▒▒ ▒▒      ▒▒           ▒▒▒▒▒▒  ▒▒▒▒▒▒▒ ▒▒      ▒▒▒▒▒   ▒▒▒▒▒▒▒ ▒▒   ▒▒▒ ▒▒▒▒▒   ▒▒▒▒▒▒▒  ",
				" ▓▓   ▓▓ ▓▓ ▓▓    ▓▓       ▓▓    ▓▓      ▓▓      ▓▓   ▓▓           ▓▓ ▓▓  ▓▓  ▓▓ ▓▓   ▓▓ ▓▓      ▓▓           ▓▓      ▓▓   ▓▓ ▓▓      ▓▓  ▓▓  ▓▓   ▓▓ ▓▓    ▓▓ ▓▓           ▓▓  ",
				" ██████  ██  ██████        ██    ███████  ██████ ██   ██      ███████ ██      ██ ██   ██ ███████ ███████      ██      ██   ██  ██████ ██   ██ ██   ██  ██████  ███████ ███████  "
		};
		
		for(String line: asciiHeading) {
			System.out.println(line.trim());
			Thread.sleep(50); // SPEED OF DISPLAY
			System.out.flush();
		}
		executeLoading();
		
	}
	
	public static void throwNoBanner() throws InterruptedException {
		String[] asciiHeading2 = {
				"▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n",
				"░░░░░░░░ ░░   ░░ ░░░░░░   ░░░░░░  ░░     ░░     ░░░    ░░  ░░░░░░      ░░░░░░░ ░░   ░░  ░░░░░░ ░░░░░░░ ░░░░░░  ░░░░░░░░ ░░  ░░░░░░  ░░░    ░░ ░░░░░░░",
				"   ▒▒    ▒▒   ▒▒ ▒▒   ▒▒ ▒▒    ▒▒ ▒▒     ▒▒     ▒▒▒▒   ▒▒ ▒▒    ▒▒     ▒▒       ▒▒ ▒▒  ▒▒      ▒▒      ▒▒   ▒▒    ▒▒    ▒▒ ▒▒    ▒▒ ▒▒▒▒   ▒▒ ▒▒     ",
				"   ▒▒    ▒▒▒▒▒▒▒ ▒▒▒▒▒▒  ▒▒    ▒▒ ▒▒  ▒  ▒▒     ▒▒ ▒▒  ▒▒ ▒▒    ▒▒     ▒▒▒▒▒     ▒▒▒   ▒▒      ▒▒▒▒▒   ▒▒▒▒▒▒     ▒▒    ▒▒ ▒▒    ▒▒ ▒▒ ▒▒  ▒▒ ▒▒▒▒▒▒▒",
				"   ▓▓    ▓▓   ▓▓ ▓▓   ▓▓ ▓▓    ▓▓ ▓▓ ▓▓▓ ▓▓     ▓▓  ▓▓ ▓▓ ▓▓    ▓▓     ▓▓       ▓▓ ▓▓  ▓▓      ▓▓      ▓▓         ▓▓    ▓▓ ▓▓    ▓▓ ▓▓  ▓▓ ▓▓      ▓▓",
				"   ██    ██   ██ ██   ██  ██████   ███ ███      ██   ████  ██████      ███████ ██   ██  ██████ ███████ ██         ██    ██  ██████  ██   ████ ███████\n",
				"░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"
		};
		for(String line: asciiHeading2) {
			System.out.println(line.trim());
			Thread.sleep(50); // SPEED OF DISPLAY
			System.out.flush();
		}
	}
	
	public void executeLoading() throws InterruptedException {
		System.out.println("\n");
		for(int a = 1; a <= TOTAL; a++) {
			// calculates progress in the loading bar
			int progress = (int) ((double) a / TOTAL * BAR_LENGTH);
			// custom loading bar design
			StringBuilder visualizeLoading = new StringBuilder("💠 Loading your game 💠 ░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
			for(int b = 0; b < BAR_LENGTH; b++) {
				if(b < progress) {
					visualizeLoading.append("█");            // custom loading bar filler
				}
				else {
					visualizeLoading.append(" ");
				}
			}
			visualizeLoading.append("🤪  ❪").append(a).append("％❫      ");
			
			System.out.print(visualizeLoading + "\r");
			System.out.flush();  // refresh the output in the loading bar
			int sleepDuration = TOTAL_TIME / TOTAL; // Calculate sleep duration based on progress
			Thread.sleep(sleepDuration);
		}
		Thread.sleep(500);  // Delay before the next display (custom)
		System.out.flush();
	}
	
	public static String promptName() {
		Prompter input = new Prompter(new Scanner(System.in));
		System.out.println("\n"); // line between and separating the throw no exceptions heading and name prompt
		String askName = "Hey there, what's your name? ";
		input.prompt(askName);
		return askName = name;
	}
	
	public void loadAscii() throws InterruptedException {
		bigTechBanner();
		sweep(20);
		throwNoBanner();
		sweep(9);
		System.out.flush();
	}
	
	@Override
	public void run() {}
	
	public String getName() {
		return name;
	}
}
