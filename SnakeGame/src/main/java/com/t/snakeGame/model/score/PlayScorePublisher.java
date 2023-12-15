package com.t.snakeGame.model.score;

import java.util.ArrayList;

public class PlayScorePublisher implements ScorePublisher {
    private ArrayList<Subscriber> scoreList = new ArrayList<>();
//    private


    @Override
    public void addSubscriber(ScoreSubscriber scoreSubscriber) {
        scoreList.add(scoreSubscriber);
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
