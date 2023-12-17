package com.t.snakeGame.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.t.snakeGame.Main;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScoreSubscriber;
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

/**
 * This class represents a controller for score.fxml.
 * It defines the method for switching to startMain.fxml.
 */
public class ScoreController {


    /**
     * The playing score of the player.
     */
    public static IntegerProperty playingScore = new SimpleIntegerProperty(0);

    /**
     * The snake level image.
     */
    @FXML
    private ImageView snakeLevel;

    /**
     * The total score of the player.
     */
    @FXML
    private Label totalScore;

    /**
     * The player level.
     */
    @FXML
    private Label playerLevel;

    /**
     * The player name column.
     */
    @FXML
    private TableColumn<PlayScorePublisher, String> playerName;

    /**
     * The player score column.
     */
    @FXML
    private TableColumn<PlayScorePublisher, String> playerScore;

    /**
     * The score table.
     */
    @FXML
    private TableView<ScoreSubscriber> scoreTable;

    /**
     * The play score publisher.
     */
    PlayScorePublisher playScorePublisher = PlayScorePublisher.getInstance();

    /**
     * Set the score board and the snake level.
     * @throws IOException the io exception
     */
    @FXML
    public void initialize() {
        playerName.setCellValueFactory(new PropertyValueFactory<PlayScorePublisher, String>("playerName"));
        playerScore.setCellValueFactory(new PropertyValueFactory<PlayScorePublisher, String>("playerScore"));

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

    }

    /**
     * Switch to Main window
     * @throws IOException the io exception
     */
    public void switchOnRestartClick() throws IOException {
        Main.setRoot("/com.t.snakeGame/startMain");
    }

    /**
     * Clear all scores.
     * @throws IOException the io exception
     */
    public void clearScore() throws IOException {
        scoreTable.getItems().clear();
        scoreTable.refresh();
        playScorePublisher.clearAllScores();
    }


    /**
     * This method sets the score board.
     * @return the observable list
     */
    public ObservableList<ScoreSubscriber> setScoreBoard() {
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
        ArrayList<ScoreSubscriber> scoreList = new ArrayList<>();
        for (JsonElement scoreName : userScores) {
            JsonObject userScore = scoreName.getAsJsonObject();
            String name = userScore.get("name").getAsString();
            String score = userScore.get("score").getAsString();
            ScoreSubscriber newScore = new ScoreSubscriber(name, score);
            scoreList.add(newScore);
        }

        return FXCollections.observableArrayList(scoreList);
    }



}
