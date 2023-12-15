package com.t.snakeGame.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.t.snakeGame.Main;
import com.t.snakeGame.model.PlayScore;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreController {

    public static IntegerProperty playingScore = new SimpleIntegerProperty(0);
    @FXML
    private ImageView snakeLevel;
    @FXML
    private Label totalScore;
    @FXML
    private Label playerLevel;

    @FXML
    private TableColumn<PlayScore, String> playerName;

    @FXML
    private TableColumn<PlayScore, String> playerScore;

    @FXML
    private TableView<PlayScore> scoreTable;

    @FXML
    public void initialize() {
        playerName.setCellValueFactory(new PropertyValueFactory<PlayScore, String>("playerName"));
        playerScore.setCellValueFactory(new PropertyValueFactory<PlayScore, String>("playerScore"));

        scoreTable.setItems(setScoreBoard());

        totalScore.setText(playingScore.get()+ "");
        try {
            if (playingScore.get() < 2) { // we set 5
                Image rookie = new Image(getClass().getResourceAsStream("/images/Rookie.jpg"));
                snakeLevel.setImage(rookie);
                playerLevel.setText("Novice Snake");
            } else if (playingScore.get() < 5) { // we set 20
                Image skilled = new Image(getClass().getResourceAsStream("/images/Skilled.jpg"));
                snakeLevel.setImage(skilled);
                playerLevel.setText("Skilled Serpent");
            } else if (playingScore.get() < 7) { // we set 30
                Image skilled = new Image(getClass().getResourceAsStream("/images/Expert.jpg"));
                snakeLevel.setImage(skilled);
                playerLevel.setText("Expert Python");
            } else {
                Image skilled = new Image(getClass().getResourceAsStream("/images/Master.jpg"));
                snakeLevel.setImage(skilled);
                playerLevel.setText("Master Viper");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        // load table

    }

    public void switchOnRestartClick() throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }

    public ObservableList<PlayScore> setScoreBoard() {
        JsonArray userScores = new JsonArray();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Score.json"));
            JsonObject jsonObject= JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            userScores = jsonObject.getAsJsonArray("scores");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userScores.size());
        ArrayList<PlayScore> scoreList = new ArrayList<>();
        for (JsonElement scoreName : userScores) {
            JsonObject userScore = scoreName.getAsJsonObject();
            String name = userScore.get("name").getAsString();
            String score = userScore.get("score").getAsString();
            PlayScore newScore = new PlayScore(name, score);
            scoreList.add(newScore);
        }

//        for (int i = 0; i < scoreList.size(); i++) {
//            System.out.println(scoreList.get(i).getPlayerName() + ": " + scoreList.get(i).getPlayerScore());
//
//        }
        return FXCollections.observableArrayList(scoreList);
    }



}
