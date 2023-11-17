package com.t.snakeGame.controller;

import javafx.event.ActionEvent;
import com.t.snakeGame.Main;
import javafx.fxml.FXML;

import java.io.IOException;

public class OptionController {

    @FXML
//    private

    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }

    @FXML
    public void initialize() {

    }


}
