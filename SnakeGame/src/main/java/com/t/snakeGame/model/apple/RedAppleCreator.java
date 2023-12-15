package com.t.snakeGame.model.apple;

import com.t.snakeGame.model.apple.AppleCreator;
import com.t.snakeGame.model.apple.RedApple;

public class RedAppleCreator extends AppleCreator {
    @Override
    public RedApple createApple(int x, int y) {
        return new RedApple(x, y);
    }
}
