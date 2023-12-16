package com.t.snakeGame.model.sound;

import com.t.snakeGame.model.apple.Apple;
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

    private void normalSound() {
        Media bonus = new Media("src/resources/sound/normalEat.mp3");
        MediaPlayer bonusPlayer = new MediaPlayer(bonus);
        bonusPlayer.play();
    }
}
