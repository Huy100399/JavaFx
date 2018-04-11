package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;


//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html


public class Dialog_login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        Dialog<Pair<String,String>> dialog = new Dialog<>();
        // khai bao Dialog , tra ve cap gia tri pair<>

        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Sing up");


        ButtonType loginbuttontype = new ButtonType("login", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelbuttontype= new ButtonType("cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().addAll(loginbuttontype,cancelbuttontype);

        TextField username= new TextField();
        PasswordField password = new PasswordField() ;

        username.setPromptText("username");
        password.setPromptText("password");

        Label user_name= new Label();
        Label pass_word = new Label();

        user_name.setText("User Name :");
        pass_word.setText("Pass Word: ");


        GridPane layout = new GridPane(); // 1 lop bo tri noi dung ben trong stage theo cac hanh va cac cot
        layout.setHgap(10); // set khoang cach moi thanh phan trong layout nay la 10
        layout.setVgap(10); //

        layout.add(user_name,0,0); // the, cac tham phan vao layout
        layout.add(pass_word,1,0);
        layout.add(username,0,1);
        layout.add(password,1,1);
        layout.setPadding(new Insets(20,150,10,10));


        Node  loginbutton= dialog.getDialogPane().lookupButton(loginbuttontype);
        loginbutton.setDisable(true);

        username.textProperty().addListener((observable, oldValue, newValue) -> {
            // .addListener((observable, oldValue, newValue)  : tra ve gia tri ccua va moi cua textfield username
            if(newValue.trim().isEmpty()==true)
            {
                loginbutton.setDisable(true);
            }
            else loginbutton.setDisable(false);

        });

        dialog.getDialogPane().setContent(layout);


        dialog.setResultConverter(dialogbutton->{ // neu ng dung bam nut tren dialo thi thuc hien len ben duoi , gan gia tri cua buttontye dc tra ve tu dialog cho dialogbutton moi dc tao ra
            if(dialogbutton.getButtonData()==loginbuttontype.getButtonData())
            { // neu nhu button loginbuttontype dc bam thi se chuyen doi kieu gia tri tra ve cua dialog sang Pair<String,String>
                return new Pair<>(username.getText(),password.getText());
            }
            else return null; // neu k thi k tra ve j ca
        });

        Optional<Pair<String,String>> result = dialog.showAndWait();

        result.ifPresent(UsernamePass ->{  // neu result khac null thi khoi lenh nay se dc thu thi
            // Usernamepass se lay gia tri cua result
            Alert userpass= new Alert(Alert.AlertType.INFORMATION);
            userpass.setTitle("information");
            userpass.setHeaderText("User and Pass");
            userpass.setContentText("User name : "+UsernamePass.getKey()+"\nPass : "+UsernamePass.getValue());

            userpass.show();
        });




    }
}
