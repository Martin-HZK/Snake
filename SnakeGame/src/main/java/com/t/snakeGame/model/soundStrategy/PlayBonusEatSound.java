package com.t.snakeGame.model.soundStrategy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayBonusEatSound implements Strategy{
    @Override
    public void playSound() {
            Media bonus = new Media("src/main/resources/sound/bonusEat.mp3");
            MediaPlayer bonusPlayer = new MediaPlayer(bonus);
            bonusPlayer.play();
    }
}
