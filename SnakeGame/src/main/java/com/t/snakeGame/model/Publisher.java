package com.t.snakeGame.model;

public interface Publisher {
    void addSubscriber(Subscriber scoreSubscriber);
    void removeSubscriber(Subscriber scoreSubscriber);
//    void notifySubscribers();
}
