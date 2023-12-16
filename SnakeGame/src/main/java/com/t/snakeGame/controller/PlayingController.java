package com.t.snakeGame.controller;

import com.google.gson.*;
import com.t.snakeGame.Main;
import com.t.snakeGame.model.apple.*;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScoreSubscriber;
import com.t.snakeGame.model.snake.NormalSnakeCreator;
import com.t.snakeGame.model.snake.NormalSnake;
import com.t.snakeGame.view.PlayingView;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.io.IOException;

import static com.t.snakeGame.view.PlayingView.*;

public class PlayingController {
    private NormalSnake snake;
    private RedApple apple;
    private UnknownApple unknownApple;
    AnimationTimer timer;
    int count = 0;

    static final int DELAY = 10;

    PlayScorePublisher playScorePublisher = PlayScorePublisher.getInstance(); // this is for storing the score in the game, should be the same for the whole game

    @FXML
    private Canvas playingCanvas;
    @FXML
    private BorderPane gameScene;
    @FXML
    public void initialize() {
        RedAppleCreator redAppleCreator = new RedAppleCreator();
        UnknownAppleCreator unknownAppleCreator = new UnknownAppleCreator();
        NormalSnakeCreator snakeCreator = new NormalSnakeCreator();
        gameScene.setFocusTraversable(true);
//        snake = new normalSnake();
        snake = snakeCreator.createSnake();

//        apple = new RedApple(200, 200); // we just initialize like this
        apple = redAppleCreator.createApple(200, 200);
        unknownApple = unknownAppleCreator.createApple(800, 650);
        ScoreController.playingScore.bind(apple.applesEaten);
        GraphicsContext gc = playingCanvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        gc.setFill(Color.RED);
        gc.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);


        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                count++;

                if (count == 0 || count > DELAY) {
                    if (snake.isRunning()) {
                        snake.move();
                        if (snake.getHeadX() == apple.getAppleX() && snake.getHeadY() == apple.getAppleY()) {
                            apple.setIsEaten(true);
                            snake.setBodyParts(snake.getBodyParts() + 1);
                        }
                        apple.checkApple();
                        snake.checkCollisions();
                        gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                    }
                    draw(gc);

                    if (count > DELAY)
                        count = 0;
//                    return;
                }


            }
        };
        timer.start();
        Main.scene.setOnKeyPressed(e -> {
                    switch ((e.getCode())) {
                        case LEFT:
                            if(snake.getDirection() != 'R') {
                                snake.setDirection('L');
                            }
                            break;
                        case RIGHT:
                            if(snake.getDirection()  != 'L') {
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
                }
        );
    }

    public void draw(GraphicsContext g) {
        Color snakeColor = Color.valueOf(PlayingView.getSnakeColor());
        Color snakeTail;
        if (snakeColor == Color.GREEN) {
            snakeTail = new Color(45.0/255, 180.0/255, 0, 1.0);
        } else if (snakeColor == Color.RED) {
            snakeTail = new Color(180.0/255, 0, 45/255, 1.0);
        } else if (snakeColor == Color.BLUE) {
            snakeTail = new Color(0, 45/255, 180.0/255, 1.0);
        } else {
            snakeTail = snakeColor.darker();
        }
        if(snake.isRunning()) { // do we need to change the name of the method
            g.setFill(Color.RED);
            g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< snake.getBodyParts();i++) {
                if(i == 0) {
                    g.setFill(snakeColor);

                    g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE); // ugly coding!!!!!
                }
                else {

                    g.setFill(snakeTail);
                    g.fillRect(snake.getX()[i], snake.getY()[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setFill(Color.RED);
            g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
            g.fillText("Score: "+apple.getApplesEaten(), (SCREEN_WIDTH - ("Score: "+apple.getApplesEaten()).length()*10)/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
            timer.stop();
        }
    }


    public void switchToScore() throws IOException {
//        System.out.println("in playing the score is: " + apple.getApplesEaten());
        Main.setRoot("/com.t.snakeGame/view/scoreView");
//        this.setReceivedData(apple.getApplesEaten());
    }


    /**
     * The score finally stored in json in this method
     * @param g
     */
    public void gameOver(GraphicsContext g) {
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));// Font.font("Ink Free", FontWeight.BOLD, 40)
        g.fillText("Score: "+this.apple.getApplesEaten(), (SCREEN_WIDTH - ("Score: "+this.apple.getApplesEaten()).length() * 10)/2, g.getFont().getSize());
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free",FontWeight.BOLD, 75));
        g.fillText("Game Over lol get rekt", (SCREEN_WIDTH - ("Game Over lol get rekt").length()*35)/2, SCREEN_HEIGHT/2);
        PauseTransition pause = new PauseTransition(Duration.seconds(3)); // 3 seconds

        pause.setOnFinished(event -> {

            ScoreSubscriber newScore = playScorePublisher.getLastSubscriber();
            playScorePublisher.updateLastScore(Integer.toString(apple.getApplesEaten()));
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

//    public void storeScore(int score) {
//        JsonArray userScores = new JsonArray();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Score.json"));
//            jsonObject= JsonParser.parseReader(reader).getAsJsonObject();
//            reader.close();
//            userScores = jsonObject.getAsJsonArray("scores");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JsonObject newScore = new JsonObject();
//        newScore.addProperty("name", "Anonymous");
//        newScore.addProperty("score", score);
//        userScores.add(newScore);
//        jsonObject.add("scores", userScores);
//        try {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            FileWriter writer = new FileWriter("src/main/resources/Score.json");
//            gson.toJson(jsonObject, writer);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
