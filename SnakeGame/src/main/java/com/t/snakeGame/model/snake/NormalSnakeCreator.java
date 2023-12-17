package com.t.snakeGame.model.snake;

/**
 * This class represents a normal snake creator.
 * This class extends the SnakeCreator class.
 * It defines the method for creating a normal snake.
 */
public class NormalSnakeCreator extends SnakeCreator{
    /**
     * Create a normal snake.
     * @return the normal snake created
     */
    @Override
    public NormalSnake createSnake() {
        return new NormalSnake();
    }
}
