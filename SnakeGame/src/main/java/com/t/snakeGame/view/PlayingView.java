package com.t.snakeGame.view;

import com.t.snakeGame.Main;
import com.t.snakeGame.controller.PlayingController;
import com.t.snakeGame.model.apple.BonusApple;
import com.t.snakeGame.model.apple.RedApple;
import com.t.snakeGame.model.apple.UnknownApple;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScoreSubscriber;
import com.t.snakeGame.model.snake.NormalSnake;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import java.io.IOException;

public class PlayingView extends BorderPane {
    /**
     * The red apple.
     */
    private RedApple redApple;

    /**
     * The bonus apple.
     */
    private BonusApple bonusApple;

    /**
     * The unknown apple.
     */
    private UnknownApple unknownApple;

    /**
     * The snake.
     */
    private NormalSnake snake;




    /**
     * This is the color of the snake.
     */
    private static String snakeColor = "0x00FF00FF";

    /**
     * This is the width of the canvas.
     */
    public static final int CANVAS_WIDTH = 1300;

    /**
     * This is the height of the canvas.
     */
    public static final int CANVAS_HEIGHT = 700;

    /**
     * This is the concrete size of each unit in the canvas.
     */
    public static final int UNIT_SIZE = 25;

    /**
     * This is the number of units in the canvas.
     */
    public static final int GAME_UNITS = (CANVAS_WIDTH*CANVAS_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);

    /**
     * The canvas.
     */
    private Canvas canvas;

    /**
     * The playing controller.
     */
    private PlayingController playingController;

    /**
     * The play score publisher. This is the same among all the views.
     */
    private PlayScorePublisher playScorePublisher = PlayScorePublisher.getInstance();

    /**
     * Constructor for PlayingView.
     * We take the playing controller as parameter and instantiate the snake, apples and canvas.
     * @param playingController the playing controller
     */
    public PlayingView(PlayingController playingController) {

        this.playingController = playingController;
        this.redApple = playingController.getApple();
        this.bonusApple = playingController.getBonusApple();
        this.unknownApple = playingController.getUnknownApple();
        this.snake = playingController.getSnake();
        this.canvas = playingController.getPlayingCanvas();
    }


    /**
     * This method draws the snake and apples on the canvas and return the new total score at the moment.
     * @param timer the timer
     */
    public void draw(AnimationTimer timer) {

        refreshItems();
        Color snakeColor = Color.valueOf(PlayingView.getSnakeColor());
        Color snakeTail;
        GraphicsContext g = canvas.getGraphicsContext2D();
        if (snakeColor == Color.GREEN) {
            snakeTail = new Color(45.0 / 255, 180.0 / 255, 0, 1.0);
        } else if (snakeColor == Color.RED) {
            snakeTail = new Color(180.0 / 255, 0, 45 / 255, 1.0);
        } else if (snakeColor == Color.BLUE) {
            snakeTail = new Color(0, 45 / 255, 180.0 / 255, 1.0);
        } else {
            snakeTail = snakeColor.darker();
        }
        if (snake.isRunning()) { // do we need to change the name of the method
            remainApplesState(g);
            for (int i = 0; i < snake.getBodyParts(); i++) {
                if (i == 0) {
                    g.setFill(snakeColor);

                    g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE); // ugly coding!!!!!
                } else {

                    g.setFill(snakeTail);
                    g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setFill(Color.RED);
            g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
            playingController.setTotalScore(redApple.getApplesEaten() + unknownApple.getApplesEaten() + bonusApple.getApplesEaten());
//            totalScore =
            g.fillText("Score: " + playingController.getTotalScore(), (CANVAS_WIDTH - ("Score: " + redApple.getApplesEaten()).length() * 10) / 2, g.getFont().getSize());
        } else {
            gameOver(g, playingController.getTotalScore());
            timer.stop();
        }
//        return totalScore;
    }


    /**
     * This method draws the game over screen.
     * @param g the graphics context
     * @param totalScore the total score
     */
    public void gameOver(GraphicsContext g, int totalScore) {
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));// Font.font("Ink Free", FontWeight.BOLD, 40)
        g.fillText("Score: " + playingController.getTotalScore(), (CANVAS_WIDTH - ("Score: " + this.redApple.getApplesEaten()).length() * 10) / 2, g.getFont().getSize());
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free", FontWeight.BOLD, 75));
        g.fillText("Game Over lol get rekt", (CANVAS_WIDTH - ("Game Over lol get rekt").length() * 35) / 2, CANVAS_HEIGHT / 2);
        PauseTransition pause = new PauseTransition(Duration.seconds(3)); // 3 seconds

        pause.setOnFinished(event -> {

            ScoreSubscriber newScore = playScorePublisher.getLastSubscriber();
            playScorePublisher.updateLastScore(Integer.toString(totalScore));
            newScore.update();// this is for storing into the json file
            playScorePublisher.addSubscriber(newScore);
            try {
                switchToScore();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pause.play();
    }


    /**
     * This method initializes the canvas.
     */
    public void initializeCanvas() {
            refreshItems();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

            remainApplesState(gc);
        }

    /**
     * This method clear the items drawn on the graphics context.
     */
    public void clearWindow() {
            refreshItems();
            canvas.getGraphicsContext2D().clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        }

    /**
     * Refresh items. This will update the apple and snake state from the controller each time we are doing drawing.
     */
    private void refreshItems() {
            redApple = playingController.getApple();
            bonusApple = playingController.getBonusApple();
            unknownApple = playingController.getUnknownApple();
            snake = playingController.getSnake();
    }

    /**
     * This method remain the state of the 3 types of apples and draw them on the graphics context.
     * @param g
     */
    private void remainApplesState(GraphicsContext g) {
        g.setFill(Color.RED);
        g.fillOval(redApple.getAppleX(), redApple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

        g.setFill(Color.YELLOW);
        g.fillOval(bonusApple.getAppleX(), bonusApple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

        g.setFill(Color.PURPLE);
        g.fillOval(unknownApple.getAppleX(), unknownApple.getAppleY(), UNIT_SIZE, UNIT_SIZE);
    }

    /**
     * This method get the snake color.
     */
    public static String getSnakeColor() {
        return snakeColor;
    }

    /**
     * This method set the snake color. This is the static field.
     * @param snakeColor the snake color
     */
    public static void setSnakeColor(String snakeColor) {
        PlayingView.snakeColor = snakeColor;
    }

    /**
     * Switch to score window
     * @throws IOException the io exception
     */
    public void switchToScore() throws IOException {
        Main.setRoot("/com.t.snakeGame/view/scoreView");
    }

}
