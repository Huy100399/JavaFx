package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.security.Key;
import java.util.Optional;

public class Dialog_Alert_test1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        String USER = "1";
        String PASS = "1";

        Stage window= new Stage();

        window.setTitle("Menu");


        //tao button cho cua so chinh
        Button loginbutton = new Button();
        Button exitbutton = new Button();
        loginbutton.setText("Login");
        exitbutton.setText("Exit");

        // tao layout cho cua so chinh
        GridPane layout = new GridPane();
        layout.setVgap(20);
        layout.setHgap(20);
        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.setGridLinesVisible(false); // hien thi dang luoi trong layout nay khi show
        layout.add(loginbutton,3,1);
        layout.add(exitbutton,3,3);

        Scene scen = new Scene(layout,300,300);





        // tao cua so thong bao khi bam exit
        Alert exitAlert= new Alert(Alert.AlertType.WARNING);
        exitAlert.setHeaderText("do you want exit ?");
        exitAlert.setTitle("comfirm !");

        ButtonType cancelexit= new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);

        exitAlert.getButtonTypes().addAll(cancelexit);




        //tao dialog khi bam vao login
        Dialog<Pair<String,String>> dialog = new Dialog<>();

        ButtonType loginbuttontype = new ButtonType("Login", ButtonBar.ButtonData.YES);
        ButtonType cancelbuttontype = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        Label user = new Label("Username : ");
        Label pass = new Label("Password : ");
        TextField username = new TextField();
        PasswordField password = new PasswordField();



        GridPane layoutlogin = new GridPane();
        layoutlogin.setHgap(10);
        layoutlogin.setVgap(10);
        layoutlogin.add(user,0,0);
        layoutlogin.add(pass,0,1);
        layoutlogin.add(username,1,0);
        layoutlogin.add(password,1,1);


        dialog.setHeaderText("Enter username and password !");
        dialog.getDialogPane().setContent(layoutlogin);
        dialog.getDialogPane().getButtonTypes().addAll(loginbuttontype,cancelbuttontype);

        // su li su kien cho loginbutton
        loginbutton.setOnAction(event -> {

            //tao mot container chua loginbuttontype
            Node loginbuttontype_= dialog.getDialogPane().lookupButton(loginbuttontype);// tra ve loginbuttontype tu dialog
            loginbuttontype_.setDisable(true);

            username.textProperty().addListener((observable, oldValue, newValue) -> {
            // su li su kien cho textfield username , trc va sau khi nhap gia tri
                loginbuttontype_.setDisable(newValue.trim().isEmpty()); // neu k nhap hoac nhap toan dau cach thi an loginbuttontype_

            });

            dialog.setResultConverter(dialogbutton ->{
            // su li su kien khi cac button tran dialog dc bam , dialog se tra ve kieu buttontype cua button dc bam tren no
                if(dialogbutton.getButtonData()==loginbuttontype.getButtonData())// neu bam loginbuttontype
                {
                    return new Pair<>(username.getText().trim(),password.getText().trim()); // chuyen kieu traa ve cua dialog sang cap gia tri String (Pair)
                }

                    return null;

            } );


            Optional<Pair<String,String>> result = dialog.showAndWait();// tao mot container chua cap gia tri Pair cua dialog khi hien thi va dc bam nut

            if(result!=null)
            {
                if(result.get().getValue().trim()==USER && result.get().getKey().trim()==PASS)
                {
                    Alert successful = new Alert(Alert.AlertType.INFORMATION);
                    successful.setTitle("login ok");
                    successful.setHeaderText("login successful !");

                    successful.show();
                }

                else
                {
                    Alert failed = new Alert(Alert.AlertType.WARNING);
                    failed.setTitle("login failed");
                    failed.setHeaderText("username or pass is incorrec !");
                    failed.show();
                }
            }


        });

        exitbutton.setOnAction(event -> {

            Optional<ButtonType> option= exitAlert.showAndWait();

            if(option.get().getButtonData()== ButtonBar.ButtonData.OK_DONE)
            {
                System.exit(0);
            }

        });


        window.setScene(scen);
        window.show();

    }
}
