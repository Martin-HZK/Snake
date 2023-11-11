package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

public class InfoController {

    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }
}
