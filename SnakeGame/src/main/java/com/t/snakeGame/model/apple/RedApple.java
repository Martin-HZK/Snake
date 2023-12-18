package com.t.snakeGame.model.apple;

import com.t.snakeGame.model.apple.Apple;
import com.t.snakeGame.model.soundStrategy.Context;
import com.t.snakeGame.model.soundStrategy.PlayNormalEatSound;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

import static com.t.snakeGame.view.PlayingView.*;

/**
 * This class represents a red apple object.
 * It implements the Apple interface.
 */
public class RedApple implements Apple {

    /**
     * The x coordinate of the apple.
     */
    IntegerProperty appleX;

    /**
     * The y coordinate of the apple.
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
     * Constructor for Apple class
     * @param x the x coordinate of the apple
     * @param y the y coordinate of the apple
     */
    public RedApple(int x, int y) {
        if (this.appleX == null || this.appleY == null) {
            this.appleX = new SimpleIntegerProperty();
            this.appleY = new SimpleIntegerProperty();
        }
        this.appleX.set(x);
        this.appleY.set(y);
        this.isEaten.set(false);
    }

    /**
     * This method generates a random new apple.
     */
    public void newApple(){
        this.appleX.set(random.nextInt((int)(CANVAS_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        this.appleY.set(random.nextInt((int)(CANVAS_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
    }

    /**
     * This method gets the x coordinate of the apple.
     * @return the x coordinate of the apple
     */
    public int getAppleX() {
        return appleX.get();
    }

    /**
     * This method gets the y coordinate of the apple.
     * @return the y coordinate of the apple
     */
    public int getAppleY() {
        return appleY.get();
    }

    /**
     * This method sets the number of apples eaten.
     * @param applesEaten the number of apples eaten
     */
    public void setApplesEaten(int applesEaten) {
        this.applesEaten.set(applesEaten);
    }

    /**
     * This method gets the number of apples eaten.
     * @return the number of apples eaten
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
     * This method checks whether the snake has eaten the apple.
     * If the snake has eaten the apple, then the number of apples eaten will increase by 1.
     * Meanwhile, a new red apple will be generated.
     */
    @Override
    public void checkApple() {
        // we need to use the controller to check if the snake has eaten the apple
        Context soundPlay = new Context();
        soundPlay.setStrategy(new PlayNormalEatSound());

        if (isEaten.get() == true) {
            newApple();
            setApplesEaten(getApplesEaten() + 1);
            isEaten.set(false);
            Thread soundThread = new Thread(() -> {
                soundPlay.executeStrategy();
            });
            soundThread.start();
        }
    }

}
