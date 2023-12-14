package com.t.snakeGame.model;

public class BonusAppleCreator extends AppleCreator {
    @Override
    public Apple createApple(int x, int y) {
        return new BonusApple(x, y);
    }
}
