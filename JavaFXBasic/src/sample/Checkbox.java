package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.*;

public class Checkbox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

      Label label= new Label("programing language");

      CheckBox box1= new CheckBox("Java");
      CheckBox box2= new CheckBox("C#");
      CheckBox box3= new CheckBox("Python");


      box1.setSelected(true);
      box2.setAllowIndeterminate(true);
      box3.setIndeterminate(true);

      Button button= new Button("submit");
      button.setOnAction(event -> {
          String message = "your language";

          if(box1.isSelected()==true)
          {
              message+=box1.getText();

          }
          if(box2.isSelected()==true)
          {
              message+=box2.getText();

          }
          if(box3.isSelected()==true)
          {
              message+=box3.getText();
          }

          System.out.println(message);
      });

        HBox layoutH= new HBox(10);
        layoutH.getChildren().addAll(box1,box2,box3);
        VBox layoutV = new VBox(20);
        layoutV.getChildren().addAll(label,layoutH,button);

        Scene scene= new Scene(layoutV,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
