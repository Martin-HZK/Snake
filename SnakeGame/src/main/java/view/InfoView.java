package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class InfoView {
    private static Scene infoScene;

    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    public InfoView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/playingView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PlayingView.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void setRoot(String fxml) throws IOException {
        infoScene.setRoot(loadFXML(fxml));
    }

}
