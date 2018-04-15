package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ComboBox_ extends Application {
    //https://o7planning.org/en/11081/javafx-combobox-tutorial
    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ComboBox.html


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ObservableList<String> observableList= FXCollections.observableArrayList();

        observableList.addAll("item1","item2","item3");

        ComboBox<String> comboBox= new ComboBox<>();
        comboBox.setPromptText("choose");
        comboBox.setItems(observableList);

        //##################################

        comboBox.setOnMouseClicked(event -> {
            System.out.println(comboBox.getSelectionModel().getSelectedItem());
        });

        comboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return null;
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        });



        ///###############################$


        FlowPane flowPane= new FlowPane();
        flowPane.getChildren().addAll(comboBox);

        Scene scene= new Scene(flowPane,300,300);

        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
