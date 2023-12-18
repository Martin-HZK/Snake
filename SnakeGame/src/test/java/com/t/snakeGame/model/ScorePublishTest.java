package com.t.snakeGame.model;
import com.t.snakeGame.model.score.PlayScorePublisher;
import com.t.snakeGame.model.score.ScoreSubscriber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class ScorePublishTest {

    PlayScorePublisher playerScorePublisher;
    @Before
    public void setUp() {

        playerScorePublisher = PlayScorePublisher.getInstance();

    }

    @Test
    public void testUpdateLastScore() {
        ScoreSubscriber last1 = new ScoreSubscriber("Josh", "10");
        playerScorePublisher.addSubscriber(last1);
        assertEquals("10", playerScorePublisher.getLastSubscriber().getPlayerScore());

        playerScorePublisher.updateLastScore("20");
        assertEquals("20", playerScorePublisher.getLastSubscriber().getPlayerScore());

        ScoreSubscriber last2 = new ScoreSubscriber("Gabe", "30");
        playerScorePublisher.addSubscriber(last2);
        assertEquals("30", playerScorePublisher.getLastSubscriber().getPlayerScore());
    }
}
