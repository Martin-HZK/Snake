package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserNameController {
    @FXML
    private TextField username;

    Score playerScore = new Score();
    public void switchOnPlayClick(ActionEvent actionEvent) throws IOException {
        playerScore.setPlayerName(username.getText());
        Main.setRoot("/com.t.snakeGame/view/playingView");
    }
}
