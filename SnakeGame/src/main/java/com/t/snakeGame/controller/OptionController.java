package com.t.snakeGame.controller;

import com.t.snakeGame.model.Snake;
import com.t.snakeGame.view.OptionView;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import com.t.snakeGame.Main;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Random;

public class OptionController {

    @FXML
    private ColorPicker snakeColor = new ColorPicker(Color.GREEN);
    @FXML
    private ColorPicker textColor = new ColorPicker(Color.valueOf("#fc310d"));
    @FXML
    private Canvas snakeCanvas;

    private boolean cssAdd = true; // false- add style.css, true- add dynamicStyle.css
    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }

    @FXML
    public void initialize() {
        textColor.valueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                System.out.println(newValue.toString());
                String newColor = toHex(newValue.toString());
                System.out.println(newColor);
                System.out.println(newValue.toString());

//                Main.scene.getStylesheets().clear();
//                Main.scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
                Platform.runLater(() -> {
                    Main.scene.getStylesheets().clear();
                    try {
                        if (cssAdd) {
                            updateDynamicStyle(newColor);
                            Main.scene.getStylesheets().add("/dynamicStyle.css");
                        } else {
                            String css = readCSSFile("src/main/resources/style.css");
                            css = updateCSSColor(css, ".label", "-fx-text-fill", newColor);
                            writeCSSFile("src/main/resources/style.css", css);
                            Main.scene.getStylesheets().add("/style.css");
                        }
                        cssAdd = !cssAdd;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
//                Main.scene.getStylesheets().clear();
//                if (cssAdd) {
//                    updateDynamicStyle(newColor);
//                    Main.scene.getStylesheets().add("/dynamicStyle.css");
//                }
//                else {
//                String css = readCSSFile("src/main/resources/style.css");
//
//                css = updateCSSColor(css, ".label", "-fx-text-fill", newColor);
//                writeCSSFile("src/main/resources/style.css", css);
//                    Main.scene.getStylesheets().add("/style.css");
//                }
//                cssAdd = !cssAdd;

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
    private void updateDynamicStyle(String newColor) throws IOException{
        try {
            String dynamicCSS = readCSSFile("src/main/resources/dynamicStyle.css");
            dynamicCSS = updateCSSColor(dynamicCSS, ".label", "-fx-text-fill", newColor);
            writeCSSFile("src/main/resources/dynamicStyle.css", dynamicCSS);
       } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toHex(String argb) {
        return "#" + argb.substring(2, 8);
    }

    private static String readCSSFile(String cssPath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(cssPath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();
        return content.toString();
    }
    private static String updateCSSColor(String originalCSS, String selector, String property, String newValue) throws IOException {

        String returnStr = originalCSS.replaceAll(selector + "\\s*\\{\\s*" + property + "\\s*:\\s*#[0-9A-Fa-f]{6};", selector + " { " + property + ": " + newValue + ";");

        System.out.println("The return string is " + returnStr);
        return returnStr;
    }

    private static void writeCSSFile(String cssPath, String cssContent) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(cssPath));
//        System.out.println("we write");
//        System.out.println(cssContent);
        bufferedWriter.write(cssContent);
        bufferedWriter.close();
    }

}
