package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextInputDialog.html
//https://o7planning.org/en/11537/javafx-textinputdialog-tutorial

public class TextInputDialog_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextInputDialog textInputDialog= new TextInputDialog();
        textInputDialog.setHeaderText("Headertext");
        textInputDialog.setTitle("title");
        textInputDialog.setContentText("ContentText");

        ButtonType enter_butto= new ButtonType("enter");


        Optional<String> result = textInputDialog.showAndWait(); //show va cho ng dung bam ok hoac cancel neu ok thi giia tri String dc tra ve khi bam nut ok la chuoi ng dung nhap vaao  textInputDialog

        result.ifPresent(s -> { // neu result khac rong thi in s (ket qua tra ve tu textInputDialog kie string , day la chuoi ma ng dung nhap vao )
            System.out.println(s);
        });



        textInputDialog.showAndWait();


    }
}
