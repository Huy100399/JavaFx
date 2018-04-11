package other;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooser_Filters extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("fileChooser with filter");
        //// Add Extension Filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("all file","*.*"),
                new FileChooser.ExtensionFilter("JPG file","*.jpg"),
                new FileChooser.ExtensionFilter("txt file","*.txt")
        );

        Button open = new Button("open");

        open.setOnAction(event -> {
            fileChooser.showOpenMultipleDialog(primaryStage);
        });

        VBox vBox= new VBox();
        vBox.getChildren().addAll(open);

        Scene scene = new Scene(vBox,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
