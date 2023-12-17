package com.t.snakeGame.model.apple;

/**
 * This class represents a bonus apple creator.
 * It extends the abstract class 'AppleCreator' and provides implementation of the method 'createApple'.
 */
public class BonusAppleCreator extends AppleCreator {
    /**
     * Create a bonus apple.
     * @param x the x coordinate of the bonus apple
     * @param y the y coordinate of the bonus apple
     * @return the bonus apple created
     */
    @Override
    public BonusApple createApple(int x, int y) {
        return new BonusApple(x, y);
    }
}
