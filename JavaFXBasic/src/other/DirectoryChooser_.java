package other;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

//https://docs.oracle.com/javase/8/javafx/api/javafx/stage/DirectoryChooser.html
//https://o7planning.org/en/11129/javafx-filechooser-and-directorychooser-tutorial#a3827995


public class DirectoryChooser_ extends Application {

    public void printlistfile(TextArea textArea, List<File> list)
    {
        if(list.isEmpty()==false)
        {
            textArea.clear();
            for(File file : list)
            {
                textArea.appendText(file.getAbsolutePath()+"\n");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        DirectoryChooser directoryChooser= new DirectoryChooser();

        //public final void setInitialDirectory(File value) : setup thu muc dau tien hien ra khi goi ham showDialog()
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home"))); // co the cho tham soo la duong dan 1 thu moc cx dc

        //public final void setTitle(String value)
        directoryChooser.setTitle("directoryChooser");

        //public File showDialog(Window ownerWindow) : show 1 dialog de ng dung lua chon , tra ve thu muc dc chon hoac null neu nhu k chon thu muc nao


        TextArea textArea= new TextArea();
        textArea.setPrefSize(400,400);

        Button opendir_button= new Button("opendir");

        opendir_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File dir= directoryChooser.showDialog(primaryStage);
                List<File> list = Arrays.asList(dir.listFiles()); // tra ve 1 mang kieu file chua cac file cua thu muc dir
                printlistfile(textArea,list);
            }
        });

        VBox vBox= new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(textArea,opendir_button);

        Scene scene= new Scene(vBox,400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
