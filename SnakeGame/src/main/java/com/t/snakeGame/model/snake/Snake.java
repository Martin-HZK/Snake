package com.t.snakeGame.model.snake;

/**
 * This interface represents a snake object.
 * It defines the playing logic of the snake in the 'Snake' game, including moving and checking collisions.
 */
public interface Snake {

    /**
     * Move the snake.
     */
    void move();

    /**
     * Check if the snake has collided with itself or the wall.
     */
    void checkCollisions();

}
