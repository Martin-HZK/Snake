package com.t.snakeGame.view;

import com.t.snakeGame.controller.MainController;
import com.t.snakeGame.model.Apple;
import com.t.snakeGame.model.Snake;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayingView extends BorderPane {
    private Apple apple;
    private Snake snake;
//    private MainController controller;
    private Stage playingStage;
    private static Scene mainScene;
    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;
    public static final int UNIT_SIZE = 50;

    public static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);

    public PlayingView(Apple newApple, Snake newSnake) throws Exception{
        apple = newApple;
        snake = newSnake;
//        controller = newController;

        StackPane stackPane = new StackPane();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/view/playingView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);


        playingStage.setTitle("Snake");
        playingStage.setScene(scene);
        playingStage.show();
    }



}
