package com.t.snakeGame.model.soundStrategy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * This class implements Strategy class, representing a strategy for playing bonusEat sound.
 */
public class PlayBonusEatSound implements Strategy{
    /**
     * This method plays the bonusEat sound.
     */
    @Override
    public void playSound() {
            Media bonus = new Media(new File("src/main/resources/sound/bonusEat.wav").toURI().toString());
            MediaPlayer bonusPlayer = new MediaPlayer(bonus);
            bonusPlayer.play();
    }
}
