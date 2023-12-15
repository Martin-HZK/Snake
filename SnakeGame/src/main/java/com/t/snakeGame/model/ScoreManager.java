package com.t.snakeGame.model;

import java.util.ArrayList;

public class ScoreManager {
    PlayScore score;
    ArrayList<PlayScore> scoreList = new ArrayList<>();


    public void addScore(PlayScore score) {
        scoreList.add(score);
    }

    public void removeScore(PlayScore score) {
        scoreList.remove(score);
    }

}
