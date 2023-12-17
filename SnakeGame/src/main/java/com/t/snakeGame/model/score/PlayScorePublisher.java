package com.t.snakeGame.model.score;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is the publisher of score, which is the score of the player in current round.
 * It implements the ScorePublisher interface and defines the method to add subscribers.
 */
public class PlayScorePublisher implements ScorePublisher {

    /**
     * The instance of the PlayScorePublisher class. This is set to static because there should be only one instance of
     */
    private static PlayScorePublisher instance;

    /**
     * The list of subscribers of the score publisher.
     */
    private ArrayList<ScoreSubscriber> scoreList = new ArrayList<>();


    /**
     * Constructor for PlayScorePublisher class
     * @param scoreSubscriber the subscriber to be added
     */
    @Override
    public void addSubscriber(ScoreSubscriber scoreSubscriber) {
        scoreList.add(scoreSubscriber);
    }

    /**
     * This method returns the instance of the PlayScorePublisher class.
     * If the instance is null, it will create a new instance.
     * If the instance is not null, it will return the instance.
     * @return the instance of the PlayScorePublisher class
     */
    public static PlayScorePublisher getInstance() {
        if (instance == null) {
            instance = new PlayScorePublisher();
        }
        return instance;
    }
    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @param score the score of the player in current round
     */
    public void updateLastScore(String score) {
       ScoreSubscriber last = getLastSubscriber();
       last.setPlayerScore(score);// redefining score, otherwise it will be 0
//       last.setPlayerName(playerName);
    }

    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @param score the score of the player in current round
     */
    public void updateScore(String score) {
        ScoreSubscriber last = scoreList.get(scoreList.size()-1);
        last.setPlayerScore(score);
    }

    /**
     * This method returns the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @return the last subscriber in the list
     */
    public ScoreSubscriber getLastSubscriber() {
        return scoreList.get(scoreList.size()-1);
    }

    /**
     * This method clears all the scores in the list.
     */
    public void clearAllScores() {
        scoreList.clear();
        clearJsonScore();
    }

    /**
     * This method clears the json file that stores the scores.
     * It will let the array in the json file be empty.
     */
    private void clearJsonScore() {
        // TODO Auto-generated method stub
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
        userScores = new JsonArray();
        jsonObject.add("scores", userScores);
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("src/main/resources/Score.json");
            gson.toJson(jsonObject, writer);
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
//    @Override
//    public void removeSubscriber(ScoreSubscriber scoreSubscriber) {
//        scoreList.remove(scoreSubscriber);
//    }

//    public void storeScore(int score) {
//        JsonArray userScores = new JsonArray();
//        JsonObject jsonObject = new JsonObject();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Score.json"));
//            jsonObject= JsonParser.parseReader(reader).getAsJsonObject();
//            reader.close();
//            userScores = jsonObject.getAsJsonArray("scores");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JsonObject newScore = new JsonObject();
//        newScore.addProperty("name", "Anonymous");
//        newScore.addProperty("score", score);
//        userScores.add(newScore);
//        jsonObject.add("scores", userScores);
//        try {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            FileWriter writer = new FileWriter("src/main/resources/Score.json");
//            gson.toJson(jsonObject, writer);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
