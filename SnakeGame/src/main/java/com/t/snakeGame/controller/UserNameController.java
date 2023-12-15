package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.score.PlayScore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserNameController {
    @FXML
    private TextField username;

    PlayScore playerScore;
    public void switchOnPlayClick(ActionEvent actionEvent) throws IOException {
        playerScore.setPlayerName(username.getText());
        Main.setRoot("/com.t.snakeGame/view/playingView");
    }
}
