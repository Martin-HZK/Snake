package com.t.snakeGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SnakeGameSRC extends Application {
    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource/gameFrame.fxml"));
        Pane root = loader.load();//
        new GameFrame();
    }
}
