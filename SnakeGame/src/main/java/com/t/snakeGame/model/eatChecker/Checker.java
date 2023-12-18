package com.t.snakeGame.model.eatChecker;

import com.t.snakeGame.model.apple.Apple;
import com.t.snakeGame.model.snake.Snake;

/**
 * This interface represents a checker.
 * Its implementation checks whether the snake eats the special type of apple.
 * It checks whether the snake eats the apple.
 */
public interface Checker {
    /**
     * This method checks whether the snake eats the apple.
     */
    void check();
}
