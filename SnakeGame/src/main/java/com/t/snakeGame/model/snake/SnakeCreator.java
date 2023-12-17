package com.t.snakeGame.model.snake;

/**
 * This abstract class represents a snake creator.
 * It defines the abstract method for creating a snake.
 */
abstract class SnakeCreator {
    /**
     * Create a snake.
     * @return the snake created
     */
    public abstract Snake createSnake();
}
