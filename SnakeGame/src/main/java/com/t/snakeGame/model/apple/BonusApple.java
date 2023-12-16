package com.t.snakeGame.model.apple;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

import static com.t.snakeGame.view.PlayingView.*;
import static com.t.snakeGame.view.PlayingView.UNIT_SIZE;

public class BonusApple implements Apple{
    IntegerProperty appleX;
    IntegerProperty appleY;
    Random random = new Random();

    private BooleanProperty isEaten = new SimpleBooleanProperty(false);

    public IntegerProperty applesEaten = new SimpleIntegerProperty(0);

    /**
     * Constructor for BonusApple class
     * @param x
     * @param y
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
        isEaten.set(iseaten);
    }
    @Override
    public void checkApple() {
        if (isEaten.get() == true) {
            newApple();
            applesEaten.set(applesEaten.get() + 10);
            isEaten.set(false);
        }else {
            return;
        }
    }
}
