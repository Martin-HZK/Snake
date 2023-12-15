package com.t.snakeGame.controller;

import com.t.snakeGame.view.PlayingView;
import javafx.event.ActionEvent;
import com.t.snakeGame.Main;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.io.*;

public class OptionController {

    @FXML
    private ColorPicker snakeColor = new ColorPicker(Color.GREEN);
    @FXML
    private ColorPicker textColor = new ColorPicker(Color.valueOf("#fc310d"));
    @FXML
    private Canvas snakeCanvas;

//    private boolean cssAdd = true; // false- add style.css, true- add dynamicStyle.css
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
