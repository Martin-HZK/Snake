package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.apple.RedApple;
import com.t.snakeGame.model.snake.NormalSnake;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class represents a controller for main.fxml.
 * It defines the method for switching to info.fxml, userName.fxml, option.fxml and score.fxml.
 */
public class MainController {
    private Stage stage;
    private RedApple apple;
    private NormalSnake snake;




    /**
     * Switch to Info window
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnInfoClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/infoView");
    }

    /**
     * Switch to userName collecting window
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnStartClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/userNameView");
    }

    /**
     * Switch to option window
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnOptionClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/optionView");
    }


    /**
     * Switch to score window
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnScoreBoard(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/view/scoreView");
    }
}
