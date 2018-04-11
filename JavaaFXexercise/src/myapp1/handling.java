package myapp1;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class handling {

    public static final String root_user="root",root_password="root";

    public static final WelcomeWindow welcomeWindow= new WelcomeWindow();

    public static void handlingevent()
    {

        welcomeWindow.win.show(); // show welcomeWindow


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // bat su kien neu nhu button sigup_button dc bam


        welcomeWindow.sigup_button.setOnAction(event ->
        {
            welcomeWindow.win.close(); // close welcomeWindow
            SigupWindow sigupwindow= new SigupWindow(); // show sigupwindow

        });



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // bat su kkien khinut login_button cua welcomeWindow dc bam


        welcomeWindow.login_button.setOnAction(event ->
        {
            welcomeWindow.win.close(); // close welcomeWindow
            LoginWindow loginWindow= new LoginWindow();

        });



        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        welcomeWindow.exit_button.setOnAction(event ->
        { // neu bam vao nut exit_button thi sung trg chinh
            welcomeWindow.win.close();

            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Do You Want Exit?");

            ButtonType cancel_exit= new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().add(cancel_exit);

            Optional<ButtonType> optional= alert.showAndWait();

            if(optional.get().getButtonData()== ButtonBar.ButtonData.OK_DONE)
            {
                System.exit(0);
            }
            else welcomeWindow.win.show();


        });
    }

}
