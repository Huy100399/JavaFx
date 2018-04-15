package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

//https://o7planning.org/en/11099/javafx-radiobutton-tutorial
//https://o7planning.org/en/11099/javafx-radiobutton-tutorial



public class RadioButton_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        javafx.scene.control.Label yourgender= new Label("yourt gender :");
        RadioButton male_RadioButton= new RadioButton("male");
        RadioButton female_RadioButton = new RadioButton("female");
        RadioButton gay_RadioButton = new RadioButton("gay");
        javafx.scene.control.TextField gender= new javafx.scene.control.TextField();

        ToggleGroup toggleGroup= new ToggleGroup();
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            // neu co su thay doi le lua chon trong toggleGroup thi chây nhx lenh sau
            if(toggleGroup.getSelectedToggle()!=null)
            {
                RadioButton radioButton= (RadioButton)toggleGroup.getSelectedToggle();
                gender.setText(radioButton.getText());
            }

        });




        male_RadioButton.setText("male");
        female_RadioButton.setText("female");
        gay_RadioButton.setText("gay");

        male_RadioButton.setToggleGroup(toggleGroup);
        female_RadioButton.setToggleGroup(toggleGroup);
        gay_RadioButton.setToggleGroup(toggleGroup);

        male_RadioButton.setSelected(true);

        HBox hBox= new HBox();
        hBox.setSpacing(20);
        hBox.getChildren().add(yourgender);
        hBox.getChildren().addAll(male_RadioButton,female_RadioButton,gay_RadioButton,gender);

        Scene scene= new Scene(hBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
