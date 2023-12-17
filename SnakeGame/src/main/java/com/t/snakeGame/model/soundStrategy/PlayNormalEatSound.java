package com.t.snakeGame.model.soundStrategy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class PlayNormalEatSound implements Strategy{
    @Override
    public void playSound() {
            Media bonus = new Media(new File("src/main/resources/sound/normalEat.mp3").toURI().toString());
            MediaPlayer bonusPlayer = new MediaPlayer(bonus);
            bonusPlayer.play();
    }
}
