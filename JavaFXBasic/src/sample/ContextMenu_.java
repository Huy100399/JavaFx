package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;


//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ContextMenu.html#show-javafx.scene.Node-double-double-
//https://o7planning.org/en/11115/javafx-contextmenu-tutorial
public class ContextMenu_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage window= new Stage();

        Label label = new Label();
        label.setTooltip(new Tooltip("this s label !"));
        label.setText("label");


        // tao mot vong tron
        Circle circle= new Circle();
        circle.setCenterX(50); // setup toa do tam
        circle.setCenterX(50);
        circle.setRadius(20); // setup ban kinh


        VBox layoutV = new VBox(); // tao 1 layout Vbox (la 1 loai layout sap xep cac phan tu thep chieu doc)
        layoutV.setSpacing(20);  //khoang cach giua cac phan tu ben trong layoutV
        layoutV.setAlignment(Pos.BASELINE_CENTER);  // bat dau sap xep tu trung tam va tu tren xuong
        layoutV.getChildren().addAll(circle,label); // add cac thanh phan

        ContextMenu contentextmenu= new ContextMenu();  // tao 1 menucontentext

        MenuItem menuItem1= new MenuItem("menu1"); // tao cac menuitem va setupp su kien cho chung
        menuItem1.setOnAction(event -> {
            label.setText("menu1");
        });

        MenuItem menuitem2= new MenuItem("menu2");
        menuitem2.setOnAction(event -> {
            label.setText("menu2");

        });

        contentextmenu.getItems().addAll(menuItem1,menuitem2); // add cac menuitem vao contentext menu

        //khi bam chuot phai vao hinh tron
        circle.setOnContextMenuRequested(event -> {
            contentextmenu.show(circle,500,200);

        });



        Scene scen= new Scene(layoutV,300,300);

        window.setTitle("contentextmenu");
        window.setScene(scen);
        window.show();

    }
}
