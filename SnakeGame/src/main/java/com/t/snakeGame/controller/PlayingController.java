package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.Apple;
import com.t.snakeGame.model.Snake;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
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
    AnimationTimer timer;
    int count = 0;
    static final int DELAY = 10;
    @FXML
    Canvas playingCanvas  = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
    @FXML
    BorderPane playingScene;
    @FXML
    public void initialize() {
        snake = new Snake();
        apple = new Apple(10,10); // we just initialize like this

        GraphicsContext gc = playingCanvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        gc.setFill(Color.RED);
        gc.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

        timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            count++;

            if (count == 0) {
                if (snake.isRunning()) {
                    snake.move();
                    apple.checkApple();
                    snake.checkCollisions();
                    gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                }
                draw(gc);
                return;
            }

            if (count > DELAY){
                if (snake.isRunning()) {
                    snake.move();
                    apple.checkApple();
                    snake.checkCollisions();
                    gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                }
                draw(gc);
                count = 0;
            }
        }
        };
        timer.start();

        playingScene.setOnKeyPressed(e -> {
        switch ((e.getCode())) {
            case LEFT:
                if(snake.getDirection() != 'R') {
                    snake.setDirection('L');
                }
                break;
            case RIGHT:
                if(snake.getDirection() != 'L') {
                    snake.setDirection('R');
                }
                break;
            case UP:
                if(snake.getDirection() != 'D') {
                    snake.setDirection('U');
                }
                break;
            case DOWN:
                if(snake.getDirection() != 'U') {
                    snake.setDirection('D');
                }
                break;
        }
    });

    }

    public void draw(GraphicsContext g) {
        if(snake.isRunning()) { // do we need to change the name of the method
            g.setFill(Color.RED);
            g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< snake.getBodyParts();i++) {
                if(i == 0) {
                    g.setFill(Color.GREEN);
                    g.fillRect(snake.getX()[i].get(), snake.getY()[i].get(), UNIT_SIZE, UNIT_SIZE); // ugly coding!!!!!
                }
                else {
                    g.setFill(new Color(45.0/255,180.0/255,0,  1.0));
                    g.fillRect(snake.getX()[i].get(), snake.getY()[i].get(), UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setFill(Color.RED);
            g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
            g.fillText("Score: "+apple.getApplesEaten(), (SCREEN_WIDTH - ("Score: "+apple.getApplesEaten()).length()*10)/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }
    }



//

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
