package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Alear_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage win = new Stage();
        win.setResizable(true);
        win.setMinHeight(300);
        win.setMaxWidth(300);
        win.setTitle("Alear");

        StackPane layout= new StackPane();

        Button button = new Button("exit");
        button.setOnAction(event -> {

            // tao aleat
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("confirm");
            alert.setContentText("do you want exit");

               // tao cacbutton trong aleat
                ButtonType buttontype1 = new ButtonType("yes", ButtonBar.ButtonData.YES);
                ButtonType buttontype2 = new ButtonType("no", ButtonBar.ButtonData.NO);
                ButtonType buttontype3 = new ButtonType("cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            // add cac button vao
                alert.getButtonTypes().addAll(buttontype1,buttontype2,buttontype3);

                Optional<ButtonType> option = alert.showAndWait();

            if(option.get().getButtonData() == ButtonBar.ButtonData.YES )
            {
                System.exit(0);
            }
            else if(option.get().getButtonData()== ButtonBar.ButtonData.NO)
            {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                String txt = option.get().getText();
                alert1.setTitle("information !");
                alert1.setContentText("you have just chose "+txt);
                alert1.show();
            }
            else if(option.get().getButtonData()== ButtonBar.ButtonData.CANCEL_CLOSE)
            {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                String txt = option.get().getText();
                alert2.setTitle("information !");
                alert2.setContentText("you have just chose "+txt);
                alert2.show();
            }
//



        });

        layout.getChildren().add(button);

        Scene scen  = new Scene(layout,300,400);

        win.setScene(scen);
        win.show();

    }
}
