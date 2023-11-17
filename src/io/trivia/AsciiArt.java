package io.trivia;

import javax.management.openmbean.ArrayType;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;

public class AsciiArt implements Runnable {
	String ascii;
	static String weAre = "🚀Big Tech Small Package is loading your game now 😎";

	public static void simulateLoadingBar() {

		int total = 100;
		int barLength = 100;
		int totalTime = 100;


		for(int i = 1; i <= total; i++) {
			try {
				Thread.sleep(totalTime, total);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			// Update the loading bar
			updateLoadingBar(i, total, barLength);
			System.out.flush();
		}
		// Keep 100% displayed for user detail
		try {
			Thread.sleep(500);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}

	public static void updateLoadingBar(int current, int total, int barLength) {
		int progress = (int) ((double) current / total * barLength);

		StringBuilder progressBar = new StringBuilder("[");
		for(int i = 0; i < barLength; i++) {
			if(i < progress) {
				progressBar.append("=");
			}
			else {
				progressBar.append(" ");
			}
		}
		progressBar.append("] ");
		progressBar.append(current).append("%");

		// Clear the previous line in the console
		System.out.print(progressBar + "\r");
	}

/*	public static void simulateTime() {
		int totalTime = 3000; // Total time in milliseconds (5 seconds)
		int sleepInterval = 100; // Sleep interval in milliseconds (100 milliseconds)
		for(int elapsed = 0; elapsed <= totalTime; elapsed += sleepInterval) {
			// Simulate work being done (replace this with your actual work)
			try {
				Thread.sleep(sleepInterval);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			int remainingSeconds = (totalTime - elapsed) / 1000;
			System.out.print("\r Seconds remaining: " + "║ " + remainingSeconds + " ║");
		}
		System.out.println("\n");
	}*/


	public static void loadTitle() throws InterruptedException {
		System.out.println(weAre);

		simulateLoadingBar();
		updateLoadingBar(0, 100, 100);


		System.out.println("  _______ _                           _   _           ______                    _   _                   _ ");
		Thread.sleep(400);
		System.out.println(" |__   __| |                         | \\ | |         |  ____|                  | | (_)                 | |");
		Thread.sleep(375);
		System.out.println("    | |  | |__  _ __ _____      __   |  \\| | ___     | |__  __  _____ ___ _ __ | |_ _  ___  _ __  ___  | |");
		Thread.sleep(350);
		System.out.println("    | |  | '_ \\| '__/ _ \\ \\ /\\ / /   | . ` |/ _ \\    |  __| \\ \\/ / __/ _ \\ '_ \\| __| |/ _ \\| '_ \\/ __| | |");
		Thread.sleep(325);
		System.out.println("    | |  | | | | | | (_) \\ V  V /    | |\\  | (_) |   | |____ >  < (_|  __/ |_) | |_| | (_) | | | \\__ \\ |_|");
		Thread.sleep(300);
		System.out.println("    |_|  |_| |_|_|  \\___/ \\_/\\_/     |_| \\_|\\___/    |______/_/\\_\\___\\___| .__/ \\__|_|\\___/|_| |_|___/ (_)");
		Thread.sleep(275);
		System.out.println("                                                                         | |                              ");
		Thread.sleep(250);
		System.out.println("                                                                         |_|                              ");

	}


	@Override
	public void run() {

	}


	/*	public void kid1LoadTitle() throws InterruptedException {
	 		// this is nested in loadTitle()
		ArrayList <String>[] alphaList = new ArrayList[5]; // this means 4 different emojis each index can be repeated and reassigned
		for(int i = 0; i < alphaList.length; i++) {
			alphaList[i] = new ArrayList <>();
		}
		//alphaList[0].add("");
		//alphaList[1].add("");
		//alphaList[2].add("");
		//alphaList[1].add("");
		//alphaList[2].add("");
		//alphaList[2].add("");
		//alphaList[3].add("");
		//alphaList[3].add("");

		int playback = 1;
		for(int repeat = 0; repeat < playback; repeat++) {
			for(ArrayList <String> list: alphaList) {
				for(String str: list) {
					Thread thread = new Thread(() -> {
						try {
							// Print the string and sleep for 200 milliseconds
							System.out.println(str);
							Thread.sleep(200);
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
					});
					thread.start();
				}
			}
		}
	}*/// maybe

}