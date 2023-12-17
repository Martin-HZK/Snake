package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.RedApple;
import com.t.snakeGame.model.snake.NormalSnake;

/**
 * This class represents a checker.
 * Its implementation checks whether the snake eats the special type of apple.
 */
public class NormalEatChecker implements Checker{

    /**
     * The snake.
     */
    private NormalSnake snake;
    /**
     * The red apple.
     */
    private RedApple apple;

    /**
     * Instantiates a new Normal eat checker.
     * @param snake      the snake
     * @param apple the red apple
     */
    public NormalEatChecker(NormalSnake snake, RedApple apple) {
        this.snake = snake;
        this.apple = apple;
    }

    /**
     * This method checks whether the snake eats the red apple.
     * If the snake eats the red apple, the snake will grow one body part.
     * The red apple will be set to be eaten.
     * The red apple will be checked.
     * The snake will check collisions.
     * @return true if the snake eats the red apple, false otherwise
     */
    @Override
    public boolean check() {
        if (snake.getHeadX() == apple.getAppleX() && snake.getHeadY() == apple.getAppleY()) {
            apple.setIsEaten(true);
            snake.setBodyParts(snake.getBodyParts() + 1);
            apple.checkApple();
            snake.checkCollisions();
            return true;
        }
        return false;
    }
}
