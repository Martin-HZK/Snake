package com.t.snakeGame.model.score;

public interface ScorePublisher {
    void addSubscriber(ScoreSubscriber scoreSubscriber);
//    void removeSubscriber(ScoreSubscriber scoreSubscriber);
//    void notifySubscribers();
}
