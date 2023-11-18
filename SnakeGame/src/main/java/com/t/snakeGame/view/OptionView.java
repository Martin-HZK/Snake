package com.t.snakeGame.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

import static com.t.snakeGame.view.PlayingView.SCREEN_WIDTH;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;

public class OptionView {

    private static Scene optionScene;
    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static Color snakeColor = Color.GREEN;
    public OptionView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/view/optionView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

//    public static void drawExampleSnake(Canvas canvas) {
//        GraphicsContext g = canvas.getGraphicsContext2D();
//        int bodyParts = 6;
//
//        for(int i = 0; i< bodyParts;i++) {
//            if(i == 0) {
//                g.setFill(Color.GREEN);
//                g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE); // ugly coding!!!!!
//            }
//            else {
//                g.setFill(new Color(45.0/255,180.0/255,0,  1.0));
//                g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE);
//            }
//        }
//    }

}
