package com.t.snakeGame.model.gamePause;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;

public class ResumeCommand implements Command{
    private BorderPane borderPane;
    private AnimationTimer animationTimer;
    public ResumeCommand(BorderPane borderPane, AnimationTimer animationTimer){
        this.borderPane = borderPane;
        this.animationTimer = animationTimer;
    }
    @Override
    public void execute() {
//        borderPane.setDisable(false);
        animationTimer.start();
    }

}
