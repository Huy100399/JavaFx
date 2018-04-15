package myapp1;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Optional;
import java.util.Scanner;

import static myapp1.handling.root_user;
import static myapp1.handling.welcomeWindow;

public class SigupWindow {

    public final File profiFile= new File("C:\\Users\\Administrator\\IdeaProjects\\JavaaFXexercise\\src\\myapp1\\textfile\\profile.txt");
    public   Dialog<Pair<String,String>> window;
    public   Label newusername_label ;
    public   Label newpassword_label;
    public   TextField newusername_text;
    public   PasswordField newpassword_text;
    public   ButtonType cancel_buttontype;
    public  ButtonType ok_buttontype;

    public SigupWindow() {
        design();
        setevent();
    }

    public  void design()
    {

        window= new Dialog<>();
        newusername_label= new Label("New User :");
        newpassword_label= new Label("New Pass :");
        newusername_text= new TextField();
        newusername_text.setPromptText("New User");
        newpassword_text= new PasswordField();
        newpassword_text.setPromptText("New Pass");


        GridPane mainlayout = new GridPane();
        mainlayout.setHgap(10);
        mainlayout.setVgap(10);

        cancel_buttontype= new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        ok_buttontype= new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

        mainlayout.add(newusername_label,0,0);
        mainlayout.add(newpassword_label,0,1);
        mainlayout.add(newusername_text,1,0);
        mainlayout.add(newpassword_text,1,1);
        window.getDialogPane().getButtonTypes().addAll(cancel_buttontype,ok_buttontype);
        window.setHeaderText("Sigup");
        window.setTitle("Sigup");
        window.getDialogPane().setContent(mainlayout);

    }



    public void setevent()
    {
        // gan node bang 1 ok_buttontype tren loginWindow
        Node ok_sigup= window.getDialogPane().lookupButton(ok_buttontype);
        ok_sigup.setDisable(true); // diable nut ok_sigup


        boolean user_pass_valid=true;
        newusername_text.textProperty().addListener((observable, oldValue, newValue) -> {
            // ham nay dc goi khi co su thay doi gia gia tri moi va cua cua cac textfield
            ok_sigup.setDisable(newValue.trim().isEmpty()); // neu nhu gia tri moi cua user = rong thi se diable nut ok_sigup
        });

        newpassword_text.textProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue.trim().isEmpty()==true) ok_sigup.setDisable(true);
            ok_sigup.setDisable(newValue.trim().isEmpty());
        });


        window.setResultConverter(dialogbutton->{
            //bat su kien khi mot nut tren dialog dc bam (trong trg hop nay la nut tren sigupwindow)
            if(dialogbutton.getButtonData()==ok_buttontype.getButtonData())
            { // neu nut dc bam la nut ok_buttontype thi lam cac cau lenh sau
                welcomeWindow.win.show();
                window.close();
                return new Pair<>(newusername_text.getText(),newpassword_text.getText()); // chuyen doi kieu tra ve cua dialog(sigupwindow) sang pair<String,String>
            }
            if(dialogbutton.getButtonData()==cancel_buttontype.getButtonData())
            {
                welcomeWindow.win.show();
                window.close();

            }
            return null;

        });

        // tao mot container chua kieu tra ve Pair<String,String> cua sigupwindow
        Optional<Pair<String,String >> optional= window.showAndWait();

        optional.ifPresent(bienjcxdc -> { //neu optional khac null thi thuc hien cac lenh sau

            // tao file voi dg dan toi file text chua thong tin ng dung


            boolean userisexist= false;

            try {
                Scanner scanner= new Scanner(profiFile);

                // kiem tra su ton tai cua user va pass nhap vao xem da trung voi cai nao cu hay chua
                while (scanner.hasNextLine()==true)
                {
                    String usr= scanner.nextLine();
                    String pass= scanner.nextLine();

                    if(optional.get().getKey().trim().equals(usr.trim())
                            || optional.get().getKey().trim().equals(root_user))
                    {
                        userisexist=true;
                        break;
                    }
                }

            }
            catch (Exception e)
            {
                e.getStackTrace();
            }



            if(userisexist!=true)
            {
                //neu chua trung thi ghi vao file va thong bao sigup thanh cong
                try(FileWriter print= new FileWriter(profiFile,true))
                {

                    print.write(optional.get().getKey().trim()+"\n");
                    print.write(optional.get().getValue().trim()+"\n");


                } catch (Exception e) {
                    System.out.println("doc ghi pro file bi loi !");
                }

                Alert sigupsuccess= new Alert(Alert.AlertType.INFORMATION);
                sigupsuccess.setHeaderText("Sigup Successfully!");
                sigupsuccess.setTitle("Sigup Successfully!");
                sigupsuccess.show();
            }
            else
            {
                Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText("user is existed !");
                alert.show();

            }



        });


    }
}
