package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


//https://o7planning.org/en/10625/javafx-hbox-vbox-layout-tutorial

public class Hbox_Vbox_layout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage window= new Stage();



        Button optionbutton = new Button("option");
        optionbutton.setPrefSize(100,100);
        optionbutton.setTooltip(new Tooltip("show menu"));

        Button exitbutton= new Button("exit");
        exitbutton.setPrefSize(100,100);
        exitbutton.setTooltip(new Tooltip("exit program"));


        Button button1= new Button("button1");
        Button button2= new Button("button2");
        Label label1= new Label("label1");
        Label label2= new Label("label2");
        CheckBox box1= new CheckBox("checkbox1");
        CheckBox box2= new CheckBox("checkbox2");


        VBox Vboxlayout = new VBox();
        Vboxlayout.setSpacing(30);// khong cach giuac cac thanh phan ben trong la 20
        Vboxlayout.setPadding(new Insets(10,20,30,40)); // khoang cach cua layout so voi scen cach canh tren 10 , cach canh phai 20 ,..
        Vboxlayout.getChildren().addAll(button1,button2,box1,box2,label1,label2);
        Vboxlayout.setAlignment(Pos.CENTER);// sap sep theo chieu doc tu giua

        HBox Hboxlayout = new HBox();
        Hboxlayout.setSpacing(30);
        Hboxlayout.setPadding(new Insets(10,20,30,40));
        Hboxlayout.getChildren().addAll(button1,button2,box1,box2,label1,label2);
        Hboxlayout.setAlignment(Pos.CENTER);// sap xep thep chieu ngang , o giau so voi 2 mep tren va duoi



        Scene Hboxscen= new Scene(Hboxlayout,500,500);
        Scene Vboxscen= new Scene(Vboxlayout,500,500);


        ContextMenu contextMenu= new ContextMenu();
        contextMenu.centerOnScreen();


        MenuItem menuItem1= new MenuItem();
        menuItem1.setText("show window with Vbox layout");

        MenuItem menuItem2= new MenuItem();
        menuItem2.setText("show window with Hbox layout");

        menuItem1.setOnAction(event -> { // khi menuitem1 dc chon thi lam cau lenh ben trong
            window.setTitle("Vboxslayout");
            window.setScene(Vboxscen);
            window.show();

        });

        menuItem2.setOnAction(event -> {
            window.setTitle("Hboxlayout");
            window.setScene(Hboxscen);
            window.show();
        });

        contextMenu.getItems().addAll(menuItem1,menuItem2);



        optionbutton.setOnAction(event -> {

            contextMenu.show(optionbutton,400,300);

        });

        exitbutton.setOnAction(event -> {

            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("do you want exit program");


            Optional<ButtonType> option= alert.showAndWait();

            if(option.get().getButtonData()== ButtonBar.ButtonData.OK_DONE) System.exit(0);

        });

        GridPane griplayout= new GridPane();
        griplayout.setPadding(new Insets(20,20,20,20));
        griplayout.setHgap(20);
        griplayout.setVgap(20);
        griplayout.setAlignment(Pos.BASELINE_CENTER);
        griplayout.add(optionbutton,0,0);
        griplayout.add(exitbutton,0,1);


        Scene primaryscen= new Scene(griplayout,300,300);
        primaryStage.setScene(primaryscen);
        primaryStage.show();



    }
}
