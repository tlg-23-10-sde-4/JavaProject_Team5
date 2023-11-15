package io.trivia;

public class Player {
    private String name;
    private int score;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Do we need this?
    public int getScore() {
        return score;
    }

    // Are we making a derived property method?

    // Initial toString if needed
    @Override
    public String toString() {
        return "Player: " + name + ", Score= " + score;
    }
}