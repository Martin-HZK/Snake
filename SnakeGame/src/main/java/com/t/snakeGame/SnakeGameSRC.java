//package com.t.snakeGame;
//
//import Model.Apple;
//import Model.Snake;
//import View.MainView;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//public class SnakeGameSRC extends Application {
//    static final int SCREEN_WIDTH = 1300;
//    static final int SCREEN_HEIGHT = 750;
//    public static void main(String[]args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/com.t.snakeGame/startMain.fxml"));
//            Parent root = loader.load();
//
////            Apple originApple = new Apple();
////            Snake snake = new Snake();
////            Controller.MainController mainController = new Controller.MainController();
////            MainView view = new MainView(originApple, snake, mainController);
//            Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
//            stage.setTitle("Snake");
//            stage.setScene(scene);
//            stage.show();
//    }
//}
