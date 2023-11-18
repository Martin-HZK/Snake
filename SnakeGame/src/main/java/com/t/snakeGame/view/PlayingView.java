package com.t.snakeGame.view;

import com.t.snakeGame.controller.MainController;
import com.t.snakeGame.model.Apple;
import com.t.snakeGame.model.Snake;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

        StackPane stackPane = new StackPane();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/view/playingView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);


        playingStage.setTitle("Snake");
        playingStage.setScene(scene);
        playingStage.show();
    }

//    public void draw(GraphicsContext g) {
//        if(snake.isRunning()) { // do we need to change the name of the method
//            g.setFill(Color.RED);
//            g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);
//
//            for(int i = 0; i< snake.getBodyParts();i++) {
//                if(i == 0) {
//                    g.setFill(Color.GREEN);
//                    g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE); // ugly coding!!!!!
//                }
//                else {
//                    g.setFill(new Color(45.0/255,180.0/255,0,  1.0));
//                    g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE);
//                }
//            }
//            g.setFill(Color.RED);
//            g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
//            g.fillText("Score: "+apple.getApplesEaten(), (SCREEN_WIDTH - ("Score: "+apple.getApplesEaten()).length()*10)/2, g.getFont().getSize());
//        }
//        else {
//            gameOver(g);
//            timer.stop();
//        }
//    }



}
