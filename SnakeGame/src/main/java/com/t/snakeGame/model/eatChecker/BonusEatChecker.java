package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.Apple;
import com.t.snakeGame.model.apple.BonusApple;
import com.t.snakeGame.model.snake.NormalSnake;

public class BonusChecker implements Checker{
    private NormalSnake snake;
    private BonusApple bonusApple;

    public BonusChecker(NormalSnake snake, BonusApple bonusApple) {
        this.snake = snake;
        this.bonusApple = bonusApple;
    }
    @Override
    public boolean check() {
        if (snake.getHeadX() == bonusApple.getAppleX() && snake.getHeadY() == bonusApple.getAppleY()) {
            return true;
        }
        return false;
    }
}
