package com.t.snakeGame.model;

import javafx.animation.AnimationTimer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PauseResumeTest extends AnimationTimer{

    boolean isRunning = false;

    public PauseResumeTest() {
        super();
    }

    @Override
    public void handle(long l) {
    }

    @Override
    public void start() {
        super.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        super.stop();
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
    @Test
    public void testPause() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

            }
        };
        timer.start();
        assertEquals(false, isRunning());
    }

    @Test
    public void testResume() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
            }
        };
        timer.stop();
        assertEquals(false, isRunning());
    }


}
