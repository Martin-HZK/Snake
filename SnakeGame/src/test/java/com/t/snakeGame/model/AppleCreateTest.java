package com.t.snakeGame.model;

import com.t.snakeGame.model.apple.*;
import com.t.snakeGame.model.snake.NormalSnake;
import com.t.snakeGame.model.snake.NormalSnakeCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppleCreateTest {
    NormalSnake snake;
    RedApple redApple;
    UnknownApple unknownApple;
    BonusApple bonusApple;
    RedAppleCreator redAppleCreator;
    UnknownAppleCreator unknownAppleCreator;
    BonusAppleCreator bonusAppleCreator;
    NormalSnakeCreator snakeCreator;

    @Before
    public void setUp() {
        snake = new NormalSnake();
        redApple = new RedApple(200, 200);
        unknownApple = new UnknownApple(1000, 550);
        bonusApple = new BonusApple(400, 400);
        redAppleCreator = new RedAppleCreator();
        unknownAppleCreator = new UnknownAppleCreator();
        bonusAppleCreator = new BonusAppleCreator();
        snakeCreator = new NormalSnakeCreator();
    }

    @Test
    public void testRedAppleCreator() {
        RedApple redApple1 = redAppleCreator.createApple(200, 200);
        assertEquals(200, redApple1.getAppleX());
        assertEquals(200, redApple1.getAppleY());
    }

    @Test
    public void testBonusAppleCreator() {
        BonusApple bonusApple1 = bonusAppleCreator.createApple(400, 400);
        assertEquals(400, bonusApple1.getAppleX());
        assertEquals(400, bonusApple1.getAppleY());
    }

    @Test
    public void testUnknownAppleCreator() {
        UnknownApple unknownApple1 = unknownAppleCreator.createApple(1000, 550);
        assertEquals(1000, unknownApple1.getAppleX());
        assertEquals(550, unknownApple1.getAppleY());
    }

}
