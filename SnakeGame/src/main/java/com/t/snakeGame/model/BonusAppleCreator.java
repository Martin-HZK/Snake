package com.t.snakeGame.model;

public class BonusAppleCreator extends AppleCreator {
    @Override
    public BonusApple createApple(int x, int y) {
        return new BonusApple(x, y);
    }
}
