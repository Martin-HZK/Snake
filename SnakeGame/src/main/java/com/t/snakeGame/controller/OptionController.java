package com.t.snakeGame.controller;

import javafx.event.ActionEvent;
import com.t.snakeGame.Main;

import java.io.IOException;

public class OptionController {
    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }
}
