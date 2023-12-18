package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
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

    /**
     * The snake game image.
     */
    @FXML
    ImageView snakeGame;

    /**
     * Initialize the snake game image.
     */
    @FXML
    private void initialize() {
        Image image = new Image(new File("src/main/resources/images/snake.gif").toURI().toString());
        snakeGame.setImage(image);
    }
}
