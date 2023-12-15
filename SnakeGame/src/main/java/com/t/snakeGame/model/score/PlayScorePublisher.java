package com.t.snakeGame.model.score;

import java.util.ArrayList;

public class PlayScorePublisher implements ScorePublisher {
    private static PlayScorePublisher instance;
    private ArrayList<ScoreSubscriber> scoreList = new ArrayList<>();

    @Override
    public void addSubscriber(ScoreSubscriber scoreSubscriber) {
        scoreList.add(scoreSubscriber);
    }
    public static PlayScorePublisher getInstance() {
        if (instance == null) {
            instance = new PlayScorePublisher();
        }
        return instance;
    }
    /**
     * This method updates the score of the last subscriber in the list, which
     * stands for the score of the player in current round.
     * @param score
     */
    public void updateLastScore(String score) {
       ScoreSubscriber last = getLastSubscriber();
       last.setPlayerScore(score);// redefining score, otherwise it will be 0
//       last.setPlayerName(playerName);
    }
    public void updateScore(String score) {
        ScoreSubscriber last = scoreList.get(scoreList.size()-1);
        last.setPlayerScore(score);
    }

    public ScoreSubscriber getLastSubscriber() {
        return scoreList.get(scoreList.size()-1);
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
