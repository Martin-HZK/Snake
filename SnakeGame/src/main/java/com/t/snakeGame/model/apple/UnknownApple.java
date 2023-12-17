package com.t.snakeGame.model.apple;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

import static com.t.snakeGame.view.PlayingView.*;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;

/**
 * This class represents an unknown apple object.
 * It implements the Apple interface.
 */
public class UnknownApple implements Apple{

    /**
     * The x coordinate of the unknown apple.
     */
    IntegerProperty appleX;

    /**
     * The y coordinate of the unknown apple.
     */
    IntegerProperty appleY;

    /**
     * The random number generator. This is for refreshing to get the new apple.
     */
    Random random = new Random();

    /**
     * The boolean property that indicates whether the apple has been eaten.
     */
    private BooleanProperty isEaten = new SimpleBooleanProperty(false);

    /**
     * The number of apples eaten.
     */
    public IntegerProperty applesEaten = new SimpleIntegerProperty(0);

    /**
     * The boolean property that indicates whether the apple is a bonus apple.
     */
    private boolean isBonus = false;

    /**
     * The boolean property that indicates whether the apple is a bad apple.
     * If return true, then it is a bonus apple. If return false, then it is a bad apple.
     * @return the boolean value indicating whether the apple is a bad apple or bonus apple.
     */
    public boolean isBonus() {
        return isBonus;
    }

    /**
     * Set the boolean property that indicates whether the apple is a bonus apple.
     * If return true, then it is a bonus apple. If return false, then it is a bad apple.
     * @param bonus the boolean value indicating whether the apple is a bonus apple.
     */
    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }

    /**
     * Constructor for UnknownApple class
     * @param x the x coordinate of the unknown apple
     * @param y the y coordinate of the unknown apple
     */
    public UnknownApple(int x, int y) {
        if (this.appleX == null || this.appleY == null) {
            this.appleX = new SimpleIntegerProperty();
            this.appleY = new SimpleIntegerProperty();
        }
        this.appleX.set(x);
        this.appleY.set(y);
        this.isEaten.set(false);
    }

    /**
     * This method generates a random new unknown apple.
     */
    public void newApple(){
        this.appleX.set(random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        this.appleY.set(random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
    }

    /**
     * This method gets the x coordinate of the unknown apple.
     * @return the x coordinate of the unknown apple
     */
    public int getAppleX() {
        return appleX.get();
    }

    /**
     * This method gets the y coordinate of the unknown apple.
     * @return the y coordinate of the unknown apple
     */
    public int getAppleY() {
        return appleY.get();
    }


    /**
     * This method sets the number of unknown apples eaten.
     * @param applesEaten the number of unknown apples eaten
     */
    public void setApplesEaten(int applesEaten) {
        this.applesEaten.set(applesEaten);
    }

    /**
     * This method gets the number of unknown apples eaten.
     * @return the number of unknown apples eaten
     */
    public int getApplesEaten() {
        return applesEaten.get();
    }

    /**
     * This method gets the boolean property that indicates whether the apple has been eaten.
     * @return the boolean property that indicates whether the apple has been eaten
     */
    public boolean getIsEaten() {
        return isEaten.get();
    }

    /**
     * This method sets the boolean property that indicates whether the apple has been eaten.
     * @param iseaten the boolean property that indicates whether the apple has been eaten
     */
    public void setIsEaten(boolean iseaten) {
        this.isEaten.set(iseaten);
    }

    /**
     * This method checks if the snake has eaten the apple.
     * If the snake has eaten the apple, then we need to generate a new apple and increase the number of apples eaten.
     * If eating a bonus apple, then the number of apples eaten will increase by 10.
     * If eating a bad apple, then the number of apples eaten will decrease by 3.
     */
    @Override
    public void checkApple() {
        // we need to use the controller to check if the snake has eaten the apple
        if (isEaten.get() == true) {
            newApple();

            if (isBonus) {
                applesEaten.set(applesEaten.get() + 10);
            }else {
                // this is a bad apple
                applesEaten.set(applesEaten.get() - 3);
            }

            applesEaten.set(applesEaten.get() + 1);
            isEaten.set(false);
        }else {
            return;
        }
    }
}
