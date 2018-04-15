package myapp1;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import static myapp1.handling.root_password;
import static myapp1.handling.root_user;
import static myapp1.handling.welcomeWindow;

public class LoginWindow {

    public final File profiFile= new File("C:\\Users\\Administrator\\IdeaProjects\\JavaaFXexercise\\src\\myapp1\\textfile\\profile.txt");
    public Dialog<Pair<String,String >> window= new Dialog<>();
    public Label username= new Label("Usename :");
    public Label passwprd= new Label("PassWord :");
    public TextField username_text= new TextField();
    public PasswordField password_text= new PasswordField();
    public ButtonType login_buttontype= new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
    public ButtonType cancel_buttontype= new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    public LoginWindow() {
        design();
        setevent();
    }

    public void design()
    {

        username_text.setPromptText("User Name");
        password_text.setPromptText("PassWord");

        GridPane layout= new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.add(username,0,0);
        layout.add(passwprd,0,1);
        layout.add(username_text,1,0);
        layout.add(password_text,1,1);

        window.setHeaderText("Login");
        window.setTitle("Login");
        window.getDialogPane().getButtonTypes().addAll(login_buttontype,cancel_buttontype);
        window.getDialogPane().setContent(layout);

    }



    public void setevent()
    {
        // cac buoc tiep theo gipng nhu phan bat su kien cho nut sigup_button
        Node loginbutton= window.getDialogPane().lookupButton(login_buttontype);
        loginbutton.setDisable(true);

        username_text.textProperty().addListener((observable, oldValue, newValue) -> {

            loginbutton.setDisable(newValue.trim().isEmpty());

        });

        window.setResultConverter(login -> {

            if(login.getButtonData()==login_buttontype.getButtonData())
            {
                welcomeWindow.win.show();
                window.close();

                return new Pair<>(username_text.getText(),password_text.getText());
            }
            if(login.getButtonData()==cancel_buttontype.getButtonData())
            {
                welcomeWindow.win.show();
                window.close();
            }
            return null;
        });

        Optional<Pair<String,String >> optional=window.showAndWait();

        optional.ifPresent(bienjcxdc -> { // neu nhu user va pass ng dung nhap vao khac null hi lam cac lenh ben duoi


            try {
                Scanner scan= new Scanner(profiFile);

                boolean user_valid= false;// bien co hieu de kiem tra user va pass hop le

                while (scan.hasNextLine()==true) // khi file van  con dong ke tiep thi van chay vong lap while nay
                {
                    // doc 2 dong mot thu file profile
                    String usr= scan.nextLine();
                    String pass= scan.nextLine();

                    if(usr.trim().equals(optional.get().getKey().trim()) && pass.trim().equals(optional.get().getValue().trim())
                            //kiem tra them dieu kien xem tk nhap vao co laf tk root hay k
                            || root_user.equals(optional.get().getKey().trim()) && root_password.equals(optional.get().getValue().trim()))
                    { // neu user va pass ng dung nhap vao trung voi mot user va pass nao do  trong profile.txt thi lam cac cau lenh sau
                        user_valid=true;// neu co trung voi 1 trong so cac user trong profile thi user_valid=true


                        // neu tk nhap vao la tk root thi thuc thi cac cong vc danh cho tk root
                        //#####################################################################

                        if(optional.get().getKey().trim().equals(root_user) && optional.get().getKey().trim().equals(root_password))
                        {
                            window.close();

                            RootWindow rootWindow= new RootWindow();
                            rootWindow.window.show();

                        }


                        // neu tk nhap vao KHONG p la tk root thi thuc thi cong vec danh cho cac tk thong thuon
                        //###############################################################################

                        else
                        {

                            UserWindow userWindow= new UserWindow();
                            userWindow.window.show();

                        }

                    }
                }



                if(user_valid==false) // neu khong thi thong bao loi
                {
                    Alert user_invalid= new Alert(Alert.AlertType.ERROR);
                    user_invalid.setHeaderText("User Or Pass Incorrec !");
                    user_invalid.setTitle("User invalid !");

                    user_invalid.show();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

}
