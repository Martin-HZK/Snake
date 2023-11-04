module com.t.snakeGame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.t.snakeGame to javafx.fxml;
    exports com.t.snakeGame;
}