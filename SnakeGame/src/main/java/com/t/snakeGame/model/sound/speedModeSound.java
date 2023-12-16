package com.t.snakeGame.model.sound;

import com.t.snakeGame.model.apple.Apple;
import com.t.snakeGame.model.snake.Snake;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class speedModeSound extends SnakeDecorator {
    public speedModeSound(Snake decoratedSnake) {
        super(decoratedSnake);
    }

    @Override
    public void move() {
        super.move();
        badSound();
    }

    @Override
    public void checkCollisions() {
        super.checkCollisions();
    }

    private void badSound() {
        Media bonus = new Media("src/resources/sound/badEat.wav");
        MediaPlayer bonusPlayer = new MediaPlayer(bonus);
        bonusPlayer.play();
    }
}
