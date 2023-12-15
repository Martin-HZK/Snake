package com.t.snakeGame.model;

public class RedAppleCreator extends AppleCreator {
    @Override
    public RedApple createApple(int x, int y) {
        return new RedApple(x, y);
    }
}
