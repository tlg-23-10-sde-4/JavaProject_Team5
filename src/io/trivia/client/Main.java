package io.trivia.client;

import com.apps.util.Prompter;
import io.trivia.AsciiArt;
import io.trivia.app.GameHost;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AsciiArt ascii = new AsciiArt();
        ascii.loadAscii();
        GameHost a = new GameHost();
        a.startGame();
    }
}
/*
todo: console.clear();
maybe: number categories and have user type in number for category
 */