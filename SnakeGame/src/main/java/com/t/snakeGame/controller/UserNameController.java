package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.score.PlayScore;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScorePublisher;
import com.t.snakeGame.model.score.ScoreSubscriber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserNameController {
    @FXML
    private TextField username;

//    PlayScore playerScore = new PlayScore();
    PlayScorePublisher playerScorePublisher = PlayScorePublisher.getInstance();


    public void switchOnPlayClick(ActionEvent actionEvent) throws IOException {
//        playerScore.setPlayerName(username.getText());
        playerScorePublisher.addSubscriber(new ScoreSubscriber(username.getText(), "0")); // we primitive set it to 0
        Main.setRoot("/com.t.snakeGame/view/playingView");
    }
}
