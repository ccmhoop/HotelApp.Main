package Booking;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Booking implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GridPane gridpane = new GridPane();
        gridpane.add(new Label(), 24, 7);  // column=2 row=0
    }

}






