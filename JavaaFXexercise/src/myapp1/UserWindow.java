package myapp1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

public class UserWindow {

    public final Stage window= new Stage();
    public final Button readbook_button= new Button("Read Book");
    public final Button webbrowser_button= new Button("WebBrowser");
    public final Button music_button= new Button("Music");
    public final Button playvideo_button= new Button("Play Video");
    public final Button playgame_button= new Button("Play Game");
    public final Button exit_button= new Button("Exit");

    public UserWindow() {
        design();
    }

    public void design()
    {

        readbook_button.setPrefSize(100,30);
        webbrowser_button.setPrefSize(100,30);
        music_button.setPrefSize(100,30);
        playvideo_button.setPrefSize(100,30);
        playgame_button.setPrefSize(100,30);
        exit_button.setPrefSize(100,30);



        //setup event

        //##############################################

        readbook_button.setOnAction(event1 -> {


            BookListWindow bookListWindow= new BookListWindow();

            bookListWindow.window.showAndWait();


        });


        exit_button.setOnAction(event -> {

            window.close();

        });

        //###############################################################3


        VBox layout= new VBox();
        layout.setSpacing(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(readbook_button,webbrowser_button,music_button,playvideo_button,playgame_button,exit_button);

        Scene scene= new Scene(layout,300,300);

        window.setTitle("Hello");
        window.setScene(scene);

    }
}
