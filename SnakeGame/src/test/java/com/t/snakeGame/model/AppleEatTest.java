package com.t.snakeGame.model;

import com.t.snakeGame.model.apple.BonusApple;
import com.t.snakeGame.model.apple.RedApple;
import com.t.snakeGame.model.apple.UnknownApple;
import com.t.snakeGame.model.eatChecker.BonusEatChecker;
import com.t.snakeGame.model.eatChecker.NormalEatChecker;
import com.t.snakeGame.model.eatChecker.UnknownEatChecker;
import com.t.snakeGame.model.snake.NormalSnake;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class AppleEatTest {

    @Test
    public void testEatRedApple() {
        NormalSnake snake = new NormalSnake();
        snake.setHeadX(200);
        snake.setHeadY(200);
        RedApple redApple = new RedApple(200, 200);
        NormalEatChecker normalEatChecker = new NormalEatChecker(snake, redApple);

        assertEquals(6, snake.getBodyParts());
        normalEatChecker.check();

        assertEquals(false, redApple.getIsEaten());
        assertEquals(7, snake.getBodyParts());
    }

    @Test
    public void testEatBonusApple() {
        NormalSnake snake = new NormalSnake();
        snake.setHeadX(400);
        snake.setHeadY(400);
        BonusApple bonusApple = new BonusApple(400, 400);
        BonusEatChecker normalEatChecker = new BonusEatChecker(snake, bonusApple);
        assertEquals(6, snake.getBodyParts());
        normalEatChecker.check();

        assertEquals(false, bonusApple.getIsEaten());
        assertEquals(7, snake.getBodyParts());
    }

    @Test
    public void testEatUnknownApple() {
        NormalSnake snake = new NormalSnake();
        snake.setHeadX(1000);
        snake.setHeadY(550);
        UnknownApple unknownApple = new UnknownApple(1000, 550);
        UnknownEatChecker normalEatChecker = new UnknownEatChecker(snake, unknownApple);
        assertEquals(6, snake.getBodyParts());
        normalEatChecker.check();

        assertEquals(false, unknownApple.getIsEaten());
        assertEquals(7, snake.getBodyParts());
    }






}
