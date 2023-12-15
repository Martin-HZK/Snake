package com.t.snakeGame.model;

public interface ScorePublisher {
    void addSubscriber(ScoreSubscriber scoreSubscriber);
//    void removeSubscriber(ScoreSubscriber scoreSubscriber);
//    void notifySubscribers();
}
