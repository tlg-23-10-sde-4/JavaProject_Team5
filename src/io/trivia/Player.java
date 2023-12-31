package io.trivia;

public class Player {
    private String name;
    private int score;

    public void showScoreAtEnd() {
        System.out.println(getName() + " got " + getScore() + " points out of 5!");
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // can have this instead of a setter for score
    public void incrementScore(int points) {
        this.score += points;
    }

    public void incrementScore() {
        this.score++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player: " + name + ", Score= " + score;
    }
}