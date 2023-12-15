package com.t.snakeGame.model.snake;

import static com.t.snakeGame.view.PlayingView.SCREEN_HEIGHT;
import static com.t.snakeGame.view.PlayingView.SCREEN_WIDTH;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;
import static com.t.snakeGame.view.PlayingView.GAME_UNITS;

public class NormalSnake implements Snake{

    private final int x[] = new int[GAME_UNITS];
    private final int y[] = new int[GAME_UNITS];
    private int bodyParts = 6;// will be further increased as the snake eats more apples
    private boolean running;
    private char direction;


    /**
     * Constructor for Snake class
     */
    public NormalSnake() {
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

    public boolean isRunning() {
        return running;
    }


    public int getHeadX() {
        return x[0];
    }

    public int getHeadY() {
        return y[0];
    }


    // the controller needs to communicate with the model to expand the snake
    @Override
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

        // controller will deal with the issue of not running
//        if(!this.running) {
//            timer.stop();// we need to communicate to the controller that the game is over
//        }
    }

    @Override
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
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
