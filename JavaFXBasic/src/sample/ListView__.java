package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Collections;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ListView.html
//https://o7planning.org/en/11063/javafx-listview-tutorial


class Book{

    private Long id;
    private String code;
    private String name;

    public Book(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}



public class ListView__ extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {


        Book book1 = new Book(1L, "J01", "1");
        Book book2 = new Book(2L, "J02", "2");
        Book book3 = new Book(2L, "C01", "3");
        Book book4 = new Book(1L, "J01", "4");
        Book book5 = new Book(2L, "J02", "5");
        Book book6 = new Book(2L, "C01", "6");
        Book book7 = new Book(1L, "J01", "7");
        Book book8 = new Book(2L, "J02", "8");
        Book book9 = new Book(2L, "C01", "9");


        // To Creating a Observable List
        ObservableList<Book> books= FXCollections.observableArrayList();

        books.add(0,book1); // add cac thanh pphan vao Observablelist , phai add bat dau tu index 0
        books.add(1,book2);
        books.add(2,book3);
        books.addAll(book4,book5,book6,book7,book8,book9);

        // Create a ListView
        ListView<Book> listView= new ListView<>();

        listView.setItems(books); // setup items cho listviews

        //setup selection model
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Select item at index = 1,2 (chon trc muc 1 , 2)
        listView.getSelectionModel().selectIndices(0);// index 0 se dc chon tu dau

        // Focus methods (cac methods lien quan toi forcus model)
        listView.getFocusModel().focus(1); // tam hieu la khi hien thi listview len se ve vien cho index 2

        listView.getFocusModel().focusNext(); // nếu như index đang dc vẽ viền (forcus) dang la n thì sau khi gọi hàm này thì index n+1 sẽ là index forcus sau khi gọi hàm

        listView.getFocusModel().focusPrevious(); // tac dụng nguoc lai ham tren

        System.out.println(listView.getFocusModel().getFocusedIndex());  // in ra thu muc (giaa tri so ) cua index dang dc forcus
        System.out.println(listView.getFocusModel().getFocusedItem()); //in ra thuoc tinh dang dc giu trong index dang dc forcus

        System.out.println(listView.getFocusModel().isFocused(0)); // kiem tra xem index 0 co phai la index dc forcus hay k


        //

        listView.scrollTo(9); // cuon lisview toi vi index 9 sao cho ng dung co the thay dc index 9

        listView.setOnScrollTo(event -> { // ham nay dc goi khi ham scrollTo dc goi

            System.out.println("scrollTo index 9 ");

        });


        listView.setOnScroll(event -> { // ham dc goi khi nhg dung cuon thanh truot cua listview

            System.out.println("scrolling");

        });

        listView.setOnContextMenuRequested(event -> {
            // goi khi kich chout phai vao listview
            System.out.println("right clicked ");

        });


        listView.setOnMouseClicked(event -> {
            // goi khi kich chuot trai hoac phai vao listview
            System.out.println("mouse clicked ");

        });

        listView.setOnMouseDragged(event -> {

            // ham dc goi khi keo chuot o trong listview
            System.out.println("mouse draging ");

        });

        listView.setMouseTransparent(false); // neu la true thi nodes se bi ''trong suot' khoi chuot , tuc la moi event tu chuot cho nodes nay se bi vo hieu hoa

        listView.setOnMouseDragOver(event -> {

            System.out.println("mouse over ");

        });

        listView.setOnMouseEntered(event -> {

            System.out.println("mouse entered");

        });


        listView.setOnMouseMoved(event -> {
            // ham dc goi khi chuot di chuyen qua listview
            System.out.println("mouse moving ");

        });


        listView.setOnMousePressed(event -> {
            // goi khi chout dc bam
            System.out.println("mouse pressed");

        });


         listView.setOnZoom(event -> {

             System.out.println("Zomming");

         });



        StackPane layout= new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(listView);

        Scene scene= new Scene(layout,300,100);

        stage.setScene(scene);
        stage.setTitle("listviews");
        stage.show();





    }



    }

