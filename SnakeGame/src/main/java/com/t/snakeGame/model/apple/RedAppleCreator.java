package com.t.snakeGame.model.apple;

import com.t.snakeGame.model.apple.AppleCreator;
import com.t.snakeGame.model.apple.RedApple;


/**
 * This class represents a red apple creator.
 * It extends the abstract class 'AppleCreator' and provides implementation of the method 'createApple'.
 */
public class RedAppleCreator extends AppleCreator {
    /**
     * Create a red apple.
     * @param x the x coordinate of the red apple
     * @param y the y coordinate of the red apple
     * @return the red apple created
     */
    @Override
    public RedApple createApple(int x, int y) {
        return new RedApple(x, y);
    }
}
