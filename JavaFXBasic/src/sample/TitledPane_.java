package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://o7planning.org/en/11059/javafx-titledpane-tutorial
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TitledPane.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setOnContextMenuRequested-javafx.event.EventHandler-


public class TitledPane_ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create TitledPane.
        TitledPane titledPane= new TitledPane();
        titledPane.setText("this is a titledPane !"); // setup title cho titledPane

        // Content for TitledPane
        VBox layoutVbox= new VBox();
        // tao 1 layout de sap xep noi dung cho titledPane
        layoutVbox.getChildren().add(new Label("java"));
        layoutVbox.getChildren().add(new Label("c#"));
        layoutVbox.getChildren().add(new Label("python"));
        layoutVbox.getChildren().add(new Button("like"));

        //setup noi dung cho titledPane
        titledPane.setContent(layoutVbox);

        // Set Expaneded.
        titledPane.setExpanded(true);
        //tao them 1 layout nua de dat titledPane vao do
        VBox mainlayout= new VBox();
        mainlayout.setSpacing(20);
        mainlayout.getChildren().add(titledPane);


        // neu nhu ta k tao 1 layout de dat noi dung cua titledPane vao do , noi
        // cach khac neu ta dat truc tiepp cac controls vao content cua titledPane thi caci sau se chong len cai trc

        // vi du minh hoa
        TitledPane titledPanesimple= new TitledPane();
        titledPanesimple.setText("this is a titledPane,too");
        // setup truc tiep noi dung cho titledPane , k tao 1 lay out dem nao ca
        titledPanesimple.setContent(new Label("do van huy "));
        titledPanesimple.setContent(new Button("like"));
        // va ket qua la button se nam de len label
        titledPanesimple.setExpanded(true);

        mainlayout.getChildren().add(titledPanesimple);

        titledPane.expandedProperty().addListener((observable, oldValue, newValue) -> {
            // ham nay se dc goi ngay khi gia tri cua expandedProperty thay doi , (tuc la titledPane.isExpanded() thay doi tu tru sang false hoac nguoc lai)
            // observable  se lay gia tri cua titledPane.expandedProperty() vao so sanh 2 gia tri moi va cu neu nhu co su khac biet thi thuc hien cac cau lenh sau
            // hieu don gia thi khi ta bam nut mo rong cua titledPane thi ham nay se dc goi
            System.out.println("observable :"+observable);
            System.out.println("expandedProperty : "+oldValue);
            System.out.println("expandedProperty new  :"+newValue);
        });


            titledPane.contentProperty().addListener((observable, oldValue, newValue) -> {
            // ham nay dc khi ma conten cua titledPane thay doi
                System.out.println("content of titledPane is changed !" );
                System.out.println("observable : "+observable);
                System.out.println("oldValue :"+oldValue);
                System.out.println("newValue : "+newValue);
                System.out.println("content of titledPane :"+titledPane.contentProperty().getName()+"\n"+titledPane.contentProperty().getValue());

            });
            // toi day ta thay doi content cua titledPane nen ham ben tren se dc goi
            titledPane.setContent(new Button("add"));



            titledPane.setOnContextMenuRequested(event -> {
                // ham chay khi kich chuot phai vao titledPane
                System.out.println("right clicked");

            });


            titledPane.setOnMouseClicked(event -> {
                // ham nay ddc goi khi kich chuot vao titledPane , ca chuot trai lan phai
                System.out.println("mouse is clicked");
            });

            titledPane.setOnMouseDragged(event -> {
                // ham nay dc goi khi dc nhan va keo qua lai tren titledPane , ca chuot trai lan phai
                System.out.println("mouse is dragging !");
            });

            // con vo so ham khac nua





        Scene scene= new Scene(mainlayout,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}


