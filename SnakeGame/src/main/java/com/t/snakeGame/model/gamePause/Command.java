package com.t.snakeGame.model.gamePause;

/**
 * The Command interface represents a command that can be executed.
 * Implementations of this interface encapsulate a specific action or behavior
 * that can be invoked by calling the execute() method.
 */
public interface Command {
    /**
     * This method executes the command.
     */
    void execute();
}
