package com.t.snakeGame.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

public class Snake {

    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 10;

    final IntegerProperty x[] = new IntegerProperty[GAME_UNITS];
    final IntegerProperty y[] = new IntegerProperty[GAME_UNITS];
    int bodyParts = 6;// will be further increased as the snake eats more apples

    BooleanProperty running;

    IntegerProperty[] snake = new IntegerProperty[5];


    public Snake() {
        // do nothing
        this.running.set(true);
    }

    // the controller needs to communicate with the model to expand the snake
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0].get() == x[i].get())&& (y[0].get() == y[i].get())) {
                this.running.set(false);
            }
        }
        //check if head touches left border
        if(x[0].get() < 0) {
            this.running.set(false);
        }
        //check if head touches right border
        if(x[0].get() > SCREEN_WIDTH) {
            this.running.set(false);
        }
        //check if head touches top border
        if(y[0].get() < 0) {
            this.running.set(false);
        }
        //check if head touches bottom border
        if(y[0].get() > SCREEN_HEIGHT) {
            this.running.set(false);
        }

        if(!this.running.get()) {
//            timer.stop();// we need to communicate to the controller that the game is over
        }
    }

}
