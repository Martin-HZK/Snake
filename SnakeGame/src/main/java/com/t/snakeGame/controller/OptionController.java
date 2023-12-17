package com.t.snakeGame.controller;

import com.t.snakeGame.view.PlayingView;
import javafx.event.ActionEvent;
import com.t.snakeGame.Main;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.io.*;

/**
 * This class represents a controller for option.fxml.
 * It defines the method for switching to startMain.fxml.
 */
public class OptionController {

    /**
     * The snake color picker. The user can select the color of the snake.
     */
    @FXML
    private ColorPicker snakeColor = new ColorPicker(Color.GREEN);
    /**
     * The text color picker. The user can select the color of the text.
     */
    @FXML
    private ColorPicker textColor = new ColorPicker(Color.valueOf("#fc310d"));
    @FXML
    private Canvas snakeCanvas;

    /**
     * Switch to Main window
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }

    /**
     * Listen to the color picker and change the color of the snake and the text.
     */
    @FXML
    public void initialize() {

        textColor.valueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                System.out.println(newValue.toString());
                String newColor = toHex(newValue.toString());
                System.out.println(newColor);

                Main.cssStyle = "-fx-text-fill: " + newColor + ";"+ "-fx-background-color: #000000;"; // do we need getter and setter?
                Main.getRoot().setStyle(Main.cssStyle);

                Main.saveUserSetting(newColor, "#000000");


            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        snakeColor.valueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                System.out.println(newValue.toString());
                String newColor = toHex(newValue.toString());
                System.out.println(newColor);

                PlayingView.setSnakeColor(newColor);


            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    /**
     * This method converts the color from argb to hex.
     * @param argb the color in argb
     * @return the color in hex
     */
    public String toHex(String argb) {
        return "#" + argb.substring(2, 8);
    }


    public void onClickDefaultSetting() throws IOException {
        Main.cssStyle = "-fx-text-fill: #fc310d;-fx-background-color: #000000";
        Main.getRoot().setStyle(Main.cssStyle);
        Main.saveUserSetting("#fc310d", "#000000");
    }



}
