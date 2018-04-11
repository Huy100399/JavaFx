package other;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileChooser_ extends Application {

    private Desktop desktop= Desktop.getDesktop();

    public void printLog(TextArea textArea, List<File> listfile)
    {
        if(listfile.isEmpty()==true || listfile==null)
        {
            return;
        }

        for(File file : listfile)
        {
            textArea.appendText(file.getAbsolutePath()+"\n");
        }
    }


    public void openFile(File file)
    {
        Desktop desktop= Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    final FileChooser fileChooser= new FileChooser();


        //public final void setTitle(String value) :
        fileChooser.setTitle("fileChooser");//The title of the displayed file dialog.

        //public final void setInitialDirectory(File value): thiep lap thu muc dau tien de dc display khi open
        fileChooser.setInitialDirectory(new File("C:\\Users\\Administrator\\IdeaProjects\\JavaaFXexercise\\src\\myapp1"));
       // hoac fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        //public final void setInitialFileName(String value)


        TextArea textArea= new TextArea();
        textArea.setPrefSize(100,100);

        Button openfile_button= new Button("OpenFile");
        Button openmultifile_button= new Button("Open multi file");
        Button openSaveDialog_button= new Button("open save dialog");
        Button opendirectory_button= new Button("opendir");



        openfile_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                //public File showOpenDialog(Window ownerWindow) : tra ve file dc chon hoac null neu k chon file nao
                File file= fileChooser.showOpenDialog(primaryStage);
                if(file!=null)
                {
                    openFile(file);
                    //List<String> stooges = Arrays.asList("Larry", "Moe", "Curly"); : ham tra ve 1 list
                    List<File> listfile= Arrays.asList(file);
                    printLog(textArea,listfile);
                }
            }
        });

        openmultifile_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                //public List<File> showOpenMultipleDialog(Window ownerWindow) : tra ve 1 list file nhx file ma ng dung chon
                List<File> listfile= fileChooser.showOpenMultipleDialog(primaryStage);
                printLog(textArea,listfile);
            }
        });


        openSaveDialog_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //public File showSaveDialog(Window ownerWindow) : mo 1 dialog save file cho ng dung chon file de luu , tra vef file ng dung chon hoac null neu k chon j
                File file= fileChooser.showSaveDialog(primaryStage);

            }
        });


        VBox vBox= new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(textArea,openfile_button,openmultifile_button,openSaveDialog_button);


        Scene scene= new Scene(vBox,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
