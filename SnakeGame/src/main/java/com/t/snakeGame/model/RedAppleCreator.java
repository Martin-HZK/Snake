package com.t.snakeGame.model;

public class RedAppleCreator extends AppleCreator {
    @Override
    public Apple createApple(int x, int y) {
        return new RedApple(x, y);
    }
}
