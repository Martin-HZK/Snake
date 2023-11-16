package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label playerLevel;
    @FXML
    public void initialize() {
        totalScore.setText(playingScore.get()+ "");
        try {
            if (playingScore.get() < 2) { // we set 5
                Image rookie = new Image(getClass().getResourceAsStream("/images/Rookie.jpg"));
                snakeLevel.setImage(rookie);
                playerLevel.setText("Novice Snake");
            } else if (playingScore.get() < 5) { // we set 20
                Image skilled = new Image(getClass().getResourceAsStream("/images/Skilled.jpg"));
                snakeLevel.setImage(skilled);
                playerLevel.setText("Skilled Serpent");
            } else if (playingScore.get() < 7) { // we set 30
                Image skilled = new Image(getClass().getResourceAsStream("/images/Expert.jpg"));
                snakeLevel.setImage(skilled);
                playerLevel.setText("Expert Python");
            } else {
                Image skilled = new Image(getClass().getResourceAsStream("/images/Master.jpg"));
                snakeLevel.setImage(skilled);
                playerLevel.setText("Master Viper");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchOnRestartClick() throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }
}
