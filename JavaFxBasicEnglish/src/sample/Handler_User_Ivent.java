package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class Handler_User_Ivent extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Handler User Event");

        GridPane layout= new GridPane();

        Button button1= new Button("button1");
        Button button2= new Button("button2");
        button1.setOnAction(event -> {
            System.out.println("button1");
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        //layout.getChildren().addAll(button1,button2);
        layout.add(button1,0,0);
        layout.add(button2,0,1);


        Scene scen = new Scene(layout,300,300);

        primaryStage.setScene(scen);
        primaryStage.show();
    }




}
