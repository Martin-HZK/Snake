package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.RedApple;
import com.t.snakeGame.model.snake.NormalSnake;

public class NormalChecker implements Checker{

    private NormalSnake snake;
    private RedApple apple;

    public NormalChecker(NormalSnake snake, RedApple apple) {
        this.snake = snake;
        this.apple = apple;
    }
    @Override
    public boolean check() {
        if (snake.getHeadX() == apple.getAppleX() && snake.getHeadY() == apple.getAppleY()) {
            return true;
        }
        return false;
    }
}
