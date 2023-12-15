package com.t.snakeGame.model;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreSubscriber implements Subscriber{



    private String playerName;
    private String playerScore;

    public ScoreSubscriber(String playerName, String playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }
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
