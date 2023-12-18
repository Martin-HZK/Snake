package com.t.snakeGame.model.snake;

import static com.t.snakeGame.view.PlayingView.*;

/**
 * This class represents a normal snake object.
 * It implements the Snake interface.
 */
public class NormalSnake implements Snake{


    /**
     * The x coordinates of the whole snake.
     */
    private final int x[] = new int[GAME_UNITS];

    /**
     * The y coordinates of the whole snake.
     */
    private final int y[] = new int[GAME_UNITS];

    /**
     * The number of body parts of the snake.
     * It will increase when the snake eats an apple.
     */
    private int bodyParts = 6;

    /**
     * The boolean property that indicates whether the snake is running.
     */
    private boolean running;

    /**
     * The direction of the snake.
     */
    private char direction;


    /**
     * Constructor for Snake class
     */
    public NormalSnake() {
        this.running = true;
        this.direction = 'R';
    }

    /**
     * This method gets the direction of the snake.
     * @return the direction of the snake
     */
    public char getDirection() {
        return direction;
    }

    /**
     * This method sets the direction of the snake.
     * @param direction
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }

    /**
     * This method gets the number of body parts of the snake.
     * @return the number of body parts of the snake
     */
    public int getBodyParts() {
        return bodyParts;
    }

    /**
     * This method sets the length of body parts of the snake.
     * @param bodyParts the length of body parts of the snake
     */
    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    /**
     * This method gets the x coordinates of the whole snake.
     * @return the x coordinates of the snake
     */
    public int[] getX() {
        return x;
    }


    /**
     * This method gets the y coordinates of the whole snake.
     * @return the y coordinates of the snake
     */
    public int[] getY() {
        return y;
    }

    /**
     * This method gets the running status of the snake.
     * If the snake is running, it returns true. If the snake is not running, it returns false.
     * @return the running status of the snake
     */
    public boolean isRunning() {
        return running;
    }


    /**
     * This method gets the x coordinate of the head of the snake.
     * @return the x coordinate of the head of the snake
     */
    public int getHeadX() {
        return x[0];
    }

    /**
     * This method gets the y coordinate of the head of the snake.
     * @return the y coordinate of the head of the snake
     */
    public int getHeadY() {
        return y[0];
    }

    /**
     * This method sets the x coordinate of the head of the snake.
     * @param x the x coordinate of the head of the snake
     */
    public void setHeadX(int x) {
        this.x[0] = x;
    }

    /**
     * This method sets the y coordinate of the head of the snake.
     * @param y the y coordinate of the head of the snake
     */
    public void setHeadY(int y) {
        this.y[0] = y;
    }

    /**
     * This method check if the snake has collided with itself or the border.
     */
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
        if(x[0] > CANVAS_WIDTH - UNIT_SIZE) {
            this.running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            this.running = false;
        }
        //check if head touches bottom border
        if(y[0] > CANVAS_HEIGHT - 2*UNIT_SIZE) {
            this.running = false;
        }

    }

    /**
     * This method moves the snake.
     */
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
