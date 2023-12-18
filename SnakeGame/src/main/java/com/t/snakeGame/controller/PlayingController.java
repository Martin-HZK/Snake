package com.t.snakeGame.controller;

import com.t.snakeGame.Main;
import com.t.snakeGame.model.apple.*;
import com.t.snakeGame.model.eatChecker.BonusEatChecker;
import com.t.snakeGame.model.eatChecker.NormalEatChecker;
import com.t.snakeGame.model.eatChecker.UnknownEatChecker;
import com.t.snakeGame.model.gamePause.Command;
import com.t.snakeGame.model.gamePause.PauseCommand;
import com.t.snakeGame.model.gamePause.ResumeCommand;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.snake.NormalSnakeCreator;
import com.t.snakeGame.model.snake.NormalSnake;
import com.t.snakeGame.view.PlayingView;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


/**
 * This class represents a controller for playingView.fxml.
 * It defines the method for switching to scoreView.fxml.
 */
public class PlayingController {
    /**
     * The snake.
     */
    private NormalSnake snake;
    /**
     * The red apple.
     */
    private RedApple apple;
    /**
     * The unknown apple.
     */
    private UnknownApple unknownApple;

    /**
     * The bonus apple.
     */
    private BonusApple bonusApple;

    private int totalScore = 0;
    /**
     * The timer.
     */
    AnimationTimer timer;

    /**
     * The counter for timer
     */
    int count = 0;

    /**
     * The delay for timer
     */
    static final int DELAY = 10;
    /**
     * The play score publisher.
     */
    PlayScorePublisher playScorePublisher = PlayScorePublisher.getInstance(); // this is for storing the score in the game, should be the same for the whole game

    /**
     * The game canvas.
     */
    @FXML
    private Canvas playingCanvas;

    /**
     * The pause button image
     */
    @FXML
    private ImageView pauseButton;

    /**
     * The resume button image
     */
    @FXML
    private ImageView resumeButton;

    /**
     * The game scene.
     */
    @FXML
    private BorderPane gameScene;


    PlayingView playingView;
    /**
     * Initialize the game with the apple and the snake. The timer is also initialized for the snake motion.
     * Accept the key input from the user.
     */
    @FXML
    public void initialize() {

        playingCanvas.getHeight();
        playingCanvas.getWidth();
        Image pauseImage = new Image(getClass().getResourceAsStream("/images/pauseButton.jpg"));
        pauseButton.setImage(pauseImage);


        Image resumeImage = new Image(getClass().getResourceAsStream("/images/playButton.jpg"));
        resumeButton.setImage(resumeImage);

        RedAppleCreator redAppleCreator = new RedAppleCreator();
        UnknownAppleCreator unknownAppleCreator = new UnknownAppleCreator();
        BonusAppleCreator bonusAppleCreator = new BonusAppleCreator();
        NormalSnakeCreator snakeCreator = new NormalSnakeCreator();

        playingView = new PlayingView(this);

        gameScene.setFocusTraversable(true);
        snake = snakeCreator.createSnake();

        apple = redAppleCreator.createApple(200, 200);
        unknownApple = unknownAppleCreator.createApple(1000, 550);
        bonusApple = bonusAppleCreator.createApple(400, 400);
        ScoreController.playingScore.bind(apple.applesEaten);
        playingView.initializeCanvas();
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                count++;

                BonusEatChecker bonusEatChecker = new BonusEatChecker(snake, bonusApple);
                NormalEatChecker normalEatChecker = new NormalEatChecker(snake, apple);
                UnknownEatChecker unknownEatChecker = new UnknownEatChecker(snake, unknownApple);
                if (count == 0 || count > DELAY) {
                    if (snake.isRunning()) {
                        snake.move();
                        normalEatChecker.check();
                        unknownEatChecker.check();
                        bonusEatChecker.check();

                        playingView.clearWindow();
                    }
                    playingView.draw(timer);

                    if (count > DELAY)
                        count = 0;
                }
            }
        };
        timer.start();

        Command pauseCommand = new PauseCommand(gameScene, timer);
        Command resumeCommand = new ResumeCommand(gameScene, timer);
        pauseButton.setOnMouseClicked(e -> {
            pauseCommand.execute();
        });
        resumeButton.setOnMouseClicked(e -> {
            resumeCommand.execute();
        });

        Main.scene.setOnKeyPressed(e -> {
                    switch ((e.getCode())) {
                        case LEFT:
                            if (snake.getDirection() != 'R') {
                                snake.setDirection('L');
                            }
                            break;
                        case RIGHT:
                            if (snake.getDirection() != 'L') {
                                snake.setDirection('R');
                            }
                            break;
                        case UP:
                            if (snake.getDirection() != 'D') {
                                snake.setDirection('U');
                            }
                            break;
                        case DOWN:
                            if (snake.getDirection() != 'U') {
                                snake.setDirection('D');
                            }
                            break;
                    }
                }
        );
    }

    /**
     * This is the getter method for the snake.
     */
    public NormalSnake getSnake() {
        return snake;
    }

    /**
     * This is the setter method for the snake.
     */
    public void setSnake(NormalSnake snake) {
        this.snake = snake;
    }

    /**
     * This is the getter method for the red apple.
     */
    public RedApple getApple() {
        return apple;
    }

    /**
     * This is the setter method for the red apple.
     */
    public void setApple(RedApple apple) {
        this.apple = apple;
    }

    /**
     * This is the getter method for the unknown apple.
     */
    public UnknownApple getUnknownApple() {
        return unknownApple;
    }

    /**
     * This is the setter method for the unknown apple.
     */
    public void setUnknownApple(UnknownApple unknownApple) {
        this.unknownApple = unknownApple;
    }

    /**
     * This is the getter method for the bonus apple.
     */
    public BonusApple getBonusApple() {
        return bonusApple;
    }

    /**
     * This is the setter method for the bonus apple.
     */
    public void setBonusApple(BonusApple bonusApple) {
        this.bonusApple = bonusApple;
    }

    /**
     * This is the getter method for the total score.
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * This is the setter method for the total score.
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * This is the getter method for the playing canvas.
     */
    public Canvas getPlayingCanvas() {
        return playingCanvas;
    }

}
