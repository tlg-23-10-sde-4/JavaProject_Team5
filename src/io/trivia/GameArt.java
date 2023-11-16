package io.trivia;

//import jdk.internal.reflect.CallerSensitive;

import java.lang.Thread;

import static java.lang.Runnable.*;


public class GameArt implements Runnable {
	Thread thread = new Thread();

	public void gameName() throws InterruptedException {
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






	public void setPriority(int newPriority) {thread.setPriority(newPriority);}

	public int getPriority() {return thread.getPriority();}

	public void setName(String name) {thread.setName(name);}

	public String getName() {return thread.getName();}


	@Override
	public void run() {

	}
}









