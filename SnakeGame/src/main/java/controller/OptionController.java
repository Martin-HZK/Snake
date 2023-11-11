package controller;

import javafx.event.ActionEvent;
import view.Main;

import java.io.IOException;

public class OptionController {
    public void switchOnBackClick(ActionEvent actionEvent) throws IOException {
        Main.setRoot("startMain");
    }
}
