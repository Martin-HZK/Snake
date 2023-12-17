package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.UnknownApple;
import com.t.snakeGame.model.snake.NormalSnake;

public class UnknownChecker implements Checker{

    private NormalSnake snake;
    private UnknownApple unknownApple;

    public UnknownChecker(NormalSnake snake, UnknownApple unknownApple) {
        this.snake = snake;
        this.unknownApple = unknownApple;
    }
    @Override
    public boolean check() {
        if (snake.getHeadX() == unknownApple.getAppleX() && snake.getHeadY() == unknownApple.getAppleY()) {
            return true;
        }
        return false;
    }
}
