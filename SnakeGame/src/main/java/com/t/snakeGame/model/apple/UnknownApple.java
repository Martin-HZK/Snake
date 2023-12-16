package com.t.snakeGame.model.apple;

import com.t.snakeGame.model.soundStrategy.Context;
import com.t.snakeGame.model.soundStrategy.PlayBadEatSound;
import com.t.snakeGame.model.soundStrategy.PlayBonusEatSound;
import com.t.snakeGame.model.soundStrategy.PlayNormalEatSound;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

import static com.t.snakeGame.view.PlayingView.*;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;

public class UnknownApple implements Apple{
    IntegerProperty appleX;
    IntegerProperty appleY;
    Random random = new Random();

    private BooleanProperty isEaten = new SimpleBooleanProperty(false);

    public IntegerProperty applesEaten = new SimpleIntegerProperty(0);
    private boolean isBonus = false;

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }

    /**
     * Constructor for Apple class
     * @param x
     * @param y
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

    public void newApple(){
        this.appleX.set(random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        this.appleY.set(random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
    }

    public int getAppleX() {
        return appleX.get();
    }

    public int getAppleY() {
        return appleY.get();
    }


    public void setApplesEaten(int applesEaten) {
        this.applesEaten.set(applesEaten);
    }

    public int getApplesEaten() {
        return applesEaten.get();
    }

    public boolean getIsEaten() {
        return isEaten.get();
    }

    public void setIsEaten(boolean iseaten) {
        this.isEaten.set(iseaten);
    }

    // needs communication between model and controller to check whether the snake has eaten the apple
    @Override
    public void checkApple() {
        // we need to use the controller to check if the snake has eaten the apple
        Context soundPlay = new Context();
        if (isEaten.get() == true) {
            newApple();

            if (isBonus) {
                applesEaten.set(applesEaten.get() + 10);
                soundPlay.setStrategy(new PlayBonusEatSound());
            }else {
                // this is a bad apple
                applesEaten.set(applesEaten.get() - 3);
                soundPlay.setStrategy(new PlayBadEatSound());
            }

            soundPlay.executeStrategy();
            isEaten.set(false);
        }else {
            return;
        }
    }
}
