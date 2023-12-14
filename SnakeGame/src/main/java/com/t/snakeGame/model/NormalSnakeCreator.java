package com.t.snakeGame.model;

public class NormalSnakeCreator extends SnakeCreator{
    @Override
    public NormalSnake createSnake() {
        return new NormalSnake();
    }
}
