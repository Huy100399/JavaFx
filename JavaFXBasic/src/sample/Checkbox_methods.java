package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javafx/2/ui_controls/checkbox.htm

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/CheckBox.html#fire--
public class Checkbox_methods extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        CheckBox box1= new CheckBox();
        box1.setText("toan");

        //box1.setIndeterminate(true);  : o trang trai k chon , cx k dc bo chon

        box1.setAllowIndeterminate(false);


        // box1.isIndeterminate() : tra ve true neu o trang thai Indeterminate

        box1.setOnContextMenuRequested(event -> { // cac cau lenh dc thu hien khi bam chuot phai
            System.out.println(event.getSource().toString());

        });


        box1.setOnMouseClicked(event ->
        {
            // moi lan kich vao check bock thi ham nay de dc chay 1 lan , ke cac chuot trai lan chuot phai
            System.out.println("mouse clicked ");
        });


        box1.setOnAction(event ->
        { // moi lan kich vao check bock thi ham nay de dc chay 1 lan , chi chuot trai
            System.out.println("event");
        });

        box1.setOnMouseDragged(event -> { // ham dc goi khi chuot bam vao checkbox va keo chuot
            System.out.println("mouse dragged");

        });





        HBox layout= new HBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(0,box1);

        Scene scene= new Scene(layout,300,300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
