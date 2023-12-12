package com.t.snakeGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Map;

public class Main extends Application {

    public static Scene scene;
    public static String cssStyle = "-fx-text-fill: #fc310d;-fx-background-color: #000000";

    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("/style.css"));
//            String line = reader.readLine();
//            System.out.println(line);
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("~/resources/com.t.snakeGame/UserSetting.json"));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("resources/com/t/snakeGame/UserSetting.json")));

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            Map<?, ?> map = gson.fromJson(jsonObject, Map.class);
            Object value = null;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey() == "user_setting_color") {
                     value = entry.getValue();
                     break;
                }
            }
            Map<String, String> userSettingColor = (Map<String, String>) value;
            String bgColor = userSettingColor.get("bgColor");
            String txtFill = userSettingColor.get("txtFill");
            System.out.println(bgColor);
            System.out.println(txtFill);

        } catch (IOException e) {
            e.printStackTrace();
        }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com.t.snakeGame/startMain.fxml"));
        Parent root = loader.load();
        root.setStyle(cssStyle);
        scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
//        scene.getStylesheets().add("/style.css");
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
}
