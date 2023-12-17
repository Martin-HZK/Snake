package com.t.snakeGame.model.gamePause;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;

/**
 * This class implements Command interface, representing a command for resuming the game.
 * The command is executed by calling the execute() method.
 * The execute() method calls specified AnimationTimer's start() method.
 */
public class ResumeCommand implements Command{
    /**
     * This field represents the BorderPane of the game.
     */
    private BorderPane borderPane;

    /**
     * This field represents the AnimationTimer of the game.
     */
    private AnimationTimer animationTimer;

    /**
     * This constructor creates an instance of ResumeCommand with specified BorderPane and AnimationTimer.
     * @param borderPane the BorderPane of the game
     * @param animationTimer the AnimationTimer of the game
     */
    public ResumeCommand(BorderPane borderPane, AnimationTimer animationTimer){
        this.borderPane = borderPane;
        this.animationTimer = animationTimer;
    }

    /**
     * This method executes the command.
     * The command is executed by calling specified AnimationTimer's start() method.
     */
    @Override
    public void execute() {
        animationTimer.start();
    }

}
