package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//https://o7planning.org/en/10857/javafx-scrollpane-tutorial
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html

public class ScrollPane_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //scrollPane cx la 1 loai layout
        ScrollPane scrollPane= new ScrollPane();

        Button button1= new Button("button1");
        button1.setPrefSize(400,400);
        Button button2= new Button("button2");
        button2.setPrefSize(300,300);

        GridPane GridPanelayout= new GridPane();
        GridPanelayout.setVgap(20);
        GridPanelayout.setHgap(20);
        GridPanelayout.setAlignment(Pos.CENTER);

        GridPanelayout.add(button1,0,0);
        GridPanelayout.add(button2,1,1);

        scrollPane.setContent(GridPanelayout);


        Scene scene= new Scene(scrollPane,300,300);

        primaryStage.setTitle("ScrollPane");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
