package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.UnknownApple;
import com.t.snakeGame.model.snake.NormalSnake;

/**
 * This class represents a checker.
 * Its implementation checks whether the snake eats the special type of apple.
 */
public class UnknownEatChecker implements Checker{

    /**
     * The snake.
     */
    private NormalSnake snake;
    /**
     * The unknown apple.
     */
    private UnknownApple unknownApple;

    /**
     * Instantiates a new Unknown eat checker.
     * @param snake      the snake
     * @param unknownApple the unknown apple
     */
    public UnknownEatChecker(NormalSnake snake, UnknownApple unknownApple) {
        this.snake = snake;
        this.unknownApple = unknownApple;
    }

    /**
     * This method checks whether the snake eats the unknown apple.
     * If the snake eats the unknown apple, the snake will grow one body part.
     * The unknown apple will be set to be eaten.
     * The unknown apple will be checked.
     * The snake will check collisions.
     * @return true if the snake eats the unknown apple, false otherwise
     */
    @Override
    public void check() {
        if (snake.getHeadX() == unknownApple.getAppleX() && snake.getHeadY() == unknownApple.getAppleY()) {
            unknownApple.setIsEaten(true);
            snake.setBodyParts(snake.getBodyParts() + 1);
        }
        unknownApple.checkApple();
        snake.checkCollisions();
    }
}
