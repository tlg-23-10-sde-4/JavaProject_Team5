package io.trivia;

import com.apps.util.Console;

import java.io.*;


public class AsciiArt implements Runnable {
	
	static final int TOTAL = 100;              // total progress steps
	static final int BAR_LENGTH = 95;           // length of the loading bar
	static final int TOTAL_TIME = 1000;         // total time to load the bar
	
	
	public void loadingBar() {
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
			visualizeLoading.append(" 🤪 ❪").append(a).append("％❫      ");
			
			System.out.print(visualizeLoading + "\r");
			System.out.flush();  // refresh the output in the loading bar
			int sleepDuration = TOTAL_TIME / TOTAL; // Calculate sleep duration based on progress
			try {
				Thread.sleep(sleepDuration);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);  // Delay before the next display (custom)
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.flush();
	}
	
	
	public void run() {
		final String A01 = "A01.txt";
		final String A02 = "A02.txt";
		
		
		final String FILE_PATH = "/Users/andytran/StudentWork/JavaProject_Team5";
		
		BufferedReader reader;
		{
			try {
				BufferedReader reader01 = new BufferedReader(new FileReader(FILE_PATH + A01));
				BufferedReader reader02 = new BufferedReader(new FileReader(FILE_PATH + A02));
				String line01;
				String line02;
				
				while((line01 = reader01.readLine()) != null) {
					System.out.println(line01);
					
				}
				reader01.close();
				Console.clear();
				try {
					
					while((line02 = reader02.readLine()) != null) {
						System.out.println(line02);
					}
					
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}








