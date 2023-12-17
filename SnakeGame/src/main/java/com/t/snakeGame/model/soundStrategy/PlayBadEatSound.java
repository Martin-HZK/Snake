package com.t.snakeGame.model.soundStrategy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class implements Strategy class, representing a strategy for playing badEat sound.
 */
public class PlayBadEatSound implements Strategy{
    /**
     * This method plays the badEat sound.
     */
    @Override
    public void playSound() {
            Media bonus = new Media("src/main/resources/sound/badEat.mp3");
            MediaPlayer bonusPlayer = new MediaPlayer(bonus);
            bonusPlayer.play();
    }
}
