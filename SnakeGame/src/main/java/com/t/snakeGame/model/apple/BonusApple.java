package com.t.snakeGame.model.apple;

import com.t.snakeGame.model.soundStrategy.Context;
import com.t.snakeGame.model.soundStrategy.PlayBonusEatSound;
import com.t.snakeGame.model.soundStrategy.PlayNormalEatSound;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

import static com.t.snakeGame.view.PlayingView.*;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;

/**
 * This class represents a bonus apple object.
 * It implements the Apple interface.
 */
public class BonusApple implements Apple{

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
     * Constructor for BonusApple class
     * @param x the x coordinate of the bonus apple
     * @param y the y coordinate of the bonus apple
     */
    public BonusApple(int x, int y) {
        if (this.appleX == null || this.appleY == null) {
            this.appleX = new SimpleIntegerProperty();
            this.appleY = new SimpleIntegerProperty();
        }
        this.appleX.set(x);
        this.appleY.set(y);
        this.isEaten.set(false);
    }

    /**
     * This method generates a random new bonus apple.
     */
    public void newApple(){
        this.appleX.set(random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        this.appleY.set(random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
    }


    /**
     * This method gets the x coordinate of the bonus apple.
     * @return the x coordinate of the bonus apple
     */
    public int getAppleX() {
        return appleX.get();
    }

    /**
     * This method gets the y coordinate of the bonus apple.
     * @return the y coordinate of the bonus apple
     */
    public int getAppleY() {
        return appleY.get();
    }

    /**
     * This method sets the number of bonus apples eaten.
     * @param applesEaten the number of bonus apples eaten
     */
    public void setApplesEaten(int applesEaten) {
        this.applesEaten.set(applesEaten);
    }

    /**
     * This method gets the number of bonus apples eaten.
     * @return the number of bonus apples eaten
     */
    public int getApplesEaten() {
        return applesEaten.get();
    }

    /**
     * This method gets the boolean property that indicates whether the bonus apple has been eaten.
     * @return the boolean property that indicates whether the apple has been eaten
     */
    public boolean getIsEaten() {
        return isEaten.get();
    }

    /**
     * This method sets the boolean property that indicates whether the bonus apple has been eaten.
     * @param iseaten the boolean property that indicates whether the apple has been eaten
     */
    public void setIsEaten(boolean iseaten) {
        isEaten.set(iseaten);
    }

    /**
     * This method checks whether the bonus apple has been eaten.
     * If the bonus apple has been eaten, it generates a new bonus apple and adds 10 to the number of bonus apples eaten.
     * If the bonus apple has not been eaten, it does nothing.
     */
    @Override
    public void checkApple() {
        Context soundPlay = new Context();
        soundPlay.setStrategy(new PlayBonusEatSound());
        if (isEaten.get() == true) {
            newApple();
            applesEaten.set(applesEaten.get() + 10);
            isEaten.set(false);
            Thread bonusThread = new Thread(() -> {
                    soundPlay.executeStrategy();
            });
            bonusThread.start();
        }else {
            return;
        }
    }
}
