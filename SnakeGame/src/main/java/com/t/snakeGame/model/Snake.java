package com.t.snakeGame.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

import static com.t.snakeGame.view.PlayingView.SCREEN_HEIGHT;
import static com.t.snakeGame.view.PlayingView.SCREEN_WIDTH;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;
import static com.t.snakeGame.view.PlayingView.GAME_UNITS;

public class Snake {

//    static final int SCREEN_WIDTH = 1300;
//    static final int SCREEN_HEIGHT = 750;
//    public static final int UNIT_SIZE = 50;
//    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);


    private final int x[] = new int[GAME_UNITS];
    private final int y[] = new int[GAME_UNITS];



    private int bodyParts = 6;// will be further increased as the snake eats more apples

    private boolean running;

//    IntegerProperty[] snake = new IntegerProperty[5];


    private char direction;


    /**
     * Constructor for Snake class
     */
    public Snake() {
        // do nothing
        this.running = true;
        this.direction = 'R';
    }

    /**
     * Getter for direction
     * @return
     */
    public char getDirection() {
        return direction;
    }

    /**
     * Setter for direction
     * @param direction
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }

    /**
     * Getter for bodyParts
     * @return
     */
    public int getBodyParts() {
        return bodyParts;
    }

    /**
     * Setter for bodyParts
     * @param bodyParts
     */
    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    /**
     * Getter for x
     * @return
     */
    public int[] getX() {
        return x;
    }
    /**
     * Getter for y
     * @return
     */
    public int[] getY() {
        return y;
    }

    /**
     * Getter for running
     * @return
     */
//    public BooleanProperty runningProperty() {
//        return running;
//    }
    public boolean isRunning() {
        return running;
    }


    // the controller needs to communicate with the model to expand the snake
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i]) && (y[0] == y[i])) {
                this.running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            this.running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            this.running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            this.running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            this.running = false;
        }

        if(!this.running) {
//            timer.stop();// we need to communicate to the controller that the game is over
        }
    }

    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
//        System.out.println("The direction is" + direction);

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }


}
