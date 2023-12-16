package com.t.snakeGame.model.sound;
import com.t.snakeGame.model.apple.Apple;
import com.t.snakeGame.model.snake.Snake;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class BonusSound extends SnakeDecorator {
    public BonusSound(Snake decoratedSnake) {
        super(decoratedSnake);
    }

    @Override
    public void move() {
        super.move();
        bonusSound();
    }

    @Override
    public void checkCollisions() {
        super.checkCollisions();
    }

    private void bonusSound() {
    Media bonus = new Media("src/resources/sound/snake-hissing.mp3");
    MediaPlayer bonusPlayer = new MediaPlayer(bonus);
    bonusPlayer.play();

}

}
