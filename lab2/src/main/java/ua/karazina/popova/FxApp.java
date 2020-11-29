package ua.karazina.popova;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view.fxml"));
        root.setStyle("-fx-background-color: #ace7b7;");
        stage.setTitle("Lab1");
        stage.setScene(new Scene(root, 550, 400));
        stage.show();
    }
}
