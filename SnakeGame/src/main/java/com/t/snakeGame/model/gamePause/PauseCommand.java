package com.t.snakeGame.model.gamePause;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.BorderPane;

public class PauseCommand implements Command{
    BorderPane borderPane;
    AnimationTimer animationTimer;
    public PauseCommand(BorderPane borderPane, AnimationTimer animationTimer){
        this.borderPane = borderPane;
        this.animationTimer = animationTimer;
    }
    @Override
    public void execute() {
//        borderPane.setDisable(true);
        animationTimer.stop();
    }
}
