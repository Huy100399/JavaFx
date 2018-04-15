package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://o7planning.org/en/11083/javafx-slider-tutorial
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Slider.html


public class Slider_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("select volume");
        label.setAlignment(Pos.CENTER);
        Label value= new Label("value =");
        value.setAlignment(Pos.CENTER);

        Slider volume_slider= new Slider();
        volume_slider.setBlockIncrement(10);
        volume_slider.setMax(100);
        volume_slider.setMin(0);
        volume_slider.setValue(30);
        volume_slider.setShowTickLabels(true);
        volume_slider.setShowTickMarks(true);
        volume_slider.setOnMouseDragged(event -> {
            // ham dc goi khi keo chuot qua slider
            System.out.println("dragging");

        });

        volume_slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            // ham dc goi khi value cua slider bi thay doi
            System.out.println(observable);
            System.out.println(oldValue);
            System.out.println(newValue);
            System.out.println(volume_slider.getValue());
            value.setText(String.valueOf(volume_slider.getValue()));
        });





        VBox vBox= new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label,volume_slider,value);

        Scene scene= new Scene(vBox,300,300);

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
