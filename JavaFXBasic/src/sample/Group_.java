package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.MotionBlur;
import javafx.stage.Stage;

//https://o7planning.org/en/11103/javafx-group-tutorial


public class Group_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // tat cac cac thanh phan trong Group deu o vi tri (0,0)
        //Group cx la 1 layout

        Button button1= new Button("button1");
        Button button2= new Button("button2");
        Label label= new Label("Label");

        button1.setPrefSize(20,20);
        button2.setPrefSize(100,100);
        label.setPrefSize(200,200);

        Group group= new Group();
        group.getChildren().addAll(button2,button1,label);
        group.setAutoSizeChildren(true);

        Scene scene= new Scene(group,300,300);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
