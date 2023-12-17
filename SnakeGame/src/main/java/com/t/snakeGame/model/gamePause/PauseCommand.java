package com.t.snakeGame.model.gamePause;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;

/**
 * This class implements Command interface, representing a command for pausing the game.
 * The command is executed by calling the execute() method.
 * The execute() method calls specified AnimationTimer's stop() method.
 */
public class PauseCommand implements Command{
    /**
     * This field represents the BorderPane of the game.
     */
    BorderPane borderPane;

    /**
     * This field represents the AnimationTimer of the game.
     */
    AnimationTimer animationTimer;

    /**
     * This constructor creates an instance of PauseCommand with specified BorderPane and AnimationTimer.
     * @param borderPane the BorderPane of the game
     * @param animationTimer the AnimationTimer of the game
     */
    public PauseCommand(BorderPane borderPane, AnimationTimer animationTimer){
        this.borderPane = borderPane;
        this.animationTimer = animationTimer;
    }

    /**
     * This method executes the command.
     * The command is executed by calling specified AnimationTimer's stop() method.
     */
    @Override
    public void execute() {
        animationTimer.stop();
    }
}
