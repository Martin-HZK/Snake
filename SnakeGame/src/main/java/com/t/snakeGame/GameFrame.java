package com.t.snakeGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;
//import javax.swing.JFrame;

//public class GameFrame extends JFrame  {
//
//     GameFrame(){
//
//        this.add(new GamePanel());
//        this.setTitle("Snake");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);
//        this.pack();
//        this.setVisible(true);
//        this.setLocationRelativeTo(null);
//
//     }
//}

// TODO: implement in javafx

public class GameFrame extends Application{
    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 10;
    int count = 0;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    AnimationTimer timer;
    Random random = new Random();
    @Override
    public void start(Stage primaryStage) throws Exception{
//        GamePanel gamePanel = new GamePanel();
//        Scene scene = new Scene(gamePanel);
//
//        primaryStage.setTitle("Snake");
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.show();


        Pane root = new StackPane();
        Scene playingScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();



        playingScene.setFill(Color.BLACK);
        primaryStage.setScene(playingScene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.show();

        newApple();

        running = true;

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                count++;

                if (count == 0) {
                    if (running) {
                        move();
                        checkApple();
                        checkCollisions();
                        gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                        System.out.println("We move");
                    }
                    draw(gc);
                    return;
                }

                if (count > DELAY){
                    if (running) {
                        move();
                        checkApple();
                        checkCollisions();
                        gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                        System.out.println("We move");
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
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        });



    }
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void draw(GraphicsContext g) {
        if(running) {
            g.setFill(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< bodyParts;i++) {
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
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        System.out.println("The direction is" + direction);

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(GraphicsContext g) {
        //Score
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free",FontWeight.BOLD, 40));// Font.font("Ink Free", FontWeight.BOLD, 40)
//		FontMetrics metrics1 = g.getFontMetrics();
        g.fillText("Score: "+applesEaten, (SCREEN_WIDTH - ("Score: "+applesEaten).length() * 10)/2, g.getFont().getSize());
        //Game Over text
        g.setFill(Color.RED);
        g.setFont(Font.font("Ink Free",FontWeight.BOLD, 75));
//		FontMetrics metrics2 = g.getFontMetrics();
        g.fillText("Game Over lol get rekt", (SCREEN_WIDTH - ("Game Over lol get rekt").length() * 10)/2, SCREEN_HEIGHT/2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

