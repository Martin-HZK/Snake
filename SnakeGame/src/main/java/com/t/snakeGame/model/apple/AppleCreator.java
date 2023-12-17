package com.t.snakeGame.model.apple;

/**
 * This abstract class represents a creator of an apple.
 * It provides the method to create an apple.
 */
abstract class AppleCreator {
    /**
     * Create an apple.
     * @param x the x coordinate of the apple
     * @param y the y coordinate of the apple
     * @return the apple created
     */

    public abstract Apple createApple(int x, int y);
}
