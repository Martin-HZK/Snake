package com.t.snakeGame.model.sound;

import com.t.snakeGame.model.apple.Apple;
import com.t.snakeGame.model.snake.Snake;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class NormalSoundDecorator extends SnakeDecorator {
    public NormalSoundDecorator(Snake decoratedSnake) {
        super(decoratedSnake);
    }

    @Override
    public void move() {
        super.move();
        normalSound();
    }

    @Override
    public void checkCollisions() {
        super.checkCollisions();
    }

    private void normalSound() {
        Media bonus = new Media("src/resources/sound/normalMode.mp3");
        MediaPlayer bonusPlayer = new MediaPlayer(bonus);
        bonusPlayer.play();
    }
}
