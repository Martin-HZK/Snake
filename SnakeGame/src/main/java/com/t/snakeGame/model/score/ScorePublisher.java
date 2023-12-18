package com.t.snakeGame.model.score;

/**
 * This interface represents a score publisher.
 * It defines adding subscribers to the score publisher.
 */
public interface ScorePublisher {

    /**
     * Add a subscriber to the score publisher.
     * @param scoreSubscriber the subscriber to be added
     */
    void addSubscriber(ScoreSubscriber scoreSubscriber);

}
