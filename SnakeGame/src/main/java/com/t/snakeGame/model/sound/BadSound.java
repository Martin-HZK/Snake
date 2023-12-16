package com.t.snakeGame.model.sound;

import com.t.snakeGame.model.apple.Apple;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BadSound extends AppleDecorator {
    public BadSound(Apple decoratedApple) {
        super(decoratedApple);
    }

    @Override
    public void checkApple() {
        super.checkApple();
        badSound();
    }

    private void badSound() {
        Media bonus = new Media("src/resources/sound/badEat.wav");
        MediaPlayer bonusPlayer = new MediaPlayer(bonus);
        bonusPlayer.play();
    }
}
