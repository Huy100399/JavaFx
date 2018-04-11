package myapp1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeWindow {

    public final Stage win = new Stage();
    public final Button sigup_button= new Button("Sigup");
    public final Button login_button= new Button("Login");
    public final Button exit_button= new Button("Exit");

    public WelcomeWindow() {
        design();
    }

    public void design() {

        // thiet ke


        Label label= new Label("WELCOME TO MY APP");

        sigup_button.setPrefSize(60,30);
        login_button.setPrefSize(60,30);
        exit_button.setPrefSize(60,30);

        HBox layout1= new HBox();
        layout1.setAlignment(Pos.CENTER);
        layout1.setSpacing(30);
        layout1.getChildren().addAll(sigup_button,login_button,exit_button);

        VBox layout2= new VBox();
        layout2.setAlignment(Pos.CENTER);
        layout2.setSpacing(30);
        layout2.getChildren().add(label);

        VBox mainlayout= new VBox();
        mainlayout.setAlignment(Pos.CENTER);
        mainlayout.setSpacing(30);
        mainlayout.getChildren().addAll(layout2,layout1);

        Scene scene= new Scene(mainlayout,300,200);

        win.setTitle("WELCOME");
        win.setScene(scene);

    }
}
