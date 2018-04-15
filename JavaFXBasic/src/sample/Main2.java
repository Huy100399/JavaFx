package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
public class Main2 extends Application {

    Stage win ;
    Scene scen1, scen2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        win = primaryStage;

        // scen1
        Label label1 = new Label("welcome");
        Button button1= new Button();
        button1.setText("next");
        button1.setOnAction(event -> {
            win.setScene(scen2);
        });
        VBox layou1 = new VBox();
        layou1.getChildren().addAll(button1,label1);
        scen1 = new Scene(layou1,300,300);

        //scen2
        Label label2 = new Label("exit");
        Button button2= new Button("come back");
        button2.setOnAction(event -> {
            win.setScene(scen1);
        });
        VBox layout2= new VBox();
        layout2.getChildren().addAll(button2,label2);
        scen2 = new Scene(layout2,200,300);

        win.setScene(scen1);
        win.show();
    }
}
