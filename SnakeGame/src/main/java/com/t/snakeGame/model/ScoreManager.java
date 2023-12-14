package com.t.snakeGame.model;

import java.util.ArrayList;

public class ScoreManager {
    Score score;
    ArrayList<Score> scoreList = new ArrayList<>();


    public void addScore(Score score) {
        scoreList.add(score);
    }

    public void removeScore(Score score) {
        scoreList.remove(score);
    }

}
