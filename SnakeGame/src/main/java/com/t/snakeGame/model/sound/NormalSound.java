package com.t.snakeGame.model.apple;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class NormalSound extends AppleDecorator {
    public NormalSound(Apple decoratedApple) {
        super(decoratedApple);
    }

    @Override
    public void checkApple() {
        decoratedApple.checkApple();
        normalSound();
    }

    public void normalSound() {
        Media bonus = new Media("src/resources/sound/normalEat.mp3");
        MediaPlayer bonusPlayer = new MediaPlayer(bonus);
        bonusPlayer.play();
    }
}
