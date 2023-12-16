package com.t.snakeGame.model.apple;

public class UnknownAppleCreator extends AppleCreator{
    @Override
    public UnknownApple createApple(int x, int y) {
        return new UnknownApple(x, y);
    }
}
