package com.t.snakeGame.view;

import com.t.snakeGame.controller.MainController;
import com.t.snakeGame.model.Apple;
import com.t.snakeGame.model.Snake;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayingView extends StackPane {
    private Apple apple;
    private Snake snake;
    private MainController controller;
    private Stage playingStage;
    private static Scene mainScene;
    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;

    public PlayingView(Apple newApple, Snake newSnake, MainController newController) throws Exception{
        apple = newApple;
        snake = newSnake;
        controller = newController;

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