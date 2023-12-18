module com.t.snakeGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;
//    requires junit;

    opens com.t.snakeGame.controller to javafx.fxml;
    opens com.t.snakeGame to javafx.fxml;

    exports com.t.snakeGame;
    exports com.t.snakeGame.controller;
    exports com.t.snakeGame.model.apple;
    exports com.t.snakeGame.model.snake;
    exports com.t.snakeGame.model.gamePause;
    exports com.t.snakeGame.model.score;
    exports com.t.snakeGame.model.eatChecker;
    exports com.t.snakeGame.model.soundStrategy;
    exports com.t.snakeGame.view;
}