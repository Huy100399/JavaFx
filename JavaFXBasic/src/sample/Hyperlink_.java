package sample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


//https://o7planning.org/en/11133/javafx-hyperlink-tutorial
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Hyperlink.html


public class Hyperlink_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Hyperlink hyperlink= new Hyperlink("go to google");

        hyperlink.setOnAction(event -> {
            // khi kich vao link se toi dia chi url dc truyen vao trong ham ben duoi
            getHostServices().showDocument("https://www.google.com.vn/?hl=vi");
        });




        hyperlink.setUnderline(true);
      //  hyperlink.setVisited(true); // thiet lap hyperlink la link dc dc visited


       // hyperlink.fire(); // thuc hien event dau tien cua hyperlink


        hyperlink.visitedProperty().addListener((observable, oldValue, newValue) -> {
            // ham dc goi khi trang thai isvisited cua hyperlink thay doi tu true sang false hoa ng lai
            System.out.println(observable);
            System.out.println(oldValue);
            System.out.println(newValue);
            System.out.println("isvisited change ");
        });



        FlowPane layout = new FlowPane();
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().add(hyperlink);

        Scene scene= new Scene(layout,200,300);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
