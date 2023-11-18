package com.t.snakeGame.controller;

import javafx.event.ActionEvent;
import com.t.snakeGame.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.io.IOException;

public class OptionController {

    @FXML
    private ColorPicker snakeColor = new ColorPicker(Color.GREEN);
    @FXML
    private ColorPicker textColor = new ColorPicker(Color.valueOf("#fc310d"));

    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }

    @FXML
    public void initialize() {

    }


}
