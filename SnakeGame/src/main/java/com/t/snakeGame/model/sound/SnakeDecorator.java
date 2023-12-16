package com.t.snakeGame.model.sound;

import com.t.snakeGame.model.snake.Snake;

public abstract class SnakeDecorator implements Snake {
    protected Snake decoratedSnake;

    public SnakeDecorator(Snake decoratedSnake) {
        this.decoratedSnake = decoratedSnake;
    }

    @Override
    public void move() {
        decoratedSnake.move();
    }

    @Override
    public void checkCollisions() {
        decoratedSnake.checkCollisions();
    }
}
