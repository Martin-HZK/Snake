package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ScoreController {

    public static IntegerProperty playingScore = new SimpleIntegerProperty(0);
    @FXML
    private ImageView snakeLevel;
    @FXML
    private Label totalScore;
    @FXML
    public void initialize() {
        totalScore.setText(playingScore.get()+ "");
//        if (playingScore.get() < 5) {
//            Image rookie = new Image(getClass().getResourceAsStream("/com.t.snakeGame/image/Rookie.png"));
//            snakeLevel.setImage(rookie);
//        }

    }

    public void switchOnRestartClick() throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }
}
