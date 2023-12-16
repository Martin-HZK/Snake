package com.t.snakeGame.model.sound;

import com.t.snakeGame.model.apple.Apple;

public abstract class AppleDecorator implements Apple {
    protected Apple decoratedApple;

    public AppleDecorator(Apple decoratedApple) {
        this.decoratedApple = decoratedApple;
    }

    @Override
    public void checkApple() {
        decoratedApple.checkApple();
    }
}
