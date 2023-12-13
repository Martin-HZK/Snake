package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
//import com.t.snakeGame.model.Apple;
//import com.t.snakeGame.model.Snake;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
//    private Apple apple;
//    private Snake snake;

//    public MainController(Stage currentStage, Apple a, Snake s) {
//        stage = currentStage;
//        apple = a;
//        snake = s;
//    }



    public void switchOnInfoClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/infoView");
    }

    public void switchOnStartClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/playingView");
    }

    public void switchOnOptionClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/optionView");
    }
}
