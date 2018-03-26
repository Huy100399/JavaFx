package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main1 extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    Button button = new Button();

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("hello world !");
        button.setText("hello");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello world !");
            }
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scen= new Scene(layout,300,300);
        primaryStage.setScene(scen);
        primaryStage.show();

    }
}
