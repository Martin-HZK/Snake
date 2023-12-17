package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

/**
 * This class represents a controller for info.fxml.
 * It defines the method for switching to startMain.fxml.
 */
public class InfoController {

    /**
     * Switch to startMain.fxml.
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }
}
