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

    opens com.t.snakeGame to javafx.fxml;
    exports com.t.snakeGame;
    exports com.t.snakeGame.controller;
}