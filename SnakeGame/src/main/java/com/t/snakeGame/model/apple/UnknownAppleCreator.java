package com.t.snakeGame.model.apple;

/**
 * This class represents an unknown apple creator.
 * It extends the abstract class 'AppleCreator' and provides implementation of the method 'createApple'.
 */
public class UnknownAppleCreator extends AppleCreator{
    /**
     * Create an unknown apple.
     * @param x the x coordinate of the unknown apple
     * @param y the y coordinate of the unknown apple
     * @return the unknown apple created
     */
    @Override
    public UnknownApple createApple(int x, int y) {
        return new UnknownApple(x, y);
    }
}
