package com.t.snakeGame.model.soundStrategy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayNormalEatSound implements Strategy{
    @Override
    public void playSound() {
            Media bonus = new Media("src/resources/sound/normalEat.mp3");
            MediaPlayer bonusPlayer = new MediaPlayer(bonus);
            bonusPlayer.play();
    }
}
