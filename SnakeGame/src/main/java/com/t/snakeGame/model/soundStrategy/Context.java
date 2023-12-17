package com.t.snakeGame.model.soundStrategy;

/**
 * This class represents a context for playing sound.
 * This context for setting strategy and executing it.
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.playSound();
    }
}
