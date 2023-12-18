package com.t.snakeGame.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class InfoView {
    private static Scene infoScene;

    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    public InfoView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/view/playingView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
    }




}
