package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.BonusApple;
import com.t.snakeGame.model.snake.NormalSnake;

/**
 * This class represents a checker.
 * Its implementation checks whether the snake eats the special type of apple.
 */
public class BonusEatChecker implements Checker{

    /**
     * The snake.
     */
    private NormalSnake snake;
    /**
     * The bonus apple.
     */
    private BonusApple bonusApple;

    /**
     * Instantiates a new Bonus eat checker.
     * @param snake      the snake
     * @param bonusApple the bonus apple
     */
    public BonusEatChecker(NormalSnake snake, BonusApple bonusApple) {
        this.snake = snake;
        this.bonusApple = bonusApple;
    }

    /**
     * This method checks whether the snake eats the bonus apple.
     * If the snake eats the bonus apple, the snake will grow one body part.
     * The bonus apple will be set to be eaten.
     * The bonus apple will be checked.
     * The snake will check collisions.
     * @return true if the snake eats the bonus apple, false otherwise
     */
    @Override
    public void check() {
        if (snake.getHeadX() == bonusApple.getAppleX() && snake.getHeadY() == bonusApple.getAppleY()) {
            bonusApple.setIsEaten(true);
            snake.setBodyParts(snake.getBodyParts() + 1);
        }
        bonusApple.checkApple();
        snake.checkCollisions();
    }
}
