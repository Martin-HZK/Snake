package com.t.snakeGame.model.apple;

public abstract class AppleDecorator implements Apple{
    protected Apple decoratedApple;

    public AppleDecorator(Apple decoratedApple) {
        this.decoratedApple = decoratedApple;
    }

    @Override
    public void checkApple() {
        decoratedApple.checkApple();
    }
}
