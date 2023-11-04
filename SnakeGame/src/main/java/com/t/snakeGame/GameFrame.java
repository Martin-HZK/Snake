package com.snakeGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    @Override
    public void start(Stage primaryStage) {
        GamePanel gamePanel = new GamePanel();
        Scene scene = new Scene(gamePanel);

        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

