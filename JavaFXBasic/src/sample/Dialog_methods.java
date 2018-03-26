package sample;

import javafx.application.Application;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.*;


//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html

////https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html
public class Dialog_methods extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Stage win = new Stage();
        Dialog<Pair<String,String>> dialog = new Dialog<>();


        ButtonType button1 = new ButtonType("exit", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType button2 = new ButtonType("OK", ButtonBar.ButtonData.YES);
        ButtonType button3 = new ButtonType("no", ButtonBar.ButtonData.NO);
        dialog.getDialogPane().getButtonTypes().addAll(button1,button2,button3);

        dialog.setOnCloseRequest(event -> { // khoi lenh trong nay dc goi khi co yeu cau tu ng dung tat dialog
            System.out.println("shutdown dialog");
        });

        dialog.setOnHidden(event -> { // khoi lenh dc goi khi ng dung an dialog
            System.out.println("hiden");
        });

        dialog.setOnHiding(event -> {
            System.out.println("hiding");
        });

        dialog.setOnShowing(event -> { // khoi lenh nay dc thu hien ngay trc khi show dialog
            System.out.println("is showing");
        });

        dialog.setOnShown(event -> { // khoi lenh nay thuc hien ngay sau khi dialog dc shown
            System.out.println("on shown");
        });

        System.out.println(dialog.getDialogPane().getButtonTypes().toString()); //tra ve cac loai Buttontype trong dialog





        dialog.showAndWait();
        win.setTitle("My App");



    }
}
