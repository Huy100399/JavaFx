package myapp1;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

import static myapp1.handling.root_password;
import static myapp1.handling.root_user;

public class RootWindow {

    public final File profiFile= new File("C:\\Users\\Administrator\\IdeaProjects\\JavaaFXexercise\\src\\myapp1\\textfile\\profile.txt");
    public final Stage window= new Stage();
    public final Button deleteuser_button=new Button("Delete User");
    public final Button deleteAllprofile_button= new Button("Delete All User's profile");
    public final Button blockuser_button= new Button("Block User");
    public final Button viewprofile_button= new Button("View All User's Profile");
    public final Button exit_button = new Button("Exit");

    public RootWindow() {
        design();
        setevent();
    }

    public void  design()
    {
        TitledPane titledPane = new TitledPane();
        titledPane.setText("What Do You Want ?");


        deleteuser_button.setPrefSize(100,30);
        deleteAllprofile_button.setPrefSize(100,30);
        blockuser_button.setPrefSize(100,30);
        viewprofile_button.setPrefSize(100,30);
        exit_button.setPrefSize(100,30);

        deleteuser_button.setTooltip(new Tooltip("Delete User"));
        deleteAllprofile_button.setTooltip(new Tooltip("Delete All User's profile"));
        blockuser_button.setTooltip(new Tooltip("Block User"));
        viewprofile_button.setTooltip(new Tooltip("View All User's Profile"));




        VBox vBoxlayout= new VBox();
        vBoxlayout.setSpacing(10);
        vBoxlayout.setAlignment(Pos.CENTER);

        vBoxlayout.getChildren().addAll(deleteuser_button,deleteAllprofile_button,blockuser_button,viewprofile_button);

        titledPane.setContent(vBoxlayout);
        titledPane.setExpanded(true);

        VBox mainlayout= new VBox();
        mainlayout.setAlignment(Pos.CENTER);
        mainlayout.setSpacing(20);

        mainlayout.getChildren().addAll(titledPane,exit_button);

        Scene scene= new Scene(mainlayout,300,300);

        window.setTitle("Hello Sir");
        window.setScene(scene);




    }


    public void setevent()
    {
        //setup event
        //################################################################


        // bat su kien khi bam vao nut deleteuser_button tren rootWindow
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
        deleteuser_button.setOnAction(event1 -> {

            //design
            Dialog<String> dialog = new Dialog<>();

            dialog.setTitle("Delete user");
            dialog.setHeaderText("Enter username that you want to delete");

            Label user_label= new Label();
            user_label.setText("Username :");

            ButtonType delete_button= new ButtonType("Delete", ButtonBar.ButtonData.YES);
            ButtonType cancel_bButtonType= new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            TextField user_text= new TextField();
            user_text.setPromptText("username");

            GridPane layout= new GridPane();
            layout.setVgap(10);
            layout.setHgap(10);
            layout.setAlignment(Pos.CENTER);

            layout.add(user_label,0,0);
            layout.add(user_text,1,0);

            dialog.getDialogPane().getButtonTypes().addAll(delete_button,cancel_bButtonType);

            dialog.getDialogPane().setContent(layout);

            //setup event

            Node button= dialog.getDialogPane().lookupButton(delete_button);
            button.setDisable(true);
            user_text.textProperty().addListener((observable, oldValue, newValue) -> {

                button.setDisable(newValue.trim().isEmpty());

            });

            dialog.setResultConverter(param -> {
                if(param.getButtonData()==delete_button.getButtonData())
                {
                    return new String(user_text.getText().trim());
                }
                if(param.getButtonData()==cancel_bButtonType.getButtonData())
                {
                    dialog.close();
                }
                return  null;
            });

            Optional<String> optionalS= dialog.showAndWait();

            optionalS.ifPresent(s -> {

                boolean line_exist=false;
                try {
                    Scanner scanner= new Scanner(profiFile);
                    String []lines= new String[100]; // tao mang de luu cac dang doc ti file
                    int i=0;
                    while (scanner.hasNextLine()==true)
                    {
                        String linetemp= scanner.nextLine(); // linetemp gan bang tung dong 1 dc doc tu scanner
                        if(linetemp.equals(optionalS.get().toString()))
                        {
                            line_exist=true;
                            scanner.nextLine(); // neu trung thi doc dong tiep theo nhg k ghi vao mang (bo qua dong mk)
                        }
                        else
                        {
                            lines[i]=new String(linetemp); // neu k khop thi ghi lai vao mang de lat nua ghi de len file
                        }
                        i++;
                    }


                    if(line_exist==false)
                    {
                        Alert alert= new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText("User don't exist !");
                        alert.show();
                    }
                    else
                    {

                        try (FileWriter writer= new FileWriter(profiFile)){
                            // ghi de mang string len profile de update thay doi
                            for (int j=0;j<lines.length;j++)
                            {
                                if(lines[j]!=null)
                                writer.write(lines[j]+"\n");
                            }
                            // luon nho ghi vao file tk cua root neu file trong
                            if(profiFile.length()==0)
                            {
                                writer.write(root_user+"\n"+root_password+"\n");
                            }
                        }
                        catch (Exception e)
                        {
                            e.getStackTrace();
                        }

                        Alert alert= new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Deleted successful !");
                        alert.show();

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

        });

        // bat su kien khi bam vao nut deleteAlluser_button tren rootWindow
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2
        deleteAllprofile_button.setOnAction(event1 -> {

            // mo file profile
            try(FileWriter writer= new FileWriter(profiFile,false))// khong cho phep ghi noi tiep cuoi file
            {
                writer.write("");// in ra ki tu rong tuc la xoa file
                writer.write(root_user+"\n");  // sau khi xoa thi p ghi vao tk cua root neu k cac bc kiem tra luc login va sigup se k dung vi file
                writer.write(root_password+"\n");//pro file se k co gi nen cau leng hasNextLine()==true se k con dung nua

                Alert delete_complete= new Alert(Alert.AlertType.INFORMATION);
                delete_complete.setHeaderText("Delete completed !");
                delete_complete.setTitle("Delete All user");
                delete_complete.show();
            }
            catch (Exception e)
            {
                e.getStackTrace();
            }

        });




        // bat su kien khi bam vao nut blockuser_button  tren rootWindow
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

        blockuser_button.setOnAction(event1 -> {



        });



        // bat su kien khi bam vao nut viewprofile_button  tren rootWindow
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

        viewprofile_button.setOnAction(event1 -> {


            TextArea userprofile= new TextArea();
            userprofile.setWrapText(true);

            try (Scanner scanner= new Scanner(profiFile))
            {
                while(scanner.hasNextLine()==true)
                {
                    userprofile.appendText(scanner.nextLine()+"\n");
                }
            }
            catch (Exception e)
            {
                e.getStackTrace();
            }

            ScrollPane scrollPane= new ScrollPane();
            scrollPane.setContent(userprofile);

            Scene scene= new Scene(scrollPane,300,300);

            Stage stage= new Stage();
            stage.setTitle("User's profile");
            stage.setScene(scene);
            stage.show();

        });



        // bat su kien khi bam vao nut exit_button  tren rootWindow
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

        exit_button.setOnAction(event1 -> {

            window.close(); // dong rootWindow

        });


        //##################################################################
    }
}
