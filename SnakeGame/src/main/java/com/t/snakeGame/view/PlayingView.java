package com.t.snakeGame.view;

import com.t.snakeGame.model.apple.RedApple;
import com.t.snakeGame.model.snake.NormalSnake;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayingView extends BorderPane {
    private RedApple apple;
    private NormalSnake snake;

    public static String getSnakeColor() {
        System.out.println(snakeColor);
        return snakeColor;
    }

    public static void setSnakeColor(String snakeColor) {
        PlayingView.snakeColor = snakeColor;
    }

    private static String snakeColor = "0x00FF00FF";
    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;
    public static final int CANVAS_WIDTH = 1300;
    public static final int CANVAS_HEIGHT = 700;
    public static final int UNIT_SIZE = 25;

    public static final int GAME_UNITS = (CANVAS_WIDTH*CANVAS_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);


}
