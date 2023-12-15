package com.t.snakeGame.model;

public class PlayScore {
    private String playerName;



    private String playerScore;
    private ScoreManager scoreManager;


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

    public PlayScore(String playerName, String playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }




}
