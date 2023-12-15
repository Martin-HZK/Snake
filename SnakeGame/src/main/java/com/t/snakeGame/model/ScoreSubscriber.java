package com.t.snakeGame.model;

public class ScoreSubscriber implements Subscriber{



    private String playerName;
    private String playerScore;

    public ScoreSubscriber(String playerName, String playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }
    @Override
    public void update() {

    }
}
