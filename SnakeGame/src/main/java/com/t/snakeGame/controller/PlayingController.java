package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.Apple;
import com.t.snakeGame.model.Snake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;

import static com.t.snakeGame.view.PlayingView.*;

public class PlayingController {
//    static final int SCREEN_WIDTH = 1300;
//    static final int SCREEN_HEIGHT = 750;
    private Snake snake;
    private Apple apple;
    @FXML
    private Canvas playingCanvas;
    @FXML
    public void initialize() {
        snake = new Snake();
        apple = new Apple(10,10); // we just initialize like this

        GraphicsContext gc = playingCanvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        gc.setFill(Color.RED);
        gc.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

    }

    public void draw(GraphicsContext g) {
        if(snake.runningProperty().get()) { // do we need to change the name of the method
            g.setFill(Color.RED);
            g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< snake.bodyParts;i++) {
                if(i == 0) {
                    g.setFill(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setFill(new Color(45.0/255,180.0/255,0,  1.0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setFill(Color.RED);
            g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
            g.fillText("Score: "+applesEaten, (SCREEN_WIDTH - ("Score: "+applesEaten).length()*10)/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }
    }



//    public timer = new AnimationTimer() {
//        @Override
//        public void handle(long l) {
//            count++;
//
//            if (count == 0) {
//                if (running) {
//                    move();
//                    checkApple();
//                    checkCollisions();
//                    gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
//                }
//                draw(gc);
//                return;
//            }
//
//            if (count > DELAY){
//                if (running) {
//                    move();
//                    checkApple();
//                    checkCollisions();
//                    gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
//                }
//                draw(gc);
//                count = 0;
//            }
//        }
//    };
//        timer.start();
//
//        playingScene.setOnKeyPressed(e -> {
//        switch ((e.getCode())) {
//            case LEFT:
//                if(direction != 'R') {
//                    direction = 'L';
//                }
//                break;
//            case RIGHT:
//                if(direction != 'L') {
//                    direction = 'R';
//                }
//                break;
//            case UP:
//                if(direction != 'D') {
//                    direction = 'U';
//                }
//                break;
//            case DOWN:
//                if(direction != 'U') {
//                    direction = 'D';
//                }
//                break;
//        }
//    });

        public void gameOver(GraphicsContext g) {
        //Score
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));// Font.font("Ink Free", FontWeight.BOLD, 40)
//		FontMetrics metrics1 = g.getFontMetrics();
        g.fillText("Score: "+this.apple.getApplesEaten(), (SCREEN_WIDTH - ("Score: "+this.apple.getApplesEaten()).length() * 10)/2, g.getFont().getSize());
        //Game Over text
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free",FontWeight.BOLD, 75));
//		FontMetrics metrics2 = g.getFontMetrics();
        g.fillText("Game Over lol get rekt", (SCREEN_WIDTH - ("Game Over lol get rekt").length()*35)/2, SCREEN_HEIGHT/2);
    }


}
