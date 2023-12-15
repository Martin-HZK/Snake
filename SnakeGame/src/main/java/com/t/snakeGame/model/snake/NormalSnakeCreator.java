package com.t.snakeGame.model.snake;

public class NormalSnakeCreator extends SnakeCreator{
    @Override
    public NormalSnake createSnake() {
        return new NormalSnake();
    }
}
