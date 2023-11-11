package controller;

import model.Apple;
import model.Snake;
import view.Main;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Apple apple;
    private Snake snake;

    public MainController(Stage currentStage, Apple a, Snake s) {
        stage = currentStage;
        apple = a;
        snake = s;
    }

    public void switchOnInfoClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("infoView");
    }

    public void switchOnStartClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("playingView");
    }

    public void switchOnOptionClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("optionView");
    }
}
