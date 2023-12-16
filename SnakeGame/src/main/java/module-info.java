//module com.t.snakeGame {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires java.datatransfer;
//    requires java.desktop;
//
//    opens com.t.snakeGame to javafx.fxml;
////    exports com.t.snakeGame;
////    exports;
////    opens to
//}
module com.t.snakeGame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;

    opens com.t.snakeGame.controller to javafx.fxml;
    opens com.t.snakeGame to javafx.fxml;
    exports com.t.snakeGame;
    exports com.t.snakeGame.controller;
    exports com.t.snakeGame.model;
    exports com.t.snakeGame.model.score;
}