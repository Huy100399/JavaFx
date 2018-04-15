package myapp1;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class BookListWindow  extends  Object{
    public  File bookdir= new File("C:\\Users\\Administrator\\IdeaProjects\\JavaaFXexercise\\src\\myapp1\\Book");
    public final Stage window= new Stage();
    public final ListView<Hyperlink> listbook= new ListView<>();
    public final Button addbook_button= new Button("Add Book");
    public final Button deletebook_button= new Button("Delete Book");


    public BookListWindow() {
        design();
    }

    public ObservableList<Hyperlink> getbookdir(File dir)
    {
        ObservableList<Hyperlink> booklist= FXCollections.observableArrayList();

        for(File file : dir.listFiles())
        {
            Hyperlink hyperlink= new Hyperlink();
            hyperlink.setText(file.getName());
            hyperlink.setOnAction(event -> {  // setup su kien cho moi hyper link khi dc bam vao
                Desktop desktop= Desktop.getDesktop();
                try {
                    desktop.open(file.getAbsoluteFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            booklist.add(hyperlink);
        }

        return  booklist;
    }

    public void design()
    {

        ObservableList<Hyperlink> booklist= getbookdir(bookdir);
        ListView<Hyperlink> listView= new ListView<>();
        listView.setItems(booklist);

        listView.setItems(booklist);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setPrefHeight(300);


        // setup event cho addbook_button

        addbook_button.setPrefSize(100,30);
        addbook_button.setTooltip(new Tooltip("add book into dir"));
        addbook_button.setOnAction(event -> {

            DirectoryChooser directoryChooser= new DirectoryChooser();
            directoryChooser.setTitle("choose book directory");
            directoryChooser.setInitialDirectory(new File(System.getProperty("user.home"))); // mac dinh mo thu muc home trc
            File newbookdir =directoryChooser.showDialog(window);
            //load lai booklist
            booklist.remove(0,booklist.size());
            for (Hyperlink hyperlink : getbookdir(newbookdir))
            {
                booklist.add(hyperlink);
            }

        });



        //setup cho deletebook_button

        deletebook_button.setPrefSize(100,30);
        deletebook_button.setTooltip(new Tooltip("choose to delete books"));
        deletebook_button.setDisable(true);

        listView.setOnMouseClicked(event -> {

            int i= listView.getSelectionModel().getSelectedIndex();


            if(i<0) deletebook_button.setDisable(true); // neu chon chout ngoai vung kich thuoc cua listView
            else  deletebook_button.setDisable(false);

            deletebook_button.setOnAction(event1 -> {

               File file= new File(String.valueOf(bookdir.listFiles()[i]));// xoa book
               booklist.remove(listView.getSelectionModel().getSelectedIndex()); // xoa file khoi booklist
                file.delete(); // xoa file khoi bo nho may

            });

        });



        // add cac thanh phan  vao layout

        VBox layout= new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);

        layout.getChildren().add(listView);
        layout.getChildren().add(addbook_button);
        layout.getChildren().add(deletebook_button);

        Scene scene= new Scene(layout,300,350);

        window.setTitle("Book List");
        window.setScene(scene);

    }

}
