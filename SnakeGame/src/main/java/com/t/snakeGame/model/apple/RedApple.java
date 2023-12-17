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

public class RedApple implements Apple {

    IntegerProperty appleX;
    IntegerProperty appleY;
    Random random = new Random();

    private BooleanProperty isEaten = new SimpleBooleanProperty(false);

    public IntegerProperty applesEaten = new SimpleIntegerProperty(0);

    /**
     * Constructor for Apple class
     * @param x
     * @param y
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
        soundPlay.setStrategy(new PlayNormalEatSound());

        if (isEaten.get() == true) {
            newApple();
            applesEaten.set(applesEaten.get() + 1);
            isEaten.set(false);
            Thread soundThread = new Thread(() -> {
                soundPlay.executeStrategy();
            });
            soundThread.start();
        }else {
            return;
        }
    }

}
