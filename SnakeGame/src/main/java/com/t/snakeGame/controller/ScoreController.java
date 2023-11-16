package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ScoreController {

    public static IntegerProperty playingScore = new SimpleIntegerProperty(0);
    @FXML
    private Label totalScore;
    @FXML
    public void initialize() {
//        System.out.println("ScoreController initialized");


        System.out.println("The score is: " + playingScore.get());
        totalScore.setText(playingScore.get()+ "");
//        if ()

    }

//    public void setReceivedData(int score) {
//        this.playingScore = score;
//    }

//    public static ScoreController getScoreController(String fxml) throws NullPointerException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.getController();
//    }
}
