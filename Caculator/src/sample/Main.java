package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene scene= new Scene(root);
                scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setTitle("caculator");
                primaryStage.show();
                primaryStage.setResizable(false);
            }
            catch (Exception e)
            {
                e.getStackTrace();
            }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
