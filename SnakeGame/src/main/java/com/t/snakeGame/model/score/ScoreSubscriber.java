package com.t.snakeGame.model.score;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents a score subscriber.
 * It implements the Subscriber interface and defines the update method for the score subscriber.
 */
public class ScoreSubscriber implements Subscriber{

    /**
     * The name of the player.
     */
    private String playerName;

    /**
     * The score of the player.
     */
    private String playerScore;

    /**
     * Constructor for ScoreSubscriber class
     * @param playerName the name of the player
     * @param playerScore the score of the player
     */
    public ScoreSubscriber(String playerName, String playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @return the name of last subscriber in the list
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @param playerName the name of the player
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @return the score of last subscriber in the list
     */
    public String getPlayerScore() {
        return playerScore;
    }

    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @param playerScore the score of the current player
     */
    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }

    /**
     * Update the score subscriber.
     * This method is for storing new player score to json file.
     */
    @Override
    public void update() {
        // this is for storing json file
        JsonArray userScores = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Score.json"));
            jsonObject= JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            userScores = jsonObject.getAsJsonArray("scores");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject newScore = new JsonObject();
        newScore.addProperty("name", playerName);
        newScore.addProperty("score", playerScore);
        userScores.add(newScore);
        jsonObject.add("scores", userScores);
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("src/main/resources/Score.json");
            gson.toJson(jsonObject, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
