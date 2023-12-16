package com.t.snakeGame.model.sound;
import com.t.snakeGame.model.apple.Apple;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class BonusSound extends AppleDecorator {
    public BonusSound(Apple decoratedApple) {
        super(decoratedApple);
    }

    @Override
    public void checkApple() {
        super.checkApple();
        bonusSound();
    }

private void bonusSound() {
    Media bonus = new Media("src/resources/sound/bonusEat.wav");
    MediaPlayer bonusPlayer = new MediaPlayer(bonus);
    bonusPlayer.play();

}

}
