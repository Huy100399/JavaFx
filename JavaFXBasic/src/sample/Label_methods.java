package sample;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.InputStream;

//https://o7planning.org/en/11101/javafx-label-tutorial
//http://www.java2s.com/Tutorials/Java/JavaFX/0400__JavaFX_Label.htm
public class Label_methods extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage window= new Stage();
        window.setTitle("Label's methods");

        Label label1= new Label();
        label1.setText("do van huy ");

        // tao text goi y khi luot chuot qua label
        label1.setTooltip(new Tooltip("label1"));

       //Label Mouse Event

        label1.setOnContextMenuRequested(event -> {
            // cac cau lenh trong ham nay se thuc thi khi nhan chuot phai vao label1

            System.out.println("ban vua kich chuot phai ");
        });



        VBox layoutv= new VBox();
        layoutv.setSpacing(20);
        layoutv.getChildren().add(label1);


        Scene scen = new Scene(layoutv,200,200);
        window.setScene(scen);
        window.show();


    }
}
