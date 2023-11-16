package com.t.snakeGame;

import com.t.snakeGame.controller.ScoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Scene scene;

    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/startMain.fxml"));
        Parent root = loader.load();

        scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
//    public static void setScoreRoot(String fxml, boolean isScoreWindow, int score) throws IOException {
//        if (isScoreWindow) {
//            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
//            Parent root = fxmlLoader.load();
//            ScoreController scoreController = fxmlLoader.getController();
//            scoreController.setReceivedData(score);
//            scene.setRoot(root);
////            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
////            ScoreController scoreController = fxmlLoader.getController();
////            scoreController.setReceivedData(score);
//        }else{
////            scene.setRoot(loadFXML(fxml));
//        }
////        scene.setRoot(loadFXML(fxml));
//    }


}
