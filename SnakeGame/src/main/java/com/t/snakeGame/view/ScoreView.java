package com.t.snakeGame.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoreView {

    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;
    public static final int UNIT_SIZE = 50;
    private Stage playingStage;

    public static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    public ScoreView() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/view/playingView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);


        playingStage.setTitle("Snake");
        playingStage.setScene(scene);
        playingStage.show();
    }

    public void showScoreBoard() {

    }

}
