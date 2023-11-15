package io.trivia;

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Do we need this?
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // TODO: Are we making a derived property method?

    //
    public String toString() {
        return "null";
    }
}