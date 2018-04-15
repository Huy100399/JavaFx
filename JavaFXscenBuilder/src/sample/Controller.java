package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField height;

    public void submit(ActionEvent event)
    {
        String h= height.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("chieu cao cua ban :"+h);
        alert.show();
    }

    public void event1()
    {
        System.out.println("draging");
    }


}
