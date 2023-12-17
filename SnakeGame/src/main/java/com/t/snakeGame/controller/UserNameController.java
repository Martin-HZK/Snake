package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScoreSubscriber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * This class represents a controller for userName.fxml.
 */
public class UserNameController {
    /**
     * The username text field.
     */
    @FXML
    private TextField username;

    /**
     * player score publisher
     */
    PlayScorePublisher playerScorePublisher = PlayScorePublisher.getInstance();


    /**
     * Switch to playingView and add the player to the publisher.
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnPlayClick(ActionEvent actionEvent) throws IOException {
        playerScorePublisher.addSubscriber(new ScoreSubscriber(username.getText(), "0")); // we primitive set it to 0
        Main.setRoot("/com.t.snakeGame/view/playingView");
    }
}
