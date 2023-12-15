package com.t.snakeGame;

import com.google.gson.JsonArray;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScorePublisher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class Main extends Application {

    public static Scene scene;
    public static String cssStyle = "-fx-text-fill: #fc310d;-fx-background-color: #000000";
    String bgColor;
    String txtFill;


    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        loadUserSetting(); // load user setting for color from json file

        PlayScorePublisher playScorePublisher = PlayScorePublisher.getInstance(); // create the global Publisher

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/startMain.fxml"));
        Parent root = loader.load();
        root.setStyle(cssStyle);
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
//        String cssStyle = scene.getRoot().getStyle();
//        System.out.println(cssStyle);
        scene.setRoot(loadFXML(fxml));
        scene.getRoot().setStyle(cssStyle);
    }
    public static Scene getScene() {
        return scene;
    }
    public static Parent getRoot() {
        return scene.getRoot();
    }

    public void loadUserSetting() {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/UserSetting.json"));
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonObject userSettingColor = jsonObject.getAsJsonObject("user_setting_color");
            bgColor = userSettingColor.get("bgColor").getAsString();
            txtFill = userSettingColor.get("txtFill").getAsString();
            System.out.println(bgColor);
            System.out.println(txtFill);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("json file not found");
        }
        cssStyle = "-fx-text-fill: " + txtFill + ";-fx-background-color: " + bgColor;
    }

    public static void saveUserSetting(String txtFill, String bgColor) {
        Gson gson = new Gson();
        //Invariants
        JsonObject defaultUserSettingColor = new JsonObject();
        JsonArray userScore = new JsonArray();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/UserSetting.json"));
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            defaultUserSettingColor = jsonObject.getAsJsonObject("default_color");
            userScore = jsonObject.getAsJsonArray("user_score");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found");
        }





        JsonObject userSetting = new JsonObject();
        userSetting.add("default_color", defaultUserSettingColor);
        userSetting.add("user_score", userScore);


        JsonObject userSettingColor = new JsonObject();
        userSettingColor.addProperty("bgColor", bgColor);
        userSettingColor.addProperty("txtFill", txtFill);
        userSetting.add("user_setting_color", userSettingColor);

        try {
            FileWriter writer = new FileWriter("src/main/resources/UserSetting.json");
            writer.write(gson.toJson(userSetting));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("json file not found");
        }
    }
}
