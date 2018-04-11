package sample;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButton_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        HBox hBoxlayout= new HBox();
        hBoxlayout.setSpacing(20);
        hBoxlayout.setAlignment(Pos.CENTER);

        hBoxlayout.getChildren().add(new Label("choose :"));

        ToggleGroup toggleGroup= new ToggleGroup();

        ToggleButton toggleButton1= new ToggleButton("toggleButton1");
        ToggleButton toggleButton2= new ToggleButton("toggleButton2");
        ToggleButton toggleButton3= new ToggleButton("toggleButton3");

        //neu nhieu toggleButton trong mot toggleGroup thi neu co 1 toggleButton la selected thi cac toggleButton se la deselected
        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);


        hBoxlayout.getChildren().addAll(toggleButton1,toggleButton2,toggleButton3);

        Scene scene= new Scene(hBoxlayout,400,300);


        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
